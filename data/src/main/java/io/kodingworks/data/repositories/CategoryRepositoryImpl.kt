package io.kodingworks.data.repositories

import io.kodingworks.data.datasource.CategoryLocalDataSource
import io.kodingworks.data.datasource.CategoryRemoteDataSource
import io.kodingworks.domain.models.Category
import io.kodingworks.domain.repositories.CategoryRepository
import io.reactivex.Flowable

/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */
@Suppress("UNREACHABLE_CODE")
class CategoryRepositoryImpl(
    private val remoteDataSource: CategoryRemoteDataSource,
    private val localDataSource: CategoryLocalDataSource
) : CategoryRepository {
    override fun getCategories(isConnected: Boolean): Flowable<List<Category>> {
        return if (isConnected)
            remoteDataSource.getCategories()
        else
            localDataSource.getCategories()
    }
}