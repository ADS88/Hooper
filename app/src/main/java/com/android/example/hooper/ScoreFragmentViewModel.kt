package com.android.example.hooper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreFragmentViewModel: ViewModel(){
    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    init {
        _number.value = 0
    }

    fun addNumber(){
        _number.value = (_number.value)?.plus(1)
    }
}