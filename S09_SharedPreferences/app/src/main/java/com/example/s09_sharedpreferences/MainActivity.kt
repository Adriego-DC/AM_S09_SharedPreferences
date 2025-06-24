package com.example.s09_sharedpreferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.s09_sharedpreferences.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferencesHelper = SharedPreferencesHelper(this)
        val isDarkMode = sharedPreferencesHelper.getBoolean(
            SharedPreferencesHelper.KEY_DARK_MODE, false
        )

        AppCompatDelegate.setDefaultNightMode(
            if (isDarkMode) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Restaurar la selección previa del menú
        val selectedItemId = sharedPreferencesHelper.getInt(
            SharedPreferencesHelper.KEY_SELECTED_NAV_ITEM, R.id.menu_nav
        )
        binding.bottomNavigationView.selectedItemId = selectedItemId
        loadFragmentFromItemId(selectedItemId)

        // Manejar cambios de selección
        binding.bottomNavigationView.setOnItemSelectedListener {
            sharedPreferencesHelper.saveInt(SharedPreferencesHelper.KEY_SELECTED_NAV_ITEM, it.itemId)
            loadFragmentFromItemId(it.itemId)
            true
        }
        // Aumentar contador de aperturas
        val prefs = SharedPreferencesHelper(this)
        val contador = prefs.getInt(ContadorFragment.KEY_APP_OPEN_COUNT, 0)
        prefs.saveInt(ContadorFragment.KEY_APP_OPEN_COUNT, contador + 1)
    }

    private fun loadFragmentFromItemId(itemId: Int) {
        when (itemId) {
            R.id.menu_nav -> {
                replaceFragment(MenuFragment())
                binding.tvTitulo.text = "Menu"
            }
            R.id.contador_nav -> {
                replaceFragment(ContadorFragment())  // Sigue vacío
                binding.tvTitulo.text = "Contador"
            }
            R.id.tema_nav -> {
                replaceFragment(TemaFragment())
                binding.tvTitulo.text = "Tema"
            }
            R.id.perfil_nav -> {
                replaceFragment(PerfilFragment())
                binding.tvTitulo.text = "Perfil"
            }
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }
}
