package com.android.example.hooper.screens.history

import android.app.Application
import android.util.Log
import android.util.Log.d
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.android.example.hooper.database.Game
import com.android.example.hooper.database.GameDatabaseDao
import com.android.example.hooper.formatGames
import kotlinx.coroutines.*
import java.util.logging.Logger

class PreviousGamesViewModel(
    val database: GameDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private val games = database.getAllGames()
    val gamesString = Transformations.map(games) {
        games -> formatGames(games, application.resources)
    }

}