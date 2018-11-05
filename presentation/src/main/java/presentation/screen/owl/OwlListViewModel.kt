package presentation.screen.owl

import android.util.Log
import factories.UseCaseProvider
import io.reactivex.internal.util.HalfSerializer.onNext
import io.reactivex.rxkotlin.subscribeBy
import presentation.base.BaseViewModel

class OwlListViewModel : BaseViewModel<OwlRouter>() {

    private val getOwlUseCase = UseCaseProvider.provideGetStudentUseCase()
    var adapter: OwlAdapter
    var isProgressEnabled: Boolean = true

    init {
        adapter = OwlAdapter( object : OwlAdapter.OnItemSelectedListener {
            override fun itemSelected(position: Int) {
                adapterTapListener()
            }
        })
    }
    override fun onResume() {
        val disposible = getOwlUseCase.get().subscribeBy(
                onNext = {
                    adapter.setElements(it)
                },
                onError = {
                    Log.e("AAAError", it.toString())
                },
                onComplete = {

                }
        )
        addToDisposible(disposible)
    }

    fun adapterTapListener(){

    }
}