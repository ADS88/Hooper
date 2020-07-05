package com.android.example.hooper.screens.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.android.example.hooper.R
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
            inflater,
            R.layout.menu_fragment, container, false
        )
        // Inflate the layout for this fragment

        binding.playButton.setOnClickListener {
            findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToTeamNameChoiceFragment()
            )
        }

        binding.previousGamesButton.setOnClickListener {
            findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToPreviousGamesFragment()
            )
        }

        return binding.root
    }


}
