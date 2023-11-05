package com.baba_abdullah.warehousemanager.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.baba_abdullah.warehousemanager.utils.ValueOf

@Entity(tableName = ValueOf.WAREHOUSE_TABLE_NAME)
data class WarehouseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo
    val name: String,

    @ColumnInfo
    val createdBy: Int,

    @ColumnInfo
    val isDeleted: Boolean = false
)
