package com.android.example.hooper


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.example.hooper.databinding.ScoreFragmentBinding
import kotlinx.android.synthetic.main.activity_main.*

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {

    private lateinit var binding: ScoreFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.score_fragment,
            container,
            false
        )

        var viewModel = ViewModelProvider(this).get(ScoreFragmentViewModel::class.java)


        viewModel.number.observe(this, Observer {
            binding.scoreText.text = it.toString()
        })
        binding.addOneButton.setOnClickListener {
            viewModel.addNumber()
        }

        return binding.root
    }


}
