package presentation.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseMvvmFragment<VM : BaseViewModel<R>,
        B : ViewDataBinding,
        R: BaseRouter<*>> : BaseFragment() {

    protected lateinit var viewModel: VM
    protected lateinit var binding: B //our view
    protected var router: R? = null

    abstract fun provideViewModel() : VM

    abstract fun provideLayoutId() : Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, provideLayoutId(), container,false)
        viewModel = provideViewModel()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity is BaseMvvmActivity<*,*,*>){
            router = (activity as BaseMvvmActivity<*,*,*>).router as R
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.addRouter(router)
        viewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        viewModel.removeRouter()
    }




}