package com.qrcodegen.app.platform

import android.annotation.SuppressLint
import android.app.Application

@SuppressLint("StaticFieldLeak")
object AppContextHolder {
    lateinit var instance: Application
        private set
    fun init(app: Application) {
        instance = app
    }
}

fun getAppContext(): Application = AppContextHolder.instance

class AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppContextHolder.init(this)
    }
}
