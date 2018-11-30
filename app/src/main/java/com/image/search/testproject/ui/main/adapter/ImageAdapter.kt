package com.image.search.testproject.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.image.search.testproject.R
import com.image.search.testproject.data.model.ImageModel
import com.image.search.testproject.utils.extensions.getStringDate
import kotlinx.android.synthetic.main.item_layout.view.*
import com.image.search.testproject.utils.image.setImageToView


class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    var images: List<ImageModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ImageViewHolder {
        return ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.itemView.apply {
            searchText.text = images[position].searchText
            date.text = images[position].date.getStringDate()
            setImageToView(image, images[position].imageUrl)
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}