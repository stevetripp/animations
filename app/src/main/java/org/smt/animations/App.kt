package org.smt.animations

import android.support.multidex.MultiDexApplication
import com.jakewharton.threetenabp.AndroidThreeTen
import org.smt.animations.inject.Injector
import timber.log.Timber

class App : MultiDexApplication() {

    init {
        Injector.init(this)
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        // Initialize dependency injection
        Injector.get().inject(this)

        setupLogging()
    }

    private fun setupLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
