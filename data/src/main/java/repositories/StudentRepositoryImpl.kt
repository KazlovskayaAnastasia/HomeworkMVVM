package repositories

import com.nastia.administrator.data.dao.OwlDao
import entity.Owl
import entity.StudentSearch
import entity.transformToDomain
import io.reactivex.Completable
import io.reactivex.Observable
import net.RestService

class StudentRepositoryImpl(val apiService: RestService, val owlDao: OwlDao) : StudentRepository { // singleton on fact
    override fun get(): Observable<List<Owl>> {

        return apiService.getOwls()
                .map {
                    it.map {
                        it.transformToDomain()
                    }
                }

//        val list = listOf(
//                Owl(0, "Sergey", 25),
//                Owl(1, "Kate", 30),
//                Owl(2, "Alice", 20),
//                Owl(3, "Alex", 21),
//                Owl(4, "Ivan", 18))
//
//        return Observable.just(list)
    }

    override fun search(search: StudentSearch): Observable<List<Owl>> {

        val list = listOf<Owl>(
                Owl("0", "Kate", 30, "http://rylik.ru/uploads/posts/2015-07/1436173430_owl-collection-1-11.jpg"),
                Owl("1", "Alice", 20, "http://rylik.ru/uploads/posts/2015-07/1436173430_owl-collection-1-11.jpg"))

        return Observable.just(list)
    }

    override fun update(owl: Owl): Completable {
        return Completable.complete()
    }

    override fun delete(studentId: String): Completable {
        return Completable.complete()
    }
}