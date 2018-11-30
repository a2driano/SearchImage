package com.image.search.testproject.utils.converter

import com.image.search.testproject.data.model.ImageModel
import com.image.search.testproject.data.model.ImageModelDTO

fun convertDtoToModel(modelDto: ImageModelDTO): ImageModel {
    return ImageModel(modelDto.searchText, modelDto.imageUrl)
}

fun convertListDtoToListModel(modelsDto: List<ImageModelDTO>): List<ImageModel> {
    val listModel = mutableListOf<ImageModel>()
    for (model: ImageModelDTO in modelsDto)
        listModel.add(convertDtoToModel(model))
    return listModel
}