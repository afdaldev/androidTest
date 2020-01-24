package io.kodingworks.data.remote

import io.kodingworks.data.remote.model.CategoriesResponse
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */
interface ApiService {
    @GET("products/categories")
    fun getCategories(): Flowable<List<CategoriesResponse>>
}