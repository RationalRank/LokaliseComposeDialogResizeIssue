package com.example.dialogresizingissue

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dialogresizingissue.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lokalise.sdk.LokaliseContextWrapper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LokaliseContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRedirect.setOnClickListener {
            startActivityForResult(
                Intent(this, TabbedActivity::class.java),
                100
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val orientation = resources.configuration.orientation
        when(orientation) {
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT -> {
                Toast.makeText(
                    this,
                    "Orientation is portrait",
                    Toast.LENGTH_SHORT
                ).show()
            }
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE -> {
                Toast.makeText(
                    this,
                    "Orientation is landscape",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {
                Toast.makeText(
                    this,
                    "Orientation is $orientation",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        MaterialAlertDialogBuilder(this)
            .setTitle("Title")
            .setMessage("message")
            .setNeutralButton("Dismiss") { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }
            .show()
    }
}