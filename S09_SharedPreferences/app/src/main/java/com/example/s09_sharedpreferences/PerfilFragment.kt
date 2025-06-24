package com.example.s09_sharedpreferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.s09_sharedpreferences.databinding.FragmentPerfilBinding

class PerfilFragment : Fragment() {

    private lateinit var binding: FragmentPerfilBinding
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPerfilBinding.inflate(inflater, container, false)
        sharedPreferencesHelper = SharedPreferencesHelper(requireContext())

        cargarDatos()

        binding.btnEditarPerfil.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, EditarPerfilFragment())
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }

    private fun cargarDatos() {
        binding.tvNombres.text = sharedPreferencesHelper.getString("perfil_nombres", "")
        binding.tvApellidos.text = sharedPreferencesHelper.getString("perfil_apellidos", "")
        binding.tvEdad.text = sharedPreferencesHelper.getString("perfil_edad", "")
        binding.tvEmail.text = sharedPreferencesHelper.getString("perfil_email", "")
    }
}
