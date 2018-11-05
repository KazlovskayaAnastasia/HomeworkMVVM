package com.nastia.administrator.domain.usecases

import entity.Owl
import entity.StudentSearch
import executor.PostExecutorThread
import io.reactivex.Observable
import repositories.StudentRepository

class SearchStudentsUseCase(postExecutorThread: PostExecutorThread,
                            private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {

    fun search(searchStudent: StudentSearch): Observable<List<Owl>> {
        return studentRepository.search(searchStudent)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)

    }
}