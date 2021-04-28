package com.example.projectcourserxretrofitclean.ui.details.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.projectcourserxretrofitclean.R

class DetailsNewsFragment:Fragment() {

    private lateinit var detailsNewsViewModel: DetailsNewsViewModel
    private lateinit var imageView:ImageView
    private lateinit var textViewTitle:TextView
    private lateinit var textViewDescription:TextView
    private val args by navArgs<DetailsNewsFragmentArgs>()
    private val title by lazy { args.title }
    private val description by lazy { args.description }
    private val imageLink by lazy { args.imageLink }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailsNewsViewModel =
            ViewModelProvider(this).get(DetailsNewsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_details_news, container, false)

        imageView = root.findViewById(R.id.imageViewNewsImageDetails)
        textViewTitle = root.findViewById(R.id.textViewNewsTitleDetails)
        textViewDescription = root.findViewById(R.id.textViewNewsDescriptionDetails)

        updateUI()


        return root
    }

    private fun updateUI(){
        Glide.with(this).load(imageLink).into(imageView)
        textViewTitle.text = title
        textViewDescription.text = detailsNewsViewModel.removeHtmlTags(description)

    }
}