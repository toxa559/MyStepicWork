package com.example.mystepicwork.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mystepicwork.data.ShopListRepositoryImpl
import com.example.mystepicwork.domain.DeleteShopListUseCase
import com.example.mystepicwork.domain.EditShopListUseCase
import com.example.mystepicwork.domain.GetShopListUseCase
import com.example.mystepicwork.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopListUseCase(repository)
    private val editShopListUseCase = EditShopListUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList(){
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopListUseCase.deleteShopList(shopItem)
        getShopList()
    }

    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopListUseCase.editShopList(newItem)
        getShopList()
    }

}