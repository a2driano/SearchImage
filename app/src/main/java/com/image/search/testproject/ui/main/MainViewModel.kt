package com.image.search.testproject.ui.main

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.image.search.testproject.R
import com.image.search.testproject.data.local.LocalDataManager
import com.image.search.testproject.data.model.ImageModel
import com.image.search.testproject.data.model.ImageModelDTO
import com.image.search.testproject.data.remote.RemoteDataManager
import com.image.search.testproject.ui.common.BaseViewModel
import com.image.search.testproject.utils.converter.convertDtoToModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MainViewModel : BaseViewModel() {

    val changeListNotifier = MutableLiveData<List<ImageModel>>()
    val changeErrorNotifier = MutableLiveData<Int>()

    fun getImage(search: String) {
        dispose.add(
            RemoteDataManager.getImageFromSearch(search)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { t ->
                    val list: List<ImageModelDTO> = t.data
                    if (list.isEmpty()) {
                        changeErrorNotifier.value = R.string.error_search_no_result
                        changeErrorNotifier.value = 0
                        return@Consumer
                    }
                    val modelDto = list[0]
                    modelDto.searchText = search
                    modelDto.imageUrl = modelDto.images.imageData.url
                    LocalDataManager.addImage(convertDtoToModel(modelDto))
                    //refresh adapter after new item was add
                    changeListNotifier.value = getImages()
                }, Consumer { t ->
                    Log.e("MainViewModel", "--- error: ${t.message}")
                })
        )
    }

    fun getImages(): List<ImageModel> {
        return LocalDataManager.getImages()
    }
}