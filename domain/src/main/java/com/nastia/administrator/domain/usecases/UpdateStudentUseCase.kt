package com.nastia.administrator.domain.usecases

import entity.Owl
import executor.PostExecutorThread
import io.reactivex.Completable
import repositories.StudentRepository

class UpdateStudentUseCase(postExecutorThread: PostExecutorThread,
                           private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {

    fun update(owl: Owl) : Completable{
        return studentRepository.update(owl)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}
