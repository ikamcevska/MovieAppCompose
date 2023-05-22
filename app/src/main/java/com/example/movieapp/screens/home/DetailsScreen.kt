package com.example.movieapp.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieRow


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, movieId: String?){
    val newMovieList= getMovies().filter { movie ->
        movie.id==movieId
    }
        Scaffold(topBar={
            TopAppBar(backgroundColor = Color.Transparent,
                elevation=0.dp){
                Row(horizontalArrangement = Arrangement.Start){
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow Back",
                        modifier=Modifier.clickable {
                        navController.popBackStack()
                        })
                    Spacer(modifier=Modifier.width(30.dp))
                    Text(text="Movies")
                }

            }
            }){
             Surface(modifier= Modifier
                 .fillMaxHeight()
                 .fillMaxWidth()){
                 Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top) {
                     MovieRow(movie=newMovieList.first())
               Spacer(modifier=Modifier.height(20.dp))
                     Divider()
                     Spacer(modifier=Modifier.height(20.dp))
                     Text(text="Movie Images")
                     Spacer(modifier=Modifier.height(20.dp))
                     LazyRow{
                         items(newMovieList[0].images){image ->
                             Card(modifier = Modifier
                                 .padding(12.dp)
                                 .size(240.dp),elevation=5.dp){
                                 AsyncImage(
                                     model = image,
                                     contentDescription = null
                                 )
                             }
                         }
                     }

                }
             }
       }


}