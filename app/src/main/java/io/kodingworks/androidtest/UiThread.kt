package io.kodingworks.androidtest

import io.kodingworks.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by DhytoDev on 2020-01-24.
 * Email : dhytodev@gmail.com
 */

class UiThread : PostExecutionThread {
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}