package com.android.example.hooper.screens.game


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.android.example.hooper.R
import com.android.example.hooper.database.GameDatabase
import com.android.example.hooper.databinding.ScoreFragmentBinding
import com.android.example.hooper.screens.history.PreviousGamesViewModel
import com.android.example.hooper.screens.history.PreviousGamesViewModelFactory

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {

    private lateinit var binding: ScoreFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.score_fragment,
            container,
            false
        )


        binding.setLifecycleOwner(this)

        val args = ScoreFragmentArgs.fromBundle(requireArguments())
        binding.teamOneName.text = args.teamOneName
        binding.teamTwoName.text = args.teamTwoName

        val application = requireNotNull(this.activity).application
        val dataSource = GameDatabase.getInstance(application).gameDatabaseDao
        val viewModelFactory = ScoreViewModelFactory(dataSource, application)

        val scoreViewModel = ViewModelProviders.of(
            this, viewModelFactory
        ).get(ScoreViewModel::class.java)

        binding.scoreViewModel = scoreViewModel


        return binding.root
    }


}
