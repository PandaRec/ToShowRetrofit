package com.example.projectcourserxretrofitclean.ui.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.projectcourserxretrofitclean.R
import com.example.projectcourserxretrofitclean.adapters.NewsAdapter
import com.example.projectcourserxretrofitclean.pojo.Result
import com.example.projectcourserxretrofitclean.usecases.NewsUseCase

class NewsFragment: Fragment() {
    private lateinit var newsViewModel: NewsViewModel
    private var recyclerView: RecyclerView? = null
    private lateinit var newsAdapter:NewsAdapter
    private var newsUseCase: NewsUseCase?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        newsViewModel =
            ViewModelProvider(this).get(NewsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_news, container, false)
        newsUseCase = NewsUseCase()
        val navController = NavHostFragment.findNavController(this)


        recyclerView = root.findViewById(R.id.recyclerViewNews)
        newsAdapter = NewsAdapter()
        recyclerView?.adapter = newsAdapter

        newsUseCase?.let{
            it.getNews().subscribe {
                newsAdapter.news = it.results
            }
        }

        newsAdapter.onNewsClickListener = object :NewsAdapter.OnNewsClickListener{

            override fun onNewsClick(result: Result) {

                navController.navigate(NewsFragmentDirections
                    .actionNavigationNewsToNavigationDetailsNews(
                    result.title,
                    result.description,
                    result.images?.get(0)?.image,
                ))
            }
        }



            return root
        }
    }