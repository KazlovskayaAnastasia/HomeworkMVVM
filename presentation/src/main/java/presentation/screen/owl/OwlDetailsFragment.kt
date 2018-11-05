package presentation.screen.owl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nastia.administrator.presentation.databinding.FragmentOwlDetailsBinding
import com.nastia.administrator.presentation.databinding.FragmentOwlListBinding
import presentation.base.BaseMvvmFragment

class OwlDetailsFragment : BaseMvvmFragment<OwlDetailsViewModel, FragmentOwlDetailsBinding, OwlRouter>(){
    override fun provideViewModel(): OwlDetailsViewModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun provideLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {

        private const val ID_EXTRA = "ID_EXTRA"
        fun getInstance(id:String): OwlDetailsFragment {
            val fragment = OwlDetailsFragment()
            val bundle = Bundle()
            bundle.putString(ID_EXTRA, id)
            fragment.arguments = bundle
            return OwlDetailsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}