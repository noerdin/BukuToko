package com.example.bukutoko.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bukutoko.room.entity.ItemEntity

@Database(entities = [ItemEntity::class], version = 1)
abstract class BukuTokoDb: RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object{
        private var INSTANCE: BukuTokoDb? = null

        fun getInstance(context: Context): BukuTokoDb? {
            if (INSTANCE == null){
                synchronized(BukuTokoDb::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    BukuTokoDb::class.java, "BukuToko.db").build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}