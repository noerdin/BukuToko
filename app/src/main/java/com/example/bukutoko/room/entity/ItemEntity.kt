package com.example.bukutoko.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "item_entity")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    @ColumnInfo(name = "namaBarang") var namaBarang: String?,
    @ColumnInfo(name = "hargaJual") var hargaJual: Int,
    @ColumnInfo(name = "satuan") var satuan: String?,
    @ColumnInfo(name = "stok") var stok: Int
)