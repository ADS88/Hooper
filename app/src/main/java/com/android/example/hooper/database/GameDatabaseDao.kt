package com.android.example.hooper.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface GameDatabaseDao{
    @Insert
    fun insert(game: Game)

    @Delete
    fun delete(game: Game)

    @Update
    fun update(game: Game)
}