package com.example.dialogresizingissue

import android.app.Application
import com.lokalise.sdk.Lokalise
import com.lokalise.sdk.LokaliseCallback
import com.lokalise.sdk.LokaliseUpdateError
import timber.log.Timber

class DialogResizingIssueApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Lokalise.init(
            this,
            "",
            ""
        )
        Lokalise.isPreRelease = BuildConfig.DEBUG
        Lokalise.updateTranslations()
    }
}