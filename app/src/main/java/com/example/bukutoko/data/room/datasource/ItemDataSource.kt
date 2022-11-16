package com.example.bukutoko.data.room.datasource

import com.example.bukutoko.data.room.entity.ItemEntity

interface ItemDataSource {
    suspend fun insertItem(itemEntity: ItemEntity): Long
    suspend fun getAllItem(): List<ItemEntity>
    suspend fun updateItem(itemEntity: ItemEntity): Int
    suspend fun deleteItem(itemEntity: ItemEntity): Int
}