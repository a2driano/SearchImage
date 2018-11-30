package com.image.search.testproject.utils.extensions

import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

fun Long.getStringDate(): String {
    val sdf = SimpleDateFormat("HH:mm  dd/MM/yyyy")
    val netDate = Date(this)
    return sdf.format(netDate)
}

fun Context.showMessage(resource: Int) {
    Toast.makeText(this, getText(resource), Toast.LENGTH_SHORT).show()
}