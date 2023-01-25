package com.example.cdgialumini.ui.utils

import com.example.cdgialumini.R

sealed class PostActions(val name : String,val icon : Int){
    object Like : PostActions("Like",R.drawable.noun_like_1027080)
    object Comment : PostActions("Comment",R.drawable.comment_icon)
    object Share : PostActions("Share",R.drawable.share)
    object Save : PostActions("Save",R.drawable.save)
}
