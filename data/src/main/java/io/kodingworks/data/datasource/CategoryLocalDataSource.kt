package io.kodingworks.data.datasource

import io.kodingworks.data.local.db.DatabaseFactory
import io.kodingworks.data.local.model.CategoryModel
import io.kodingworks.data.mapper.CategoryLocalMapper
import io.kodingworks.domain.models.Category
import io.reactivex.Flowable

/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */

/*
*   TODO : Add Implementation of local data source here. Local data source should be have capability for store, get, and delete categories to/from local database
*
* */
interface CategoryLocalDataSource {

    fun getCategories(): Flowable<List<Category>>
    fun insertCategory(category: CategoryModel)
    fun deleteCategory()

    class Local(private val databaseFactory: DatabaseFactory) : CategoryLocalDataSource {
        override fun getCategories(): Flowable<List<Category>> =
            databaseFactory.categoryDao().getCategoryFromLocal().map {
                it.map(CategoryLocalMapper::mapToDomain)
            }

        override fun insertCategory(category: CategoryModel) {
            databaseFactory.categoryDao().insertCategory(category)
        }

        override fun deleteCategory() {
            databaseFactory.categoryDao().deleteCategory()
        }
    }
}