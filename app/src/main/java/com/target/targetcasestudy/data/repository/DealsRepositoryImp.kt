package com.target.targetcasestudy.data.repository

import com.target.targetcasestudy.data.source.RetrofitService
import com.target.targetcasestudy.domain.model.DealsList
import com.target.targetcasestudy.domain.repository.DealsRepository
import io.reactivex.Single

class DealsRepositoryImp(private val retrofitService: RetrofitService) : DealsRepository {
    override fun getDeals(): Single<DealsList> {
        return retrofitService.getDeals()
    }
}