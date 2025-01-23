package com.example.grazerapplication.data

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenManager @Inject constructor(@ApplicationContext private val context: Context) {
    companion object {
        private const val GRAZER_PREFS = "GRAZER_PREFS"
        private const val KEY_TOKEN = "JWT_TOKEN"
    }

    // Initialize encrypted shared preferences
    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val encryptedPrefs = EncryptedSharedPreferences.create(
        context,
        GRAZER_PREFS,
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    suspend fun saveToken(token: String) {
        withContext(Dispatchers.IO) {
            encryptedPrefs.edit().putString(KEY_TOKEN, token).apply()
        }
    }

    suspend fun getToken(): String? = withContext(Dispatchers.IO) {
        encryptedPrefs.getString(KEY_TOKEN, null)
    }

    suspend fun clearToken() {
       // Clear the token from encrypted shared preferences
    }

    fun hasValidToken() {
        // Check if the token is present
    }
}