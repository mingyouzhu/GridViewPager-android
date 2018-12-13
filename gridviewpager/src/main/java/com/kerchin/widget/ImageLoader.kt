package com.kerchin.widget

import android.content.Context
import android.widget.ImageView

interface ImageLoader<T> {
    fun load(context:Context,icon:T,imageView:ImageView)
}