package repositories

import entity.Student
import entity.StudentSearch
import entity.transformToDomain
import io.reactivex.Completable
import io.reactivex.Observable
import net.RestService

class StudentRepositoryImpl(val apiService: RestService) : StudentRepository { // singleton on fact
    override fun get(): Observable<List<Student>> {

        return apiService.getStudents()
                .map {
                    it.map {
                        it.transformToDomain()
                    }
                }

//        val list = listOf(
//                Student(0, "Sergey", 25),
//                Student(1, "Kate", 30),
//                Student(2, "Alice", 20),
//                Student(3, "Alex", 21),
//                Student(4, "Ivan", 18))
//
//        return Observable.just(list)
    }

    override fun search(search: StudentSearch): Observable<List<Student>> {

        val list = listOf<Student>(
                Student(0, "Kate", 30),
                Student(1, "Alice", 20))

        return Observable.just(list)
    }

    override fun update(student: Student): Completable {
        return Completable.complete()
    }

    override fun delete(studentId: String): Completable {
        return Completable.complete()
    }
}