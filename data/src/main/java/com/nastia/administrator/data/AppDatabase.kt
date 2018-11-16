package com.nastia.administrator.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.nastia.administrator.data.dao.OwlDao

@Database(entities = [OwlDb::class],
        version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "owls"

        fun getInstance(context: Context): AppDatabase {

            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration().build()
        }
    }

    abstract fun getOwlDao(): OwlDao
}