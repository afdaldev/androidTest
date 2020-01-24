package io.kodingworks.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.kodingworks.data.local.model.CategoryModel
import io.kodingworks.domain.models.Category
import io.reactivex.Flowable

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)

    @Query("SELECT * FROM ${CategoryModel.TABLE_NAME}")
    fun getCategoryFromLocal(): Flowable<List<CategoryModel>>

    @Query("DELETE FROM ${CategoryModel.TABLE_NAME} WHERE ${CategoryModel.COLUMN_ID} = :id")
    fun deleteCategoryById(id: Int)
}