package com.example.mystepicwork.domain

class DeleteShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopList(shopItem: ShopItem){
        shopListRepository.deleteShopList(shopItem)
    }
}