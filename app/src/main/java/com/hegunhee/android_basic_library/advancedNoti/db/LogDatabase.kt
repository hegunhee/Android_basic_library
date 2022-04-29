package com.hegunhee.android_basic_library.advancedNoti.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LogData::class],version = 1,exportSchema =false )
abstract class LogDatabase : RoomDatabase() {
    abstract fun logDao() : LogDao
}