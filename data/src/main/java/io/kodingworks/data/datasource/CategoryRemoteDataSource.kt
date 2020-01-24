package io.kodingworks.data.datasource

import io.kodingworks.data.mapper.CategoryMapper
import io.kodingworks.data.remote.ApiService
import io.kodingworks.domain.models.Category
import io.reactivex.Flowable

/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */
interface CategoryRemoteDataSource {

    fun getCategories(): Flowable<List<Category>>

    class Remote(
        private val apiService: ApiService
    ) : CategoryRemoteDataSource {
        override fun getCategories(): Flowable<List<Category>> = apiService.getCategories().map {
            it.map(CategoryMapper::mapToDomain)
        }
    }
}