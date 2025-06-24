package com.example.s09_sharedpreferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.s09_sharedpreferences.databinding.FragmentContadorBinding

class ContadorFragment : Fragment() {

    private lateinit var binding: FragmentContadorBinding
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    companion object {
        const val KEY_APP_OPEN_COUNT = "app_open_count"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentContadorBinding.inflate(inflater, container, false)
        sharedPreferencesHelper = SharedPreferencesHelper(requireContext())

        actualizarContador()

        binding.btnReset.setOnClickListener {
            sharedPreferencesHelper.saveInt(KEY_APP_OPEN_COUNT, 0)
            actualizarContador()
        }

        return binding.root
    }

    private fun actualizarContador() {
        val contador = sharedPreferencesHelper.getInt(KEY_APP_OPEN_COUNT, 0)
        binding.tvContador.text = contador.toString()
    }
}
