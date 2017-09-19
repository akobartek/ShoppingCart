package com.example.android.shoppingcart.ui

interface MainView {
    fun disableButton(pos: Int)
    fun updateQuantity(pos: Int, value: Int)
    fun enableButton(pos: Int)
    fun setTotalPrice(price: Double)
    fun getTotalPrice(): String
}