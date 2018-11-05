package com.nastia.administrator.domain.usecases

import entity.Owl
import executor.PostExecutorThread
import io.reactivex.Observable
import repositories.StudentRepository

class GetStudentsUseCase(postExecutorThread: PostExecutorThread,
                         private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {



    fun get(): Observable<List<Owl>> {
        return studentRepository.get()
                .observeOn(postExecutorThread)//шде получить ответ
                .subscribeOn(workExecutorThread)//где выполнить

    }
}