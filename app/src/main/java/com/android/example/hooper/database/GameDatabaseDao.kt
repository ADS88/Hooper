package com.android.example.hooper.database

import androidx.room.*

@Dao
interface GameDatabaseDao{
    @Insert
    fun insert(game: Game)

    @Delete
    fun delete(game: Game)

    @Update
    fun update(game: Game)

    @Query("Select * FROM game")
    fun getAllGames(): List<Game>
}