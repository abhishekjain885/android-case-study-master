package com.target.targetcasestudy.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.target.targetcasestudy.domain.model.DealsList
import com.target.targetcasestudy.domain.usecase.GetDealsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DealsViewModel @Inject constructor(private val getDealsListUseCase: GetDealsListUseCase) :
    ViewModel() {

    private val dealsLiveData = MutableLiveData<DealsList>()
    private val isLoad = MutableLiveData<Boolean>()

    init {
        isLoad.value = true
    }

    fun loadDeals() {
        getDealsListUseCase.execute(
            onSuccess = {
                isLoad.value = false
                dealsLiveData.value = it
            },
            onError = {
                it.printStackTrace()
            }

        )
    }

    fun getDeals(): LiveData<DealsList> {
        return dealsLiveData
    }

    fun isDataLoading(): LiveData<Boolean> {
        return isLoad
    }

    override fun onCleared() {
        super.onCleared()
        getDealsListUseCase.dispose()
    }

}