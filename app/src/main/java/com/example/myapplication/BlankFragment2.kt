package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentBlank2Binding


class BlankFragment2 : Fragment() {

    lateinit var binding: FragmentBlank2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val checkBox = binding.checkboxSecFragment

        binding.saveSecFragment.setOnClickListener {
            if (checkBox.isChecked) {
                saveData1()
                findNavController().navigate(R.id.action_blankFragment2_to_blankFragment)
            }
        }
    }

    private fun saveData1() {
        val checkBox = binding.checkboxSecFragment.isChecked
        val sharedPrefs = context?.getSharedPreferences("123", Context.MODE_PRIVATE)
        sharedPrefs?.edit()?.putBoolean("STATE", checkBox)?.apply()
    }
}