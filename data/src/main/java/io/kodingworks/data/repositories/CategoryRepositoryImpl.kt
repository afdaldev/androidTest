package io.kodingworks.data.repositories

import android.util.Log.d
import io.kodingworks.data.datasource.CategoryLocalDataSource
import io.kodingworks.data.datasource.CategoryRemoteDataSource
import io.kodingworks.data.local.model.CategoryModel
import io.kodingworks.domain.models.Category
import io.kodingworks.domain.repositories.CategoryRepository
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

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
        when (isConnected) {
            true -> {
                d("TAG", "CONNECT")
                val data = remoteDataSource.getCategories()
                data.subscribeOn(Schedulers.io())
                    .subscribe { categoryList ->
                        categoryList.forEach {
                            val category = CategoryModel(it.id, it.name, it.image, it.menuOrder)
                            localDataSource.insertCategory(category)
                        }
                    }
                return data
            }
            else -> {
                d("TAG", "NOT CONNECT")
                return localDataSource.getCategories()
            }
        }
    }
}