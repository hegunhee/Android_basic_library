package com.hegunhee.android_basic_library.advancedNoti.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LogDao {

    @Query("SELECT * FROM LogData")
    fun getAll() : List<LogData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(log : LogData)
}