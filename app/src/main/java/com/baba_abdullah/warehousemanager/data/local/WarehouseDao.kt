package com.baba_abdullah.warehousemanager.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.baba_abdullah.warehousemanager.ValueOf
import kotlinx.coroutines.flow.Flow

@Dao
interface WarehouseDao {
    @Insert
    fun insertAll(vararg warehouses: WarehouseEntity): List<Long>

    @Query("SELECT * FROM ${ValueOf.WAREHOUSE_TABLE_NAME}")
    fun getAll(): Flow<List<WarehouseEntity>>

    @Query("SELECT * FROM ${ValueOf.WAREHOUSE_TABLE_NAME} WHERE isDeleted = 0")
    fun getActiveWarehouses(): Flow<List<WarehouseEntity>>
}