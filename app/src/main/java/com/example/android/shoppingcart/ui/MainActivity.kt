package com.example.android.shoppingcart.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.android.shoppingcart.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        setupButtons()

    }

    private fun setupButtons() {
        firstProductMinusBtn.setOnClickListener { presenter.onMinusClick(firstProductQuantity.text.toString().toInt(), 1) }
        secondProductMinusBtn.setOnClickListener { presenter.onMinusClick(secondProductQuantity.text.toString().toInt(), 2) }
        thirdProductMinusBtn.setOnClickListener { presenter.onMinusClick(thirdProductQuantity.text.toString().toInt(), 3) }


        firstProductPlusBtn.setOnClickListener { presenter.onPlusClick(firstProductQuantity.text.toString().toInt(), 1) }
        secondProductPlusBtn.setOnClickListener { presenter.onPlusClick(secondProductQuantity.text.toString().toInt(), 2) }
        thirdProductPlusBtn.setOnClickListener { presenter.onPlusClick(thirdProductQuantity.text.toString().toInt(), 3) }


        makeOrderBtn.setOnClickListener {
            presenter.makeOrder(firstProductQuantity.text.toString().toInt(),
                    secondProductQuantity.text.toString().toInt(), thirdProductQuantity.text.toString().toInt())
        }
    }

    fun getCurrentQuantity(pos: Int): Int {
        when (pos) {
            1 -> return firstProductQuantity.text.toString().toInt()
            2 -> return secondProductQuantity.text.toString().toInt()
            3 -> return thirdProductQuantity.text.toString().toInt()
            else -> return 0
        }
    }

    override fun getTotalPrice(): String = totalPriceTextView.text.toString()

    override fun disableButton(pos: Int) {
        when (pos) {
            1 -> firstProductMinusBtn.isEnabled = false
            2 -> secondProductMinusBtn.isEnabled = false
            3 -> thirdProductMinusBtn.isEnabled = false
        }
    }

    override fun enableButton(pos: Int) {
        when (pos) {
            1 -> firstProductMinusBtn.isEnabled = true
            2 -> secondProductMinusBtn.isEnabled = true
            3 -> thirdProductMinusBtn.isEnabled = true
        }
    }

    override fun updateQuantity(pos: Int, value: Int) {
        when (pos) {
            1 -> firstProductQuantity.text = (firstProductQuantity.text.toString().toInt() + value).toString()
            2 -> secondProductQuantity.text = (secondProductQuantity.text.toString().toInt() + value).toString()
            3 -> thirdProductQuantity.text = (thirdProductQuantity.text.toString().toInt() + value).toString()
        }
    }

    override fun setTotalPrice(price: Double) {
        val text = "Razem: " + price.toString() + "$"
        totalPriceTextView.text = text
    }
}
