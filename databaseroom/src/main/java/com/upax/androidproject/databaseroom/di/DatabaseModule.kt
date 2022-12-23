package com.upax.androidproject.databaseroom.di

import android.content.Context
import com.upax.androidproject.databaseroom.data.datasourceimplementation.database.AppRoomDatabaseImpl
import com.upax.androidproject.databaseroom.domain.datasourceabstraction.AppRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppRoomDatabase(@ApplicationContext context: Context): AppRoomDatabase =
        AppRoomDatabaseImpl.getInstance(context)

}