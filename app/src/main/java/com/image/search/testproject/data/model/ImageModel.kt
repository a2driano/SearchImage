package com.image.search.testproject.data.model

import io.realm.RealmObject

open class ImageModel(
    var searchText: String = "",
    var imageUrl: String = "",
    var date: Long = System.currentTimeMillis()
) : RealmObject()