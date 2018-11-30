package com.image.search.testproject.data.remote

import com.image.search.testproject.data.model.DataModelDto
import com.image.search.testproject.data.remote.api.RetrofitCreator
import io.reactivex.Single

object RemoteDataManager {

    fun getImageFromSearch(search: String): Single<DataModelDto> {
        return RetrofitCreator.getImage(search)
    }
}