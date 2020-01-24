package io.kodingworks.androidtest.di

import io.kodingworks.androidtest.BuildConfig
import io.kodingworks.androidtest.UiThread
import io.kodingworks.androidtest.viewmodels.CategoryViewModel
import io.kodingworks.data.datasource.CategoryLocalDataSource
import io.kodingworks.data.datasource.CategoryRemoteDataSource
import io.kodingworks.data.local.db.DatabaseFactory
import io.kodingworks.data.remote.ServiceFactory
import io.kodingworks.data.repositories.CategoryRepositoryImpl
import io.kodingworks.domain.executor.PostExecutionThread
import io.kodingworks.domain.interactors.categories.GetCategoriesUseCase
import io.kodingworks.domain.repositories.CategoryRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.experimental.builder.single

/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */

val appModules = module {
    single<PostExecutionThread> { UiThread() }
    single {
        ServiceFactory.makeService(
            isDebug = BuildConfig.DEBUG,
            baseUrl = "https://api.tumbasin.id/v1/"
        )
    }
}

val categoriesModule = module {
    single { DatabaseFactory.getDatabase(androidContext()) }
    single<CategoryRemoteDataSource> { CategoryRemoteDataSource.Remote(get()) }
    single<CategoryLocalDataSource> { CategoryLocalDataSource.Local(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get(), get()) }
    factory { GetCategoriesUseCase(get(), get()) }
    viewModel { CategoryViewModel(get(), get()) }
}