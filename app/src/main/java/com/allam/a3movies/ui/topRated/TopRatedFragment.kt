package com.allam.a3movies.ui.topRated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.allam.a3movies.databinding.FragmentTopRatedBinding
import com.allam.a3movies.ui.State
import com.allam.a3movies.ui.adapter.TopRatedAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class TopRatedFragment : Fragment() {

    lateinit var binding: FragmentTopRatedBinding


    private val topRatedViewModel: TopRatedViewModel by viewModels()

     lateinit var topRatedAdapter : TopRatedAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTopRatedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topRatedAdapter = TopRatedAdapter()

        binding.topRatedGrid.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = topRatedAdapter

        }

        viewLifecycleOwner.lifecycleScope.launch {
            topRatedViewModel.topMovieData.collectLatest { state ->

                if (state.isLoading()) binding.topProgressBar.visibility = View.VISIBLE
                else binding.topProgressBar.visibility = View.INVISIBLE




                when (state) {
                    is State.Error -> {
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
                    }
                    is State.Loading -> {
                        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_LONG).show()
                    }
                    is State.Success -> {
                        topRatedAdapter.submitList(state.data)
                    }
                    else -> {}
                }
            }
        }


    }



}


