package io.kodingworks.domain.interactors

import io.kodingworks.domain.executor.PostExecutionThread
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T, in Params>(private val postExecutionThread: PostExecutionThread) {

    private val compositeDisposable = CompositeDisposable()

    protected abstract fun buildUseCaseSingle(params: Params? = null): Single<T>

    open fun execute(singleObserver: DisposableSingleObserver<T>, params: Params? = null) {
        val single =
            buildUseCaseSingle(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.scheduler)

        addDisposable(single.subscribeWith(singleObserver))
    }

    private fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun dispose() {
        if (!compositeDisposable.isDisposed) compositeDisposable.dispose()
    }
}
