package com.example.bukutoko.data.room.datasource

import com.example.bukutoko.data.room.ItemDao
import com.example.bukutoko.data.room.entity.ItemEntity

class ItemDataSourceImpl(private val dao: ItemDao) : ItemDataSource {
    override suspend fun insertItem(itemEntity: ItemEntity): Long {
        return dao.insertItem(itemEntity)
    }

    override suspend fun getAllItem(): List<ItemEntity> {
        return dao.getAllItem()
    }

    override suspend fun updateItem(itemEntity: ItemEntity): Int {
        return dao.updateItem(itemEntity)
    }

    override suspend fun deleteItem(itemEntity: ItemEntity): Int {
        return dao.deleteItem(itemEntity)
    }
}