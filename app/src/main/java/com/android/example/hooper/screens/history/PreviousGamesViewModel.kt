package com.android.example.hooper.screens.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.android.example.hooper.database.GameDatabaseDao

class PreviousGamesViewModel(
    val database: GameDatabaseDao,
    application: Application
) : AndroidViewModel(application) {
}