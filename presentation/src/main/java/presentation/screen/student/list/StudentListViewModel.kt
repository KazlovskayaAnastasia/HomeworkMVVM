package presentation.screen.student.list

import android.databinding.ObservableBoolean
import android.support.v7.widget.RecyclerView
import factories.UseCaseProvider
import io.reactivex.rxkotlin.subscribeBy
import presentation.base.BaseViewModel
import presentation.screen.student.StudentRouter

class StudentListViewModel : BaseViewModel<StudentRouter>() {
    override fun onResume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //поменять на свой адаптер
    val adapter: RecyclerView.Adapter<*>? = null

    val isProgressEnabled = ObservableBoolean(false)

    private val studentListUseCase = UseCaseProvider.provideGetStudentUseCase()
    private val searchStudentListUseCase = UseCaseProvider.provideSearchStudentUseCase()

    init {

        //ToDo При клике на юзера вызывать router.goToDetails()
        //adapter.setListener

        isProgressEnabled.set(true)
        val disposable = studentListUseCase.get().subscribeBy(
                onNext = {
                    //ToDo передать данные в адаптер
                    isProgressEnabled.set(false)
                },
                onError = {
                    router?.showError(it)
                    isProgressEnabled.set(false)
                }
        )
        addToDisposible(disposable)
    }
}