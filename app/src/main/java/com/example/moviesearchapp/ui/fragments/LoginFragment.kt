package com.example.moviesearchapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.moviesearchapp.databinding.FragmentLoginBinding
import com.example.moviesearchapp.ui.extenstions.createAndShowWithoutAction
import com.example.moviesearchapp.viewmodel.ViewModel

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(ViewModel::class.java)

        binding.buttonLogin.setOnClickListener {
            val textUsername: String = binding.textUsername.text.toString().trim()
            val password: String = binding.password.text.toString().trim()
            //TODO(validate user input)
            viewModel.onLoginButtonPressed(textUsername, password)
        }

        viewModel.getLiveDataAuth().observe(requireActivity()) {
            val action = LoginFragmentDirections.actionLoginFragmentToMainFragment()
            findNavController().navigate(action)
        }

        viewModel.getLiveDataError().observe(requireActivity()) {
            binding.buttonLogin.createAndShowWithoutAction(it.toString())
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}