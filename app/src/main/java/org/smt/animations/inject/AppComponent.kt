package org.smt.animations.inject

import android.app.Application
import org.smt.animations.App
import org.smt.animations.MainActivity
import org.smt.animations.ux.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(application: App)

    // UI
    fun inject(target: MainActivity)

    // Exported for child-components.
    fun application(): Application
}
