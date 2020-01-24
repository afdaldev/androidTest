package io.kodingworks.domain.repositories

import io.kodingworks.domain.models.Category
import io.reactivex.Flowable

/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */
interface CategoryRepository {
    fun getCategories(isConnected: Boolean): Flowable<List<Category>>
}