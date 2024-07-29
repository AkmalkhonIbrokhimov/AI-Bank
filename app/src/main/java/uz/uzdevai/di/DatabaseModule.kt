package uz.uzdevai.di

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.uzdevai.preferences.PreferencesProvider
import uz.uzdevai.units.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return try {
            val masterKeyAlias =
                MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()
            EncryptedSharedPreferences.create(
                context,
                Constants.FileName.SHARED_PREF,
                masterKeyAlias,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        } catch (e: Exception) {
            Log.e("sharedPreferences exception", e.message ?: e.localizedMessage)
            context.getSharedPreferences(Constants.FileName.SHARED_PREF, Context.MODE_PRIVATE)
        }

    }

    @Provides
    @Singleton
    fun provideSharedPreferencesProvider(sharedPreferences: SharedPreferences) =
        PreferencesProvider(sharedPreferences)

}