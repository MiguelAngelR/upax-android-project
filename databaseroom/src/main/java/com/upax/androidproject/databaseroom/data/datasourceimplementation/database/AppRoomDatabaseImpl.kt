package com.upax.androidproject.databaseroom.data.datasourceimplementation.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.upax.androidproject.databaseroom.data.datasourceimplementation.database.AppRoomDatabaseImpl.Companion.DB_VERSION
import com.upax.androidproject.databaseroom.domain.datasourceabstraction.AppRoomDatabase
import com.upax.androidproject.databaseroom.domain.entity.model.PokemonEntity


@Database(
    entities = [
        PokemonEntity::class
    ],
    version = DB_VERSION,
)
@TypeConverters()
internal abstract class AppRoomDatabaseImpl : RoomDatabase(), AppRoomDatabase {

    companion object {

        private const val DB_NAME = "app.db"
        const val DB_VERSION = 1

        @Volatile
        private var instance: AppRoomDatabaseImpl? = null

        internal fun getInstance(context: Context): AppRoomDatabaseImpl =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context): AppRoomDatabaseImpl =
            Room.databaseBuilder(context, AppRoomDatabaseImpl::class.java, DB_NAME)
                .build()

    }
}