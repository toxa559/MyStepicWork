package com.example.mystepicwork.presentation

import androidx.lifecycle.ViewModel
import com.example.mystepicwork.data.ShopListRepositoryImpl
import com.example.mystepicwork.domain.DeleteShopListUseCase
import com.example.mystepicwork.domain.EditShopListUseCase
import com.example.mystepicwork.domain.GetShopListUseCase

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopListUseCase(repository)
    private val editShopListUseCase = EditShopListUseCase(repository)

    

}