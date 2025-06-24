package com.example.s09_sharedpreferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.s09_sharedpreferences.databinding.FragmentTemaBinding

class TemaFragment : Fragment() {

    private lateinit var binding: FragmentTemaBinding
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentTemaBinding.inflate(inflater, container, false)
        sharedPreferencesHelper = SharedPreferencesHelper(requireContext())

        val isDarkMode = sharedPreferencesHelper.getBoolean(
            SharedPreferencesHelper.KEY_DARK_MODE, false
        )

        binding.switchDarkMode.isChecked = isDarkMode

        binding.switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferencesHelper.saveBoolean(SharedPreferencesHelper.KEY_DARK_MODE, isChecked)

            AppCompatDelegate.setDefaultNightMode(
                if (isChecked)
                    AppCompatDelegate.MODE_NIGHT_YES
                else
                    AppCompatDelegate.MODE_NIGHT_NO
            )
        }

        return binding.root
    }
}
