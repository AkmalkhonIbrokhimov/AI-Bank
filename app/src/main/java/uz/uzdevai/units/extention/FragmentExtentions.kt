package uz.uzdevai.units.extention

import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment

fun Fragment.color(@ColorRes colorRes: Int) = requireContext().color(colorRes)