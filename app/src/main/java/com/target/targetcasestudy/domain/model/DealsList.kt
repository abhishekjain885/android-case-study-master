package com.target.targetcasestudy.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class DealsList(

    @field:SerializedName("products")
    val products: List<ProductsItem?>? = null
)

@Parcelize
data class SalePrice(

    @field:SerializedName("amount_in_cents")
    val amountInCents: Int? = null,

    @field:SerializedName("currency_symbol")
    val currencySymbol: String? = null,

    @field:SerializedName("display_string")
    val displayString: String? = null
) : Parcelable

@Parcelize
data class ProductsItem(

    @field:SerializedName("regular_price")
    val regularPrice: RegularPrice? = null,

    @field:SerializedName("image_url")
    val imageUrl: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("aisle")
    val aisle: String? = null,

    @field:SerializedName("sale_price")
    val salePrice: SalePrice? = null
) : Parcelable

@Parcelize
data class RegularPrice(

    @field:SerializedName("amount_in_cents")
    val amountInCents: Int? = null,

    @field:SerializedName("currency_symbol")
    val currencySymbol: String? = null,

    @field:SerializedName("display_string")
    val displayString: String? = null
) : Parcelable
