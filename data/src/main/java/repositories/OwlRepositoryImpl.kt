package repositories

import com.nastia.administrator.data.dao.OwlDao
import com.nastia.administrator.data.transformToDB
import entity.Owl
import entity.StudentSearch
import entity.transformToDomain
import io.reactivex.Completable
import io.reactivex.Observable
import net.RestService

class OwlRepositoryImpl(private val apiService: RestService, private val owlDao: OwlDao) : StudentRepository { // singleton on fact
    override fun get(): Observable<List<Owl>> {

        return apiService.getOwls()
                .flatMap {
                    apiService.getOwls()
                            .doOnNext {
                                val list = it.map { it.transformToDB() }
                                owlDao.deleteAll()
                                owlDao.insert(list)
                            }
                            .map { list ->
                                list.map { student -> student.transformToDomain() }
                            }
                }
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