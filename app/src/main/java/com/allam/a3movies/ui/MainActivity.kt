package com.allam.a3movies.ui

import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.imageLoader
import com.allam.a3movies.R
import com.allam.a3movies.databinding.ActivityMainBinding
import com.allam.a3movies.model.Movie
import com.allam.a3movies.ui.adapter.MoviesAdapter
import com.allam.a3movies.ui.favourites.FavouritesFragment
import com.allam.a3movies.ui.home.HomeFragment
import com.allam.a3movies.ui.home.HomeFragmentDirections
import com.allam.a3movies.ui.suggested.SuggestedFragment
import com.allam.a3movies.ui.user.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Runnable

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        navController = Navigation.findNavController(this, R.id.main_fragment_container)
        setupWithNavController(binding.bottomNavView, navController)

        /*replaceFragment(HomeFragment())



        findViewById<BottomNavigationView>(R.id.bottom_nav_view).setOnItemSelectedListener {

            when(it.itemId){

                R.id.home_movie -> replaceFragment(HomeFragment())
                R.id.user_movie -> replaceFragment(UserFragment())
                R.id.favorite_movie -> replaceFragment(FavouritesFragment())
                R.id.suggested_movie -> replaceFragment(SuggestedFragment())

                else ->{}
            }

            true
        }



    }
    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()

  }*/
    }
}
