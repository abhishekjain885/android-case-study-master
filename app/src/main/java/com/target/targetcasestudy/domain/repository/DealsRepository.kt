package com.target.targetcasestudy.domain.repository

import com.target.targetcasestudy.domain.model.DealsList
import io.reactivex.Single

interface DealsRepository {

    fun getDeals(): Single<DealsList>
}