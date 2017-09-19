package com.example.android.shoppingcart.ui

import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class MainPresenterTest {

    @Mock private lateinit var view: MainView
    @InjectMocks private lateinit var loginPresenter: MainPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkTotalResult() {
        loginPresenter.makeOrder(1, 0, 1)

        verify(view).setTotalPrice(8.0)
    }

    @Test
    fun checkTotalResultWhenTotalPriceIsBiggerThen20() {
        loginPresenter.makeOrder(5, 3, 6)

        verify(view).setTotalPrice(70.2)
    }

    @Test
    fun checkBreadDiscount() {
        loginPresenter.makeOrder(7, 0, 0)

        verify(view).setTotalPrice(15.0)
    }
}