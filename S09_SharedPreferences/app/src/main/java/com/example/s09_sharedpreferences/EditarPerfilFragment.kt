package com.example.s09_sharedpreferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.s09_sharedpreferences.databinding.FragmentEditarPerfilBinding

class EditarPerfilFragment : Fragment() {

    private lateinit var binding: FragmentEditarPerfilBinding
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditarPerfilBinding.inflate(inflater, container, false)
        sharedPreferencesHelper = SharedPreferencesHelper(requireContext())

        cargarDatos()

        binding.btnGuardar.setOnClickListener {
            guardarDatos()
        }

        binding.btnCancelar.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    private fun cargarDatos() {
        binding.etNombres.setText(sharedPreferencesHelper.getString("perfil_nombres", ""))
        binding.etApellidos.setText(sharedPreferencesHelper.getString("perfil_apellidos", ""))
        binding.etEdad.setText(sharedPreferencesHelper.getString("perfil_edad", ""))
        binding.etEmail.setText(sharedPreferencesHelper.getString("perfil_email", ""))
    }

    private fun guardarDatos() {
        sharedPreferencesHelper.saveString("perfil_nombres", binding.etNombres.text.toString())
        sharedPreferencesHelper.saveString("perfil_apellidos", binding.etApellidos.text.toString())
        sharedPreferencesHelper.saveString("perfil_edad", binding.etEdad.text.toString())
        sharedPreferencesHelper.saveString("perfil_email", binding.etEmail.text.toString())

        Toast.makeText(requireContext(), "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()
        parentFragmentManager.popBackStack()
    }
}
