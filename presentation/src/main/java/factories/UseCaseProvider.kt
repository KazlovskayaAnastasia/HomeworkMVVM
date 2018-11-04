package factories

import com.nastia.administrator.domain.usecases.GetStudentsUseCase
import com.nastia.administrator.domain.usecases.SearchStudentsUseCase
import executor.UIThread
import net.RestService
import repositories.StudentRepositoryImpl

object UseCaseProvider {

    //класс для реализации РЕСТ
    val restService = RestService("")

    //реализация интерфейса из домена, чтобы сказать в каком потоке выполнять
    val uiThread = UIThread()

    fun provideGetStudentUseCase():GetStudentsUseCase{



        val repository = StudentRepositoryImpl(restService)

        val useCase = GetStudentsUseCase(uiThread, repository)
        return useCase
    }

    fun provideSearchStudentUseCase(): SearchStudentsUseCase {
        return SearchStudentsUseCase(uiThread, StudentRepositoryImpl(restService))
    }
}