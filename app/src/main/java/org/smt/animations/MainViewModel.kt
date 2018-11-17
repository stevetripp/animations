package org.smt.animations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel
@Inject
constructor() : ViewModel() {

    val clicked = MutableLiveData<Void>()

    fun onClick(){
        clicked.value = null
    }
}