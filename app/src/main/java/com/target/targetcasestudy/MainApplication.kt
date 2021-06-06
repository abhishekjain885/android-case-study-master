package com.target.targetcasestudy

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
       // MultiDex.install(this)
    }


    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
       // MultiDex.install(this)
    }

}