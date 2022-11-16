package com.example.bukutoko

import android.app.Application
import com.example.bukutoko.data.repositori.ItemRepositori
import com.example.bukutoko.data.repositori.ItemRepositoriImpl
import com.example.bukutoko.data.room.BukuTokoDb
import com.example.bukutoko.data.room.datasource.ItemDataSource
import com.example.bukutoko.data.room.datasource.ItemDataSourceImpl

class BukuTokoApplication : Application() {
    val database by lazy { BukuTokoDb.getInstance(this) }
    val dataSource : ItemDataSource by lazy { ItemDataSourceImpl(database.itemDao()) }
    val repositori : ItemRepositori by lazy { ItemRepositoriImpl(dataSource) }
}