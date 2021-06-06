package com.target.targetcasestudy.domain.usecase

import com.target.targetcasestudy.domain.model.DealsList
import com.target.targetcasestudy.domain.repository.DealsRepository
import com.target.targetcasestudy.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetDealsListUseCase @Inject constructor(private val dealsRepository: DealsRepository) :
    SingleUseCase<DealsList>() {

    override fun buildUseCaseSingle(): Single<DealsList> {
        return dealsRepository.getDeals()
    }
}