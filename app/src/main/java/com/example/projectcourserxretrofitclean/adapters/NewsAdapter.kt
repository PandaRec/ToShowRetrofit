package com.example.projectcourserxretrofitclean.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectcourserxretrofitclean.R
import com.example.projectcourserxretrofitclean.pojo.News
import com.example.projectcourserxretrofitclean.pojo.Result

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    var onNewsClickListener: OnNewsClickListener?=null
    var news:List<Result> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = news[position]

        holder.updateUI(currentItem)


    }

    override fun getItemCount() = news.size

    inner class NewsViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.textViewNews)


        fun updateUI(result: Result){
            textView.text = result.title
            itemView.setOnClickListener { onNewsClickListener?.onNewsClick(result) }
        }
    }

    interface OnNewsClickListener{
        fun onNewsClick(result:Result)
    }
}