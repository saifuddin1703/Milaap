package com.example.cdgialumini.utils
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DateUtility {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getTimeAgo(datetime : String) : String {
        val inputTime = datetime // replace with your input time
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val time = LocalDateTime.parse(datetime, formatter)
        val now = LocalDateTime.now()
        val duration = java.time.Duration.between(time, now)
        val seconds = duration.seconds
        val minutes = duration.toMinutes()
        val hours = duration.toHours()
        val days = duration.toDays()


        return when {
            seconds < 60 -> "$seconds seconds ago"
            minutes < 60 -> "$minutes minutes ago"
            hours < 24 -> "$hours hours ago"
            else -> "$days days ago"
        }
    }

}