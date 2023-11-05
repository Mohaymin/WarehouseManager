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
    fun getAll(): Flow<WarehouseEntity>
}