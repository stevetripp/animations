package org.smt.animations.ux

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import org.smt.animations.MainViewModel
import org.smt.animations.inject.ViewModelFactory
import org.smt.animations.inject.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}
