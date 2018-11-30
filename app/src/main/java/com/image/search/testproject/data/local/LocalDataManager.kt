package com.image.search.testproject.data.local

import com.image.search.testproject.data.model.ImageModel
import io.realm.Realm
import io.realm.Sort

object LocalDataManager {

    /** get all models from db */
    fun getImages(): List<ImageModel> {
        var list = mutableListOf<ImageModel>()
        Realm.getDefaultInstance().executeTransaction { realm ->
            val result = realm.where(ImageModel::class.java).findAll().sort("date", Sort.DESCENDING)
            list = realm.copyFromRealm(result)
        }
        return list
    }

    /** add new model to db */
    fun addImage(model: ImageModel) {
        Realm.getDefaultInstance().executeTransaction { realm ->
            val dataObject = realm.createObject(ImageModel::class.java)
            dataObject.searchText = model.searchText
            dataObject.imageUrl = model.imageUrl
            dataObject.date = model.date
        }
    }
}