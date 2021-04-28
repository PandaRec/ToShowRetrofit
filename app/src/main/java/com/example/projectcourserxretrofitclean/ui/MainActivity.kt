package com.example.projectcourserxretrofitclean.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.navigation.Navigation
//import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.projectcourserxretrofitclean.R
import com.example.projectcourserxretrofitclean.api.ApiService
import com.example.projectcourserxretrofitclean.pojo.News
import com.example.projectcourserxretrofitclean.ui.movies.MoviesFragment
import com.example.projectcourserxretrofitclean.usecases.NewsUseCase
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var textViewNewsBottomNavigationView: TextView
    lateinit var textViewMoviesBottomNavigationView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val newsUseCase = NewsUseCase()
//        newsUseCase.getNews().subscribe({
//            disp(it)
//        })

        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)


        textViewNewsBottomNavigationView = findViewById(R.id.newsBottomNavigation)
        textViewMoviesBottomNavigationView = findViewById(R.id.moviesBottomNavigation)

        textViewNewsBottomNavigationView.setOnClickListener {
            Log.d("TAG","click news")
        navController.navigate(R.id.navigation_news)
        }

        textViewMoviesBottomNavigationView.setOnClickListener {
            navController.navigate(R.id.navigation_movies)

        }

    }

    fun disp(news: News){
        for (e in news.results){
            Log.d("TAG",e.title.toString())
            Log.d("TAG", e.images?.size.toString())
        }
    }


}