package com.example.projectcourserxretrofitclean.ui.details.news

import androidx.lifecycle.ViewModel

class DetailsNewsViewModel:ViewModel() {
    fun removeHtmlTags(text:String?):String{
        if(text==null)
            return ""
        val temp = text.replace("<p>","")
        return temp.replace("</p>","")
    }

}