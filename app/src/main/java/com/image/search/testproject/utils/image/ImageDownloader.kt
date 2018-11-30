package com.image.search.testproject.utils.image

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_layout.view.*

fun setImageToView(view: ImageView, url: String) {
    val options = RequestOptions()
    options.centerInside()
    options.diskCacheStrategy(DiskCacheStrategy.ALL)
    Glide.with(view.context)
        .load(url)
        .apply(options)
        .into(view)
}