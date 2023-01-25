package com.example.cdgialumini.ui.utils

import com.example.cdgialumini.R

sealed class BottomNavigationItems(val title:String,val iconLocation : Int){
    object Home : BottomNavigationItems("Home", R.drawable.noun_home_5181945)
    object Directory : BottomNavigationItems("Directory", R.drawable.noun_directory_2560152)
    object Events : BottomNavigationItems("Events", R.drawable.noun_event_5181363)
    object Profile : BottomNavigationItems("Profile", R.drawable.noun_profile_5178761)
    object Messages : BottomNavigationItems("Messages", R.drawable.noun_message_3593002)
}
