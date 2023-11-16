package com.ocean.demokotlinretrofit

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DKRApplication : Application() {

    /** Any custom initialization or configuration for your application.
        Dagger Hilt will generate the necessary code for the ApplicationComponent.
        You don't need to manually create the Dagger ApplicationComponent class. */
}