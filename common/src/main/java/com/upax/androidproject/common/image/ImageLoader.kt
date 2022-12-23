package com.upax.androidproject.common.image

import android.net.Uri
import android.support.annotation.DrawableRes
import android.support.annotation.RawRes
import android.widget.ImageView
import java.io.File


interface ImageLoader {

    fun load(
        imageView: ImageView,
        uri: Uri?,
        @RawRes @DrawableRes placeholder: Int? = null,
        @RawRes @DrawableRes errorPlaceholder: Int? = null,
    )

    fun load(
        imageView: ImageView,
        @RawRes @DrawableRes resId: Int,
        @RawRes @DrawableRes placeholder: Int? = null,
        @RawRes @DrawableRes errorPlaceholder: Int? = null,
    )

    fun load(
        imageView: ImageView,
        file: File,
        @RawRes @DrawableRes placeholder: Int? = null,
        @RawRes @DrawableRes errorPlaceholder: Int? = null,
    )

    fun load(
        imageView: ImageView,
        path: String?,
        @RawRes @DrawableRes placeholder: Int? = null,
        @RawRes @DrawableRes errorPlaceholder: Int? = null,
    )

}
