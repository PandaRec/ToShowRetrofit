package com.example.projectcourserxretrofitclean.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.projectcourserxretrofitclean.R
import com.example.projectcourserxretrofitclean.adapters.MoviesAdapter
import com.example.projectcourserxretrofitclean.adapters.NewsAdapter
import com.example.projectcourserxretrofitclean.pojo.ResultMovie
import com.example.projectcourserxretrofitclean.ui.news.NewsViewModel
import com.example.projectcourserxretrofitclean.usecases.MoviesUseCase
import com.example.projectcourserxretrofitclean.usecases.NewsUseCase

class MoviesFragment: Fragment() {
    private lateinit var moviesViewModel: MoviesViewModel
    private var recyclerView: RecyclerView? = null
    private lateinit var moviesAdapter: MoviesAdapter
    private var moviesUseCase: MoviesUseCase?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        moviesViewModel =
            ViewModelProvider(this).get(MoviesViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_movies, container, false)

        val navController = NavHostFragment.findNavController(this)

        recyclerView = root.findViewById(R.id.recyclerViewMovies)
        moviesAdapter = MoviesAdapter()
        moviesUseCase = MoviesUseCase()
        recyclerView?.adapter = moviesAdapter

        moviesUseCase?.let {
            it.getMovies().subscribe {
                moviesAdapter.movies = it.results
            }
        }

        moviesAdapter.onMovieClickListener = object : MoviesAdapter.OnMovieClickListener{
            override fun onMovieClick(result: ResultMovie) {
                navController.navigate(MoviesFragmentDirections.actionNavigationMoviesToNavigationDetailsMovies(
                    result.title,
                    result.poster?.image,
                    result.trailer
                ))
            }
        }

        return root
    }
}