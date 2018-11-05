package presentation.screen.owl

import android.os.Bundle
import com.nastia.administrator.presentation.R
import presentation.base.BaseActivity

class OwlActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if (savedInstanceState==null)
            OwlRouter(this).goToList()
    }
}