package com.upax.androidproject.common.di

import com.squareup.picasso.Picasso
import com.upax.androidproject.common.image.ImageLoader
import com.upax.androidproject.common.image.ImageLoaderWrapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
internal object ImageModule {

    @Provides
    fun provideCorePicasso(): Picasso = Picasso.get()

    @Provides
    fun provideCoreImageLoader(picasso: Picasso): ImageLoader = ImageLoaderWrapper(picasso)

}
