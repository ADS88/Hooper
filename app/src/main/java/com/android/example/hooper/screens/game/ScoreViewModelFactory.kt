package com.android.example.hooper.screens.game

import com.android.example.hooper.screens.game.ScoreViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.hooper.database.GameDatabaseDao

class ScoreViewModelFactory(private val dataSource: GameDatabaseDao, private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
