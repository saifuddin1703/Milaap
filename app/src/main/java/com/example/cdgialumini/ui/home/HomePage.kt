package com.example.cdgialumini.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cdgialumini.ui.post.Post
import com.example.cdgialumini.ui.theme.AppGray
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomePage(parentNavController: NavHostController){

    val scope = rememberCoroutineScope()
    val viewModel : HomeViewModel = hiltViewModel()

    val uiState = viewModel.uiState.observeAsState()

    uiState.value?.message?.let {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = AppGray)) {

           Text(text = "Error loading feed",modifier = Modifier.align(alignment = Center))
        }
    }
    uiState.value?.data?.let {posts->
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = AppGray)) {

            LazyColumn(){
                items(posts){post->
                    Post(
                        post,
                        onLike = {
                                 scope.launch {
                                        viewModel.likePost(post.Id!!)
                                 }
                        },
                        onDislike = {
                            scope.launch {
                                viewModel.dislikePost(post.Id!!)
                            }
                        },
                        onComment = {
                            parentNavController.navigate("postDetailPage/${post.Id}")
                        },
                        onShare = {

                        },
                        onSave = {
                             scope.launch {
                                viewModel.savePost(post.Id!!)
                             }
                        },
                        onUnSave = {
                            scope.launch {
                                viewModel.unSavePost(post.Id!!)
                            }
                        },
                        onClick = {
                            parentNavController.navigate("postDetailPage/${post.Id}")
                        },
                        onProfileClick = {id->
                            parentNavController.navigate("profile/${id}")
                        }
                    )
                }
            }
        }
    }

    if(uiState.value?.isLoading!!){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = AppGray)){

            CircularProgressIndicator(modifier = Modifier.align(alignment = Center))
        }
    }
    LaunchedEffect(key1 = true){
        viewModel.getFeed()
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun HomePagePreview(){
    HomePage(rememberNavController())
}

