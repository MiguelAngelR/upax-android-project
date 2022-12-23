package com.upax.androidproject.network.di

import com.upax.androidproject.network.service.PokemonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ServiceModule {

    @Singleton
    @Provides
    fun providePokemonService(@CoreRetrofit retrofit: Retrofit): PokemonService =
        retrofit.create(PokemonService::class.java)

}