package com.example.mystepicwork.data

import com.example.mystepicwork.domain.ShopItem
import com.example.mystepicwork.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }else{
            shopList.add(shopItem)
        }


    }

    override fun deleteShopList(shopItem: ShopItem) {
      shopList.remove(shopItem)
    }

    override fun editShopList(shopItem: ShopItem) {
       val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}