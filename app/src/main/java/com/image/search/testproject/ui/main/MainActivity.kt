package com.image.search.testproject.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.image.search.testproject.R
import com.image.search.testproject.data.model.ImageModel
import com.image.search.testproject.ui.main.adapter.ImageAdapter
import com.image.search.testproject.utils.extensions.showMessage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ImageAdapter

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private val changeObserver = Observer<List<ImageModel>> { value ->
        value?.let { setDataToAdapter(value) }
    }

    private val showErrorObserver = Observer<Int> { value ->
        value?.let {
            if (value != 0)
                this.showMessage(value)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.changeListNotifier.observe(this, changeObserver)
        viewModel.changeErrorNotifier.observe(this, showErrorObserver)

        adapter = ImageAdapter()
        adapter.images = viewModel.getImages()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        detectSearch()
    }

    private fun detectSearch() {
        editText.setOnEditorActionListener() { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val text = editText.text.toString()
                if (text.length < 2)
                    Toast.makeText(this, getString(R.string.warning_need_more_letters), Toast.LENGTH_SHORT).show()
                else
                    viewModel.getImage(text)
                true
            } else {
                false
            }
        }
    }

    private fun setDataToAdapter(list: List<ImageModel>) {
        editText.text.clear()
        adapter?.images = list
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
