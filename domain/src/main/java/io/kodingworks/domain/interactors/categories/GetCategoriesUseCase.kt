package io.kodingworks.domain.interactors.categories

import io.kodingworks.domain.executor.PostExecutionThread
import io.kodingworks.domain.interactors.FlowableUseCase
import io.kodingworks.domain.models.Category
import io.kodingworks.domain.repositories.CategoryRepository
import io.reactivex.Flowable

/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */

class GetCategoriesUseCase(
    postExecutionThread: PostExecutionThread,
    private val repository: CategoryRepository
) : FlowableUseCase<List<Category>, Boolean>(postExecutionThread) {
    override fun buildUseCaseFlowable(params: Boolean?): Flowable<List<Category>> {
        requireNotNull(params) { "params can't be null" }

        return repository.getCategories(params)
    }
}