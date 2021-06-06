package com.target.targetcasestudy.presentation.interfaces

import com.target.targetcasestudy.domain.model.ProductsItem

interface DealsAdapterListener {
    fun displayDeal(deal: ProductsItem?)
}