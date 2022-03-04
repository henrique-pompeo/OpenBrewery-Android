package com.henrique.shared.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Update
import com.henrique.shared.data.database.entities.BreweryEntity

@Dao
interface BreweryDao {

    @Query("SELECT * FROM breweries")
    suspend fun getBreweryList() : List<BreweryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBrewery(brewery: BreweryEntity)

    @Update
    suspend fun updateBrewery(brewery: BreweryEntity)

    @Delete
    suspend fun deleteBrewery(brewery: BreweryEntity)
}