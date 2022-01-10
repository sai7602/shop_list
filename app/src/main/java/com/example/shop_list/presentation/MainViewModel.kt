package com.example.shop_list.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shop_list.data.ShopListRepositoryImpl
import com.example.shop_list.domain.DeleteShopItemUseCase
import com.example.shop_list.domain.EditShopItemUseCase
import com.example.shop_list.domain.GetShopListUseCase
import com.example.shop_list.domain.ShopItem

class MainViewModel : ViewModel() {
    private val repository = ShopListRepositoryImpl


    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableStatus(shopItem: ShopItem) {

        val newItem = shopItem.copy(enable = !shopItem.enable)
        editShopItemUseCase.editShopItem(newItem)

    }
}