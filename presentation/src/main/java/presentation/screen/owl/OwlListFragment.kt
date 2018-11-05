package presentation.screen.owl

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nastia.administrator.presentation.BR
import com.nastia.administrator.presentation.R
import com.nastia.administrator.presentation.databinding.FragmentOwlListBinding
import presentation.base.BaseFragment
import presentation.base.BaseMvvmFragment

class OwlListFragment: BaseMvvmFragment<OwlListViewModel, FragmentOwlListBinding, OwlRouter>() {

    companion object {
        fun getInstance() = OwlListFragment()
    }


    override fun provideViewModel(): OwlListViewModel {
        return ViewModelProviders.of(this)
                .get(OwlListViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_owl_list

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        binding.setVariable(BR.adapter, OwlAdapter(object : OwlAdapter.OnItemSelectedListener {
            override fun itemSelected(position: Int) {
                viewModel.adapterTapListener()
            }
        }))
//        viewModel.adapter = OwlAdapter( object : OwlAdapter.OnItemSelectedListener {
//            override fun itemSelected(position: Int) {
//                viewModel.adapterTapListener()//fragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(R.id.fragment, OwlDetailsFragment.newInstance(listItems[position], position))?.commit()
//            }
//        })
    }
}