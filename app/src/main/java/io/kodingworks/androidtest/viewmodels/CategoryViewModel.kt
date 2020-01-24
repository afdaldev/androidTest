package io.kodingworks.androidtest.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.kodingworks.androidtest.state.Resource
import io.kodingworks.androidtest.state.ResourceState
import io.kodingworks.data.datasource.CategoryLocalDataSource
import io.kodingworks.domain.interactors.categories.GetCategoriesUseCase
import io.kodingworks.domain.models.Category
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */

class CategoryViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val localDataSource: CategoryLocalDataSource
) : ViewModel() {

    val categories by lazy {
        MutableLiveData<Resource<List<Category>>>()
    }

    override fun onCleared() {
        super.onCleared()
        getCategoriesUseCase.dispose()
    }

    fun getCategories(isConnected: Boolean) {
        categories.value = Resource(ResourceState.LOADING, null, null)
        getCategoriesUseCase.execute(object : DisposableSubscriber<List<Category>>() {
            override fun onComplete() {
            }

            override fun onNext(t: List<Category>?) {
                categories.postValue(Resource(ResourceState.SUCCESS, t, null))
            }

            override fun onError(t: Throwable?) {
                categories.value = Resource(ResourceState.ERROR, null, t?.message)
            }
        }, isConnected)
    }

    fun deleteCategoryFromLocal(id: Int?) = localDataSource.deleteCategory(id)
}