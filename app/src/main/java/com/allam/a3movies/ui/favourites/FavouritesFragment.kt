package com.allam.a3movies.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.allam.a3movies.R
import com.allam.a3movies.databinding.FragmentFavouritesBinding
import com.allam.a3movies.databinding.FragmentHomeBinding
import com.allam.a3movies.model.Movie
import com.allam.a3movies.ui.State
import com.allam.a3movies.ui.adapter.MoviesAdapter
import com.allam.a3movies.util.FavoriteListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class FavouritesFragment : Fragment()  {

   /* lateinit var binding: FragmentFavouritesBinding
    private lateinit var favoriteViewModel: FavouritesViewModel
    lateinit var moviesAdapter: MoviesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesAdapter = MoviesAdapter()

        binding.favRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = moviesAdapter
        }




        viewLifecycleOwner.lifecycleScope.launch {
            favoriteViewModel.favMovieData.collectLatest { state ->

                if (state.isLoading()) binding.favProgressBar.visibility = View.VISIBLE
                else binding.favProgressBar.visibility = View.INVISIBLE




                when (state) {
                    is State.Error -> {
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
                    }
                    is State.Loading -> {
                        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_LONG).show()
                    }
                    is State.Success -> {
                        moviesAdapter.submitList(state.data)
                    }
                    else -> {}
                }
            }
        }


    }

    override fun onClickRetry() {
        TODO("Not yet implemented")
    }

    override fun onMovieClick(movieResult: Movie, pos: Int) {
        findNavController().navigate(R.id.detailsFragment, bundleOf("movie" to movieResult))
    }*/


}






/*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
        obsStates()
        obsData()
    }

    private fun obsData() {
        favoriteViewModel.favMovieData().observe(viewLifecycleOwner, Observer { favorites ->
            if (favorites. != null && favorites.data.isNotEmpty()) {
                favoriteAdapter.submitList(favorites.data)
            } else {
                emptyView.emptyStateType(EmptyView.STATETYPE.EMPTY, null)
            }
        })
    }*/


