package com.w1nxclub.winxvideo.di

import android.content.Context
import androidx.room.Room
import com.w1nxclub.winxvideo.data.local.WinxDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): WinxDatabase {
        return Room.databaseBuilder(
            context,
            WinxDatabase::class.java,
            "prime_db.db"
        ).fallbackToDestructiveMigration().build()
    }
}