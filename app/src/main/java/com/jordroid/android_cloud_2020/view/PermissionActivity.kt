package com.jordroid.android_cloud_2020.view

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.jordroid.android_cloud_2020.R
import kotlinx.android.synthetic.main.activity_permission.*

class PermissionActivity : AppCompatActivity() {

    companion object {
        const val PERMISSION_STORAGE_READ_PERMISSION = 42
        const val PERMISSION_STORAGE_WRITE_PERMISSION = 43
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        buttonPermissionStorageWrite.setOnClickListener { askStorageWritePermission() }
        buttonPermissionStorageRead.setOnClickListener { askLocationPermission() }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permission granted
        } else {
            if (permissions.isNotEmpty() && shouldExplainPermission(permissions[0])) {
                displaySnackBarPermission(permissions[0])
            }
        }
    }

    private fun askStorageWritePermission() {
        askPermission(
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            PERMISSION_STORAGE_WRITE_PERMISSION
        )
    }

    private fun askLocationPermission() {
        askPermission(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            PERMISSION_STORAGE_READ_PERMISSION
        )
    }

    private fun askPermission(permissionName: String, permissionCode: Int) {
        if (!checkIfPermissionIsGranted(permissionName)) {
            requestPermission(permissionName, permissionCode)
        } else {
            Toast.makeText(this, "Permission $permissionName is already granted", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkIfPermissionIsGranted(permissionName: String): Boolean {
        return ContextCompat.checkSelfPermission(this, permissionName) == PackageManager.PERMISSION_GRANTED
    }

    private fun shouldExplainPermission(permissionName: String): Boolean =
        ActivityCompat.shouldShowRequestPermissionRationale(this, permissionName)

    private fun requestPermission(permissionName: String, permissionCode: Int) =
        ActivityCompat.requestPermissions(this, arrayOf(permissionName), permissionCode)

    private fun displaySnackBarPermission(permissionName: String) {
        Snackbar.make(contentPermission, "We need the permission $permissionName for performing some task", Snackbar.LENGTH_LONG).setAction("Retry") {
            if (permissionName == android.Manifest.permission.ACCESS_FINE_LOCATION) {
                askLocationPermission()
            } else {
                askStorageWritePermission()
            }
        }.show()
    }
}