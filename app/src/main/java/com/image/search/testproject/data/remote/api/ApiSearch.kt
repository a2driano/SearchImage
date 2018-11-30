package com.image.search.testproject.data.remote.api

import com.image.search.testproject.data.model.DataModelDto
import com.image.search.testproject.data.remote.api.ApiConst.SEARCH
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSearch {
    @GET(SEARCH)
    fun getImage(
        @Query("q") input: CharSequence,
        @Query("api_key") key: String = ApiConst.KEY,
        @Query("limit") limit: Int = 1
    ): Single<DataModelDto>
}