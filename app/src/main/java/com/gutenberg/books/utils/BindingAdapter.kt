package com.gutenberg.books.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("android:imageView")
fun ImageView.setImageViewResource(resource: Int) {
    setImageResource(resource)
}