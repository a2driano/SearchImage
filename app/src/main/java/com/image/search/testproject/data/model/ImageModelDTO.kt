package com.image.search.testproject.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ImageModelDTO(
    var searchText: String,
    var imageUrl: String,
    @SerializedName("images") var images: Images
) : Serializable

data class Images(
    @SerializedName("fixed_height_still") var imageData: FixedHeightStill
) : Serializable

data class FixedHeightStill(
    @SerializedName("url") var url: String
) : Serializable

data class DataModelDto(
    var data: List<ImageModelDTO>
) : Serializable