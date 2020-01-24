package io.kodingworks.androidtest

import android.app.Application
import io.kodingworks.androidtest.di.appModules
import io.kodingworks.androidtest.di.categoriesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(listOf(appModules, categoriesModule))
        }
    }
}