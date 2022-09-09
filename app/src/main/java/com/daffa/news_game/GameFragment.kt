package com.daffa.news_game

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.news_game.componen.adapter.GameAdapter
import com.daffa.news_game.componen.viewmodel.GameViewModel
import com.daffa.news_game.databinding.FragmentGameBinding
import com.daffa.news_game.network.response.GameResponseItem


class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding

    private var _viewModel: GameViewModel? = null
    private val viewModel get() = _viewModel as GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _viewModel=ViewModelProvider(this)[GameViewModel::class.java]

        viewModel.getGameModel()
        viewModel.getListGame().observe(viewLifecycleOwner){
            showData(it)
            Log.i("data", it.toString())
        }
    }

    private fun showData(data: List<GameResponseItem>?) {
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = data?.let { GameAdapter(it) }
        }
    }


}