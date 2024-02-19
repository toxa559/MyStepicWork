package com.example.mystepicwork.domain

interface ShopListRepository {

    fun  addShopItem(shopItem: ShopItem)

    fun deleteShopList(shopItem: ShopItem)

    fun editShopList(shopItem: ShopItem)

    fun getShopItem(shopItemId : Int) : ShopItem

    fun getShopList(): List<ShopItem>
}