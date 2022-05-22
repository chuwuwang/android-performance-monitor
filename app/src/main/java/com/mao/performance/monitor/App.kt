package com.mao.performance.monitor

import android.app.Application
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.mao.performance.monitor.help.Logger
import com.mao.performance.monitor.hook.FaHook
import com.mao.performance.monitor.hook.MethodHook
import com.mao.performance.monitor.hook.MethodParameter

class App : Application() {

    companion object {

        const val TAG = "APM"

    }

    override fun onCreate() {
        super.onCreate()
        hook()
    }

    private fun hook() {
        val methodHook = object : MethodHook {

            override fun beforeHookedMethod(param: MethodParameter ? ) {
                Logger.e(TAG, "beforeHookedMethod param: $param")
            }

            override fun afterHookedMethod(param: MethodParameter ? ) {
                Logger.e(TAG, "afterHookedMethod param: $param")
            }

        }
        FaHook.findAndHookMethod(ImageView::class.java, "setImageBitmap", Bitmap::class.java, methodHook)
        FaHook.findAndHookMethod(ImageView::class.java, "setImageResource", Int::class.java, methodHook)
        FaHook.findAndHookMethod(ImageView::class.java, "setImageDrawable", Drawable::class.java, methodHook)
    }

}