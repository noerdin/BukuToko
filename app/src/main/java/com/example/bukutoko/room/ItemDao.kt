package com.example.bukutoko.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.bukutoko.room.entity.ItemEntity

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(itemEntity: ItemEntity): Long

    @Query("SELECT * FROM item_entity")
    fun getAllItem(): List<ItemEntity>

    @Update
    fun updateItem(itemEntity: ItemEntity): Int

    @Delete
    fun deleteItem(itemEntity: ItemEntity): Int

}