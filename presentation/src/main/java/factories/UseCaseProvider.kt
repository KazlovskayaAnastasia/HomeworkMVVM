package factories

import com.nastia.administrator.domain.usecases.GetStudentsUseCase
import com.nastia.administrator.domain.usecases.SearchStudentsUseCase
import executor.UIThread
import net.RestService
import repositories.StudentRepositoryImpl

object UseCaseProvider {

    //класс для реализации РЕСТ
    val restService = RestService("https://api.backendless.com/37691FA0-1ABE-651B-FFD3-C4631AB3BA00/B720E356-CD44-0AA6-FFCC-EB910C4BCB00/")

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