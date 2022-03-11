package com.henrique.shared.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.henrique.shared.data.database.entities.BreweryEntity

@Dao
interface BreweryDao {

    @Query("SELECT * FROM breweries")
    suspend fun getBreweryList() : List<BreweryEntity>

    @Query("SELECT * FROM breweries WHERE id = :id")
    suspend fun getBreweryById(id: String) : BreweryEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBreweryList(breweryList: List<BreweryEntity>)
}