package com.example.bukutoko.data.repositori

import com.example.bukutoko.data.room.datasource.ItemDataSource
import com.example.bukutoko.data.room.entity.ItemEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemRepositoriImpl(private val itemDataSource: ItemDataSource) : ItemRepositori {

    override suspend fun insert(itemEntity: ItemEntity) {
        withContext(Dispatchers.IO) { itemDataSource.insertItem(itemEntity) }
    }

    override suspend fun getAllitem(): List<ItemEntity> {
        return withContext(Dispatchers.IO) { itemDataSource.getAllItem() }
    }
}