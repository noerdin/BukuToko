package com.example.bukutoko.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.bukutoko.data.repositori.ItemRepositori
import com.example.bukutoko.data.room.entity.ItemEntity
import kotlinx.coroutines.launch

class DashboardViewModel(private val repositori: ItemRepositori): ViewModel() {

    val allItem = MutableLiveData<List<ItemEntity>>()

    fun insert(itemEntity: ItemEntity) {
        viewModelScope.launch {
            repositori.insert(itemEntity)
        }
    }

    fun getAllItem() {
        viewModelScope.launch {
            allItem.value = repositori.getAllitem()
        }
    }

    class DashboardViewModelFactory(private val repositori: ItemRepositori) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
                return DashboardViewModel(repositori) as T
            }

            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}