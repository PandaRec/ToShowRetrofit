package com.example.projectcourserxretrofitclean.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectcourserxretrofitclean.R
import com.example.projectcourserxretrofitclean.pojo.ResultMovie

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    var onMovieClickListener:OnMovieClickListener?=null
    var movies:List<ResultMovie> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movies_item,parent,false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val currentItem = movies[position]

        holder.updateUI(currentItem)
    }

    override fun getItemCount() = movies.size

    inner class MoviesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.textViewMovies)


        fun updateUI(result: ResultMovie){
            textView.text = result.title
            itemView.setOnClickListener { onMovieClickListener?.onMovieClick(result) }
        }
    }
    interface OnMovieClickListener{
        fun onMovieClick(result: ResultMovie)
    }
}