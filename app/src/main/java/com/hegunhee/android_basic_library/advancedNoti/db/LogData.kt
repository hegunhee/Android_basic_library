package com.hegunhee.android_basic_library.advancedNoti.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LogData(
    @ColumnInfo(name = "log") val log : String,
    @ColumnInfo(name = "date") val date : String,
    @PrimaryKey(autoGenerate = true) val primaryKey : Int = 0
) {
}