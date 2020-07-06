package com.android.example.hooper.screens.history


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.android.example.hooper.R
import com.android.example.hooper.database.GameDatabase
import com.android.example.hooper.databinding.PreviousGamesFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class PreviousGamesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val binding: PreviousGamesFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.previous_games_fragment, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = GameDatabase.getInstance(application).gameDatabaseDao
        val viewModelFactory = PreviousGamesViewModelFactory(dataSource, application)

        val gameViewModel = ViewModelProviders.of(
            this, viewModelFactory
        ).get(PreviousGamesViewModel::class.java)

        binding.previousGamesViewModel = gameViewModel

        binding.setLifecycleOwner(this)

        return binding.root
    }


}
