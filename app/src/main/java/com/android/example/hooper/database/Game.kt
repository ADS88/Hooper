package com.android.example.hooper.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat
import java.util.*

@Entity
data class Game  (
    @PrimaryKey(autoGenerate = true)
    var gameId: Long = 0L,
    val teamOneScore: Int,
    val teamTwoScore: Int,
    val gameDate: String = DateFormat.getDateInstance().format(Calendar.getInstance().time)
)