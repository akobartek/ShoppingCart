package com.example.android.shoppingcart.ui


class MainPresenter(private val view: MainView) {

    fun onMinusClick(quantity: Int, productPosition: Int) {
        if (quantity == 1)
            view.disableButton(productPosition)
        view.updateQuantity(productPosition, -1)
    }

    fun onPlusClick(quantity: Int, productPosition: Int) {
        if (quantity == 0)
            view.enableButton(productPosition)
        view.updateQuantity(productPosition, 1)
    }

    fun makeOrder(breadQuantity: Int, beerQuantity: Int, milkQuantity: Int) {
        var totalPrice = breadQuantity * 3.0 + beerQuantity * 12.0 + milkQuantity * 5.0

        val numberOfFreeBreads = (breadQuantity / 3)
        totalPrice -= numberOfFreeBreads * 3

        if (totalPrice >= 20.0) totalPrice *= 0.9
        view.setTotalPrice(totalPrice)
    }


}