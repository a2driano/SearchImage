package com.image.search.testproject.ui.common

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    val dispose: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        dispose.clear()
        super.onCleared()
    }
}