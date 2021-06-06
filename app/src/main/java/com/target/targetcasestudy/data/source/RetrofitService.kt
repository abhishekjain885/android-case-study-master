package com.target.targetcasestudy.data.source

import com.target.targetcasestudy.domain.model.DealsList
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {

    @GET("deals/")
    fun getDeals(): Single<DealsList>
    //fun getAlbums(): Single<List<Album>>

   /* @GET("deals/{id}/")
    fun getPhotos(@Path("id") id: Long): Single<List<Photo>>*/
}