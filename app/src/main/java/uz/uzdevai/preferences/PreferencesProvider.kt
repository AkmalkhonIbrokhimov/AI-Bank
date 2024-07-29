package uz.uzdevai.preferences

import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesProvider @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    var token: String by sharedPreferences.string()

    fun clear(){
        sharedPreferences.edit().clear().apply()
    }
}