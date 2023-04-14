package com.example.cdgialumini.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationState
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.cdgialumini.R

@Composable
fun Test(){

//    val animationSpec by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animated_like))
//    val animationState = rememberlottie(autoPlay = true, repeatCount = Integer.MAX_VALUE)
//
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        verticalArrangement = Arrangement.Center
    ) {
//
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animated_like))

        LottieAnimation(
            composition = composition,
            modifier = Modifier.size(50.dp),
            iterations = LottieConstants.IterateForever
        )
    }
}

@Preview
@Composable
fun TPreview(){
    Test()
}