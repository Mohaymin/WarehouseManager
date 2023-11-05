package com.baba_abdullah.warehousemanager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.baba_abdullah.warehousemanager.data.local.WarehouseDao
import com.baba_abdullah.warehousemanager.data.local.WarehouseEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddWarehouseViewModel(private val warehouseDao: WarehouseDao) : ViewModel() {
    @Suppress("UNCHECKED_CAST")
    class Factory(private val warehouseDao: WarehouseDao) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AddWarehouseViewModel(warehouseDao) as T
        }
    }

    private val insertStatus = MutableLiveData<Boolean>()
    val isInsertSuccessful: LiveData<Boolean>
        get() = insertStatus

    fun saveWarehouse(warehouse: WarehouseEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            val insertedIdList = warehouseDao.insertAll(warehouse)
            insertStatus.postValue(
                insertedIdList.isNotEmpty() && insertedIdList.first() > 0
            )
        }
    }
}