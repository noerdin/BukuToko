package com.example.bukutoko.room.datasource

import com.example.bukutoko.room.ItemDao
import com.example.bukutoko.room.entity.ItemEntity

class ItemDataSourceImpl(private val dao: ItemDao) : ItemDataSource {
    override fun insertItem(itemEntity: ItemEntity): Long {
        return dao.insertItem(itemEntity)
    }

    override fun getAllItem(): List<ItemEntity> {
        return dao.getAllItem()
    }

    override fun updateItem(itemEntity: ItemEntity): Int {
        return dao.updateItem(itemEntity)
    }

    override fun deleteItem(itemEntity: ItemEntity): Int {
        return dao.deleteItem(itemEntity)
    }
}