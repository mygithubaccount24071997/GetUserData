package com.application.fetchuserdata.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication:Application() {

    companion object{
        lateinit var instance :BaseApplication
    }
    override fun onCreate() {
        super.onCreate()

        instance = this
    }


    }