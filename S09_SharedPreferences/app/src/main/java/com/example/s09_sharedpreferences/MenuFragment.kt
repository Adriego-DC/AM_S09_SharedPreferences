package com.example.s09_sharedpreferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.s09_sharedpreferences.SharedPreferencesHelper.Companion.KEY_IS_FIRST_TIME
import com.example.s09_sharedpreferences.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    // NUEVA VARIABLE: evita mostrar el Toast varias veces
    private var yaMostroBienvenida = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        sharedPreferencesHelper = SharedPreferencesHelper(requireContext())

        setupListeners()
        checkFirstTime()

        return binding.root
    }

    private fun setupListeners() {
        binding.buttonSave.setOnClickListener {
            val username = binding.editTextUsername.text.toString().trim()
            if (username.isEmpty()) {
                Toast.makeText(requireContext(), "Por favor ingresa un nombre", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            sharedPreferencesHelper.saveString(SharedPreferencesHelper.KEY_USERNAME, username)
            sharedPreferencesHelper.saveBoolean(SharedPreferencesHelper.KEY_IS_FIRST_TIME, false)
            sharedPreferencesHelper.saveInt(SharedPreferencesHelper.KEY_USER_ID, (1000..9999).random())

            Toast.makeText(requireContext(), "Datos guardados exitosamente", Toast.LENGTH_SHORT).show()
            binding.editTextUsername.setText("")
        }

        binding.buttonLoad.setOnClickListener {
            val username = sharedPreferencesHelper.getString(SharedPreferencesHelper.KEY_USERNAME, "Sin nombre")
            val isFirstTime = sharedPreferencesHelper.getBoolean(SharedPreferencesHelper.KEY_IS_FIRST_TIME, true)
            val userId = sharedPreferencesHelper.getInt(SharedPreferencesHelper.KEY_USER_ID, 0)
            val result = "Usuario: $username\nID: $userId\nPrimera vez: ${if (isFirstTime) "Sí" else "No"}"
            binding.textViewResult.text = result
        }

        binding.buttonClear.setOnClickListener {
            sharedPreferencesHelper.clearAll()
            binding.textViewResult.text = ""
            binding.editTextUsername.setText("")
            Toast.makeText(requireContext(), "Todas las preferencias han sido eliminadas", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkFirstTime() {
        if (!yaMostroBienvenida) {
            val wasShown = sharedPreferencesHelper.getBoolean("shown_welcome_toast", false)
            val isFirstTime = sharedPreferencesHelper.getBoolean(KEY_IS_FIRST_TIME, true)

            if (isFirstTime && !wasShown) {
                Toast.makeText(context, "¡Bienvenido por primera vez!", Toast.LENGTH_LONG).show()
                sharedPreferencesHelper.saveBoolean("shown_welcome_toast", true)
            }
        }
    }
}
