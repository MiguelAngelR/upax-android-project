package com.upax.androidproject.common.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.net.Uri
import android.util.Base64
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.core.content.ContextCompat
import com.upax.androidproject.common.image.ImageLoader
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream

fun ImageView.load(
    imageLoader: ImageLoader,
    @RawRes @DrawableRes resId: Int,
    @RawRes @DrawableRes placeholder: Int? = null,
    @RawRes @DrawableRes errorPlaceholder: Int? = null,
) = imageLoader.load(
    imageView = this,
    resId = resId,
    placeholder = placeholder,
    errorPlaceholder = errorPlaceholder
)


fun ImageView.load(
    imageLoader: ImageLoader,
    uri: Uri?,
    @DrawableRes placeholder: Int? = null,
    @DrawableRes errorPlaceholder: Int? = null,
) = imageLoader.load(
    imageView = this,
    uri = uri,
    placeholder = placeholder,
    errorPlaceholder = errorPlaceholder
)


fun ImageView.load(
    imageLoader: ImageLoader,
    file: File,
    @DrawableRes placeholder: Int? = null,
    @DrawableRes errorPlaceholder: Int? = null,
) = imageLoader.load(
    imageView = this,
    file = file,
    placeholder = placeholder,
    errorPlaceholder = errorPlaceholder
)


fun ImageView.load(
    imageLoader: ImageLoader,
    path: String?,
    @DrawableRes placeholder: Int? = null,
    @DrawableRes errorPlaceholder: Int? = null,
) = imageLoader.load(
    imageView = this,
    path = path,
    placeholder = placeholder,
    errorPlaceholder = errorPlaceholder
)

fun Bitmap.toBase64(): String? =
    try {
        val stream = ByteArrayOutputStream()
        this.compress(Bitmap.CompressFormat.PNG, 100, stream)
        val b = stream.toByteArray()
        Base64.encodeToString(b, Base64.DEFAULT)
    } catch (e: Exception) {
        null
    }


fun String.base64ToBitmap(): Bitmap? =
    try {
        val decodedString = Base64.decode(this, Base64.DEFAULT)
        BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
    } catch (e: Exception) {
        null
    }


fun InputStream.toBase64(): String? =
    try {
        val bitmap = BitmapFactory.decodeStream(this)
        bitmap.toBase64()
    } catch (e: Exception) {
        null
    }


fun Int.drawableResToBitmap(context: Context): Bitmap {
    // below line is use to generate a drawable.
    val vectorDrawable = ContextCompat.getDrawable(context, this)

    // below line is use to set bounds to our vector drawable.
    vectorDrawable!!.setBounds(0, 0, vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight)

    // below line is use to create a bitmap for our
    // drawable which we have added.
    val bitmap = Bitmap.createBitmap(
        vectorDrawable.intrinsicWidth,
        vectorDrawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888,
    )

    // below line is use to add bitmap in our canvas.
    val canvas = Canvas(bitmap)

    // below line is use to draw our
    // vector drawable in canvas.
    vectorDrawable.draw(canvas)

    return bitmap
}