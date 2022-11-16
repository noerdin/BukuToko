package com.example.bukutoko.data.repositori

import com.example.bukutoko.data.room.entity.ItemEntity

interface ItemRepositori {
    suspend fun insert(itemEntity: ItemEntity)
    suspend fun getAllitem(): List<ItemEntity>
}
