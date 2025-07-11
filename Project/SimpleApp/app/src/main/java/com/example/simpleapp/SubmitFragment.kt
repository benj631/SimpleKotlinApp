package com.example.simpleapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simpleapp.databinding.FragmentSubmitBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SubmitFragment : Fragment() {

    private var _binding: FragmentSubmitBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSubmitBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSubmit.setOnClickListener {
            val enteredText = binding.inputText.text.toString()
            val formatted = getString(R.string.entered_text, enteredText)
            binding.outputText.text = formatted
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}