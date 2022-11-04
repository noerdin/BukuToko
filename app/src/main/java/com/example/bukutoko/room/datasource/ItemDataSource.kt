package com.example.bukutoko.room.datasource

import com.example.bukutoko.room.entity.ItemEntity

interface ItemDataSource {
    fun insertItem(itemEntity: ItemEntity): Long
    fun getAllItem(): List<ItemEntity>
    fun updateItem(itemEntity: ItemEntity): Int
    fun deleteItem(itemEntity: ItemEntity): Int
}