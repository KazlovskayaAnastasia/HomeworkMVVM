package presentation.screen.owl

import android.view.View
import com.nastia.administrator.presentation.R
import presentation.base.BaseRouter

class OwlRouter(activity: OwlActivity) // отвечает за переходы между экранами
    :BaseRouter<OwlActivity>(activity) {

    fun goToList(){

        replaceFragment(activity.supportFragmentManager,
                OwlListFragment.getInstance(),
                R.id.main_container,
                false)
    }

    fun goToDetails(id:String){

        val containerDetails =  activity.findViewById<View>(R.id.containerDetails)

        val containerResId : Int

        if (containerDetails == null){
            replaceFragment(activity.supportFragmentManager,
                    OwlDetailsFragment.getInstance(id),
                    R.id.main_container,
                    false)
        }else{
            replaceFragment(activity.supportFragmentManager,
                    OwlDetailsFragment.getInstance(id),
                    R.id.containerDetails,
                    false)
        }


    }

    fun requireActivity() = activity.applicationContext
}