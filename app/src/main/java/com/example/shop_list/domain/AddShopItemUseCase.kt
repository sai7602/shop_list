package com.example.shop_list.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(shopItem:ShopItem){
       shopListRepository.addShopItem(shopItem)
    }
}