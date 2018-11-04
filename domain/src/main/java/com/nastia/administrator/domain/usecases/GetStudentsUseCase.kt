package com.nastia.administrator.domain.usecases

import entity.Student
import executor.PostExecutorThread
import io.reactivex.Observable
import repositories.StudentRepository

class GetStudentsUseCase(postExecutorThread: PostExecutorThread,
                         private val studentRepository: StudentRepository) : BaseUseCase(postExecutorThread) {



    fun get(): Observable<List<Student>> {
        return studentRepository.get()
                .observeOn(postExecutorThread)//шде получить ответ
                .subscribeOn(workExecutorThread)//где выполнить

    }
}