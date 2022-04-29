package com.hegunhee.android_basic_library.advancedNoti.di

import android.content.Context
import androidx.room.Room
import com.hegunhee.android_basic_library.advancedNoti.db.LogDao
import com.hegunhee.android_basic_library.advancedNoti.db.LogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideLogDatabase(
        @ApplicationContext context : Context
    ) : LogDatabase = Room.databaseBuilder(context,LogDatabase::class.java,"logDB.db")
        .build()

    @Singleton
    @Provides
    fun provideLogDao(logDatabase: LogDatabase) : LogDao = logDatabase.logDao()
}