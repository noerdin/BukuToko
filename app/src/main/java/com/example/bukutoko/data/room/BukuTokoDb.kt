package com.example.bukutoko.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bukutoko.data.room.entity.ItemEntity

@Database(entities = [ItemEntity::class], version = 1)
abstract class BukuTokoDb: RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object{
        private var INSTANCE: BukuTokoDb? = null

        fun getInstance(context: Context): BukuTokoDb {

            return INSTANCE ?: run {
                synchronized(BukuTokoDb::class){
                    val db = Room.databaseBuilder(context.applicationContext,
                        BukuTokoDb::class.java, "BukuToko.db").build()
                    INSTANCE = db
                    db
                }
            }
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}