package com.example.s09_sharedpreferences
import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREF_NAME = "AppS9Preferences"

        const val KEY_USERNAME = "username"
        const val KEY_IS_FIRST_TIME = "is_first_time"
        const val KEY_USER_ID = "user_id"

        // NUEVA CLAVE
        const val KEY_DARK_MODE = "dark_mode"

        const val KEY_SELECTED_NAV_ITEM = "selected_nav_item"

        const val KEY_NOMBRES = "nombres"
        const val KEY_APELLIDOS = "apellidos"
        const val KEY_EDAD = "edad"
        const val KEY_EMAIL = "email"
    }


    fun saveString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String, defaultValue: String = ""): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun saveBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun saveInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun getInt(key: String, defaultValue: Int = 0): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }

}