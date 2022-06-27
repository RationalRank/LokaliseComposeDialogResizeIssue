package com.example.dialogresizingissue

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dialogresizingissue.databinding.ActivityLandscapeBinding
import com.lokalise.sdk.LokaliseContextWrapper

class LandscapeActivity : AppCompatActivity() {

    lateinit var binding: ActivityLandscapeBinding

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LokaliseContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandscapeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFinish.setOnClickListener {
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}