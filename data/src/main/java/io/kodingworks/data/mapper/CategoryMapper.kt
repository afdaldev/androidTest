package io.kodingworks.data.mapper

import io.kodingworks.data.local.model.CategoryModel
import io.kodingworks.data.remote.model.CategoriesResponse
import io.kodingworks.domain.models.Category

/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */

object CategoryMapper : EntityMapper<CategoriesResponse, Category> {
    override fun mapToDomain(type: CategoriesResponse): Category = with(type) {
        Category(id, name, image?.src, menuOrder)
    }
}

object CategoryLocalMapper : EntityMapper<CategoryModel, Category> {
    override fun mapToDomain(type: CategoryModel): Category = with(type) {
        Category(id, name, image, menuOrder)
    }
}