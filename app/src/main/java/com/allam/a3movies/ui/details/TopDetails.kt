package com.allam.a3movies.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.allam.a3movies.R
import com.allam.a3movies.databinding.FragmentDetailsBinding
import com.allam.a3movies.databinding.FragmentTopDetailsBinding
import com.allam.a3movies.model.TopRatedMovie
import com.allam.a3movies.ui.State
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopDetails : Fragment() {

    private val args:  TopDetailsArgs by navArgs()

    private val detailsViewModel: TopDetailsViewModel by viewModels()

    private lateinit var binding: FragmentTopDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTopDetailsBinding.inflate(inflater, container, false)

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            detailsViewModel.getTopMovieDetails(args.topId).collectLatest { state ->
                when (state) {
                    is State.Error -> {
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
                    }
                    is State.Loading -> {
                        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_LONG).show()
                    }
                    is State.Success -> {
                        setTopMovieDetails(state.data)
                    }
                }
            }

        }


    }

    fun setTopMovieDetails(topRatedMovie: TopRatedMovie){
        binding.topNameMovie.text = topRatedMovie.TopTitle
        binding.topOverviewMovie.text = topRatedMovie.TopOverView
        binding.topReleaseDateMovie.text = topRatedMovie.TopReleaseDate
        binding.topVoteAvMovie.text = topRatedMovie.TopVoteAverage.toString()
        val topImageUrl = "https://image.tmdb.org/t/p/w500/${topRatedMovie.TopImageUrl}"
        binding.topImageMovie.load(topImageUrl)
    }


}

