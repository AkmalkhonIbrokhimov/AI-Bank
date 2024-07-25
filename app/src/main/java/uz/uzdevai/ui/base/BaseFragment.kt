package uz.uzdevai.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import uz.uzdevai.R
import uz.uzdevai.units.extention.color

abstract class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBackgroundColorToScreen(view)
        setUp()

    }

    abstract fun setUp()

    fun setUp(view: View){}

    open fun setBackgroundColorToScreen(view: View, color: Int = R.color.colorSurface) {
        view.setBackgroundColor(color(color))
    }

}