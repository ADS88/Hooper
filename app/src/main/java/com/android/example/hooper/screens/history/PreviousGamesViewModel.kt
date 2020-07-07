package com.android.example.hooper.screens.history

import android.app.Application
import android.util.Log
import android.util.Log.d
import androidx.lifecycle.AndroidViewModel
import com.android.example.hooper.database.Game
import com.android.example.hooper.database.GameDatabaseDao
import kotlinx.coroutines.*
import java.util.logging.Logger

class PreviousGamesViewModel(
    val database: GameDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    val ioScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    init {
        getGames1()
    }

    fun getGames1(){
        ioScope.launch {
            getGames2()
        }
    }

    suspend fun getGames2(){
       withContext(Dispatchers.IO){
            val games: List<Game> = database.getAllGames()
            Log.d("ooga", games.toString())
        }
    }

}