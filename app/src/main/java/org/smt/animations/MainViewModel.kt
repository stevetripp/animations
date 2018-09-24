package org.smt.animations

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel
@Inject
constructor() : ViewModel() {

    val clicked = MutableLiveData<Void>()

    fun onClick(){
        clicked.value = null
    }
}