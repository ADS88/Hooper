package com.android.example.hooper.screens.game


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.android.example.hooper.R
import com.android.example.hooper.databinding.MenuFragmentBinding
import com.android.example.hooper.databinding.TeamNameChoiceFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class TeamNameChoiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: TeamNameChoiceFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.team_name_choice_fragment, container, false)
        // Inflate the layout for this fragment

        binding.saveNamesButton.setOnClickListener {
            findNavController().navigate(TeamNameChoiceFragmentDirections.actionTeamNameChoiceFragmentToScoreFragment(
                binding.teamOneNameEditText.text.toString(),
                binding.teamTwoNameEditText.text.toString()
            ))
        }
        return binding.root
    }


}
