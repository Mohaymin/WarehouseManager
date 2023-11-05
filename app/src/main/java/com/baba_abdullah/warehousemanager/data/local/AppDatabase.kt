package com.baba_abdullah.warehousemanager.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.baba_abdullah.warehousemanager.utils.ValueOf

@Database(entities = [WarehouseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getWarehouseDao(): WarehouseDao

    companion object {
        private var database: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    ValueOf.APP_DATABASE_NAME
                ).build()
            }
            return database as AppDatabase
        }
    }
}