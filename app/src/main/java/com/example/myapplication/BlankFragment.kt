package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {
    lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val switch = binding.switch1

        loadData1()

        binding.continueFirstFragment.setOnClickListener{
           if(switch.isChecked) {
               findNavController().navigate(R.id.action_blankFragment_to_mainActivity2)
           }else{
               findNavController().navigate(R.id.action_blankFragment_to_blankFragment2)
           }
        }
        binding.saveFirstFragment.setOnClickListener(){
            saveData()
        }
    }
    private fun saveData(){
        val editText = binding.editName.text.toString()
        val sharedPrefs = context?.getSharedPreferences("123", Context.MODE_PRIVATE)
        sharedPrefs?.edit()?.putString("EDIT_NAME",editText)?.apply()
    }
    private fun loadData1(){
        val sharedPrefs = context?.getSharedPreferences("123", Context.MODE_PRIVATE)
        val savedState = sharedPrefs?.getBoolean("STATE",false)
        val state = binding.switch1
        if (savedState != null) {
            state.isChecked = savedState
        }

    }
}
