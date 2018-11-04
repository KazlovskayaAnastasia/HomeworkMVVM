package presentation.screen.student.details

import android.databinding.ObservableBoolean
import presentation.base.BaseViewModel
import presentation.screen.student.StudentRouter

class StudentDetailsViewModel : BaseViewModel<StudentRouter>() {
    override fun onResume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var studentId : String

    fun setStudentId(id: String) {

        if(studentId != null) return
        studentId = id

        //ToDo тут будет вызов UseCase, который возвращает студента по ID
    }
    val isProgressEnabled = ObservableBoolean(false)

    init {

    }
}