package com.android.example.hooper.screens.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreFragmentViewModel: ViewModel(){
    private val _teamOneScore = MutableLiveData<Int>()
    val teamOneScore: LiveData<Int>
        get() = _teamOneScore

    private val _teamTwoScore = MutableLiveData<Int>()
    val teamTwoScore: LiveData<Int>
        get() = _teamTwoScore

    init {
        _teamOneScore.value = 0
        _teamTwoScore.value = 0
    }

    fun addTeamOne(number: Int){
        _teamOneScore.value = (_teamOneScore.value)?.plus(number)
    }

    fun addTeamTwo(number: Int){
        _teamTwoScore.value = (_teamTwoScore.value)?.plus(number)
    }

    fun resetGame(){
        _teamOneScore.value = 0
        _teamTwoScore.value = 0
    }
}