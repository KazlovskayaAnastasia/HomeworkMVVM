package com.nastia.administrator.domain.usecases

import executor.PostExecutorThread
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCase(val postExecutorThread: Scheduler,
                           val workExecutorThread: Scheduler = Schedulers.io()) {

    constructor(postExecutorThread: PostExecutorThread) : this(postExecutorThread.getScheduler())


}