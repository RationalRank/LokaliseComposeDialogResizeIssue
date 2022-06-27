package com.example.dialogresizingissue

import android.content.Context
import android.content.ContextWrapper
import android.content.res.AssetManager
import android.content.res.Resources
import android.os.Build
import com.lokalise.sdk.LokaliseResources
import kotlin.jvm.internal.Intrinsics


class CustomResourceContextWrapper(val context: Context): ContextWrapper(context) {

    override fun getResources(): Resources {
        val c1 = context.getResources().getConfiguration()
        val c2 = context.getApplicationContext().getResources().getConfiguration()
        if (Build.VERSION.SDK_INT >= 24) {
            c1.setLocales(c2.getLocales())
        } else {
            c1.locale = c2.locale
        }
        val assets: AssetManager = context.getApplicationContext().getAssets()
        val resources: Resources = context.getResources()
        return LokaliseResources(assets, resources)
    }
}