package com.example.projectcourserxretrofitclean.ui.details.movies

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.projectcourserxretrofitclean.R
import com.example.projectcourserxretrofitclean.ui.details.news.DetailsNewsFragmentArgs

class DetailsMoviesFragment:Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var textViewTitle: TextView
    private lateinit var textViewTrailer: TextView
    private val args by navArgs<DetailsMoviesFragmentArgs>()
    private val title by lazy { args.title }
    private val image by lazy { args.imageLink}
    private val trailer by lazy { args.trailerLink }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_details_movies, container, false)

        imageView = root.findViewById(R.id.imageViewMovieDetails)
        textViewTitle = root.findViewById(R.id.textViewMoviesTitleDetails)
        textViewTrailer = root.findViewById(R.id.textViewMoviesTrailerDetails)

        updateUI()

        textViewTrailer.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(trailer))
            startActivity(intent)
        }
        return root

    }

    fun updateUI(){
        Glide.with(this).load(image).into(imageView)
        textViewTitle.text = title
    }
}