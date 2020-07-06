package com.android.example.hooper.screens.history

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.hooper.database.GameDatabaseDao

class PreviousGamesViewModelFactory(private val dataSource: GameDatabaseDao, private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PreviousGamesViewModel::class.java)) {
            return PreviousGamesViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
