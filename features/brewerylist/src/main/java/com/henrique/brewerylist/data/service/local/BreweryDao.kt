package com.henrique.brewerylist.data.service.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.henrique.shared.data.local.BreweryEntity

interface BreweryDao {

    @Query("select * from breweries")
    fun getBreweryList() : List<BreweryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBrewery(brewery: BreweryEntity)

    @Query("UPDATE breweries SET name =:name, breweryType =:breweryType, street =:street, " +
            "address2 =:address2, address3 =:address3, city =:city, state =:state, " +
            "countyProvince =:countyProvince, postalCode =:postalCode, country =:country, " +
            "longitude =:longitude, latitude =:latitude, phone =:phone, websiteUrl =:websiteUrl, " +
            "updatedAt =:updatedAt, createdAt =:createdAt " +
            "where id=:id")
    fun updateBrewery(id: String, name: String?, breweryType: String?, street: String?,
                      address2: String?, address3: String?, city: String?, state: String?,
                      countyProvince: String?, postalCode: String?, country: String?,
                      longitude: String?, latitude: String?, phone: String?,  websiteUrl: String?,
                      updatedAt: String?, createdAt: String?)

    @Delete
    fun deleteBrewery(brewery: BreweryEntity)

}