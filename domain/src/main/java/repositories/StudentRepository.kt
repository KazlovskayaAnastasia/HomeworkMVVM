package repositories

import entity.Owl
import entity.StudentSearch
import io.reactivex.Completable
import io.reactivex.Observable

interface StudentRepository: BaseRepository {

    fun get(): Observable<List<Owl>>

    fun search(search: StudentSearch):Observable<List<Owl>>

    //ToDo реализовать возможность получить одного студента по ID
    //fun get(id:String):Observable<Owl>

    fun update(owl: Owl): Completable

    fun delete(studentId: String): Completable
}