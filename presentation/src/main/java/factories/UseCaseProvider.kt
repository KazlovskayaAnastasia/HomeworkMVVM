package factories

import app.App
import com.nastia.administrator.data.AppDatabase
import com.nastia.administrator.domain.usecases.GetStudentsUseCase
import com.nastia.administrator.domain.usecases.SearchStudentsUseCase
import executor.UIThread
import net.RestService
import repositories.OwlRepositoryImpl

object UseCaseProvider {

    //класс для реализации РЕСТ
    val restService = RestService("https://api.backendless.com/37691FA0-1ABE-651B-FFD3-C4631AB3BA00/B720E356-CD44-0AA6-FFCC-EB910C4BCB00/")

    //реализация интерфейса из домена, чтобы сказать в каком потоке выполнять
    val uiThread = UIThread()

    fun provideGetStudentUseCase():GetStudentsUseCase{

        val owlDao = AppDatabase.getInstance(App.instance.applicationContext).getOwlDao()

        val repository = OwlRepositoryImpl(restService, owlDao)

        val useCase = GetStudentsUseCase(uiThread, repository)
        return useCase
    }

    fun provideSearchStudentUseCase(): SearchStudentsUseCase {
        val owlDao = AppDatabase.getInstance(App.instance.applicationContext).getOwlDao()
        return SearchStudentsUseCase(uiThread, OwlRepositoryImpl(restService, owlDao))
    }
}