package com.android.example.hooper.screens.game


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.android.example.hooper.R
import com.android.example.hooper.databinding.ScoreFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {

    private lateinit var binding: ScoreFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.score_fragment,
            container,
            false
        )

        var viewModel = ViewModelProvider(this).get(ScoreFragmentViewModel::class.java)

        binding.scoreViewModel = viewModel

        binding.setLifecycleOwner(this)

        val args = ScoreFragmentArgs.fromBundle(requireArguments())
        binding.teamOneName.text = args.teamOneName
        binding.teamTwoName.text = args.teamTwoName


        return binding.root
    }


}
