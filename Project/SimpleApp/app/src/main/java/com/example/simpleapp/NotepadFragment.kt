package com.example.simpleapp

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.example.simpleapp.databinding.FragmentNotepadBinding

class NotepadFragment : Fragment() {

    private var _binding: FragmentNotepadBinding? = null
    private val binding get() = _binding!!

    private val PREFS_NAME = "notepad_prefs"
    private val NOTE_KEY = "note"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotepadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val prefs = requireContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Load saved note
        binding.editTextNote.setText(prefs.getString(NOTE_KEY, ""))

        // Save on button click using KTX edit extension
        binding.buttonSaveNote.setOnClickListener {
            prefs.edit {
                putString(NOTE_KEY, binding.editTextNote.text.toString())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
