package com.android.example.hooper.screens.game

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.hooper.database.Game
import com.android.example.hooper.database.GameDatabaseDao
import kotlinx.coroutines.*
import java.text.DateFormat
import java.util.*

class ScoreViewModel(val database: GameDatabaseDao, application: Application) : AndroidViewModel(application) {
    private val _teamOneScore = MutableLiveData<Int>()
    private var viewModelJob = Job()

    val teamOneScore: LiveData<Int>
        get() = _teamOneScore

    private val _teamTwoScore = MutableLiveData<Int>()
    val teamTwoScore: LiveData<Int>
        get() = _teamTwoScore

    init {
        _teamOneScore.value = 0
        _teamTwoScore.value = 0
    }

    fun addTeamOne(number: Int) {
        _teamOneScore.value = (_teamOneScore.value)?.plus(number)
    }

    fun addTeamTwo(number: Int) {
        _teamTwoScore.value = (_teamTwoScore.value)?.plus(number)
    }

    fun resetGame() {
        _teamOneScore.value = 0
        _teamTwoScore.value = 0
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val ioScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    fun gameFinish(teamOneName: String, teamTwoName: String){
        ioScope.launch {
            saveGame(teamOneName, teamTwoName)
        }
    }

    suspend fun saveGame(teamOneName: String, teamTwoName: String){
        return withContext(Dispatchers.IO){
            val scoreOne = teamOneScore.value!!
            val scoreTwo = teamTwoScore.value!!
            val game: Game =  Game(0, scoreOne, scoreTwo, teamOneName, teamTwoName, DateFormat.getDateInstance().format(
                Calendar.getInstance().time))
            database.insert(game)
        }
    }
}