package com.baba_abdullah.warehousemanager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.baba_abdullah.warehousemanager.data.local.AppDatabase
import com.baba_abdullah.warehousemanager.data.local.WarehouseEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivityViewModel(private val database: AppDatabase) : ViewModel() {
    @Suppress("UNCHECKED_CAST")
    class Factory(private val database: AppDatabase) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainActivityViewModel(database) as T
        }
    }


    private val activeWarehouseData = MutableLiveData<List<WarehouseEntity>>()
    val activeWarehouses: LiveData<List<WarehouseEntity>>
        get() = activeWarehouseData

    fun fetchActiveWarehouses() {
        viewModelScope.launch(Dispatchers.IO) {
            database.getWarehouseDao().getActiveWarehouses().collect {
                activeWarehouseData.postValue(it)
            }
        }
    }
}