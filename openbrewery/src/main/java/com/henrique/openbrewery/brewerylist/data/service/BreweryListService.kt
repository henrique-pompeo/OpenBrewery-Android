package com.henrique.openbrewery.brewerylist.data.service

import com.henrique.openbrewery.brewerylist.data.dto.BreweryListItemDTO
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

internal interface BreweryListService {
    @GET
    suspend fun getBreweryList(
        @Url url: String = EMPTY,
        @Query(BY_CITY) city: String? = null,
        @Query(BY_COUNTRY) country: String? = null,
        @Query(BY_DIST) dist: String? = null,
        @Query(BY_IDS) ids: String? = null,
        @Query(BY_NAME) name: String? = null,
        @Query(BY_STATE) state: String? = null,
        @Query(BY_POSTAL) postal: String? = null,
        @Query(BY_TYPE) type: String? = null,
        @Query(PAGE) page: Int? = null,
        @Query(PER_PAGE) perPage: Int? = null,
        @Query(SORT) sort: String? = null
    ): List<BreweryListItemDTO>

    companion object {
        private const val EMPTY = ""
        private const val BY_CITY = "by_city"
        private const val BY_COUNTRY = "by_country"
        private const val BY_DIST = "by_dist"
        private const val BY_IDS = "by_ids"
        private const val BY_NAME = "by_name"
        private const val BY_STATE = "by_state"
        private const val BY_POSTAL = "by_postal"
        private const val BY_TYPE = "by_type"
        private const val PAGE = "page"
        private const val PER_PAGE = "per_page"
        private const val SORT = "sort"
    }
}
