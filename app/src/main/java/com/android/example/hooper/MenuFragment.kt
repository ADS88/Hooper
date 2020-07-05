package com.android.example.hooper


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.android.example.hooper.databinding.MenuFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: MenuFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.menu_fragment, container, false)
        // Inflate the layout for this fragment

        binding.playButton.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_scoreFragment)
        }
        return binding.root
    }




}
