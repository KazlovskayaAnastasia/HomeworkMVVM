package presentation.screen.student

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.nastia.administrator.presentation.R
import com.nastia.administrator.presentation.databinding.ActivityStudentLandBinding
import presentation.base.BaseMvvmActivity

class StudentActivity : BaseMvvmActivity<StudentViewModel, ActivityStudentLandBinding, StudentRouter>() {

    override fun provideRouter(): StudentRouter {
        return StudentRouter(this)
    }

    override fun provideViewModel(): StudentViewModel {
        return ViewModelProviders.of(this)
                .get(StudentViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.activity_main

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding.text_view.setText(" ")
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState == null){
            router.goToStudentList()
        }
    }

    override fun onPause() {
        super.onPause()

    }
}
