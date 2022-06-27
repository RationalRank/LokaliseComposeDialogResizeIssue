package com.example.dialogresizingissue

import android.content.Context
import android.content.ContextWrapper
import com.lokalise.sdk.utils.LokaliseInitException
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import io.github.inflationx.viewpump.ViewPumpContextWrapper.Companion.wrap
import kotlin.jvm.internal.DefaultConstructorMarker
import kotlin.jvm.internal.Intrinsics


class CustomContextWrapper {

    companion object {

        fun wrap(context: Context): ContextWrapper {
            return ViewPumpContextWrapper.wrap(CustomResourceContextWrapper(context))
        }
    }
}