package com.example.ejer2_lazyverticalgrid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejer2_lazyverticalgrid.ui.theme.Ejer2_LazyVerticalGridTheme
import com.example.ejer2_lazyverticalgrid.ui.theme.ImageItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejer2_LazyVerticalGridTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column (modifier = Modifier.fillMaxSize().background(Color.White)){
        Spacer(modifier = Modifier.height(20.dp))
        ImageGallery()
    }
}
@Composable
fun ImageGallery() {
    val images = listOf(
        ImageItem(1, "Gatete 1", R.drawable.imagen1),
        ImageItem(2, "Gatete 2", R.drawable.imagen2),
        ImageItem(3, "Gatete 3", R.drawable.imagen3),
        ImageItem(4, "Gatete 4", R.drawable.imagen4),
    )

    val context = LocalContext.current

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(8.dp).background(Color.White)
    ) {
        items(images) { image ->
            ImageItemCard(image) {
                Toast.makeText(context, image.title, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ImageItemCard(image: ImageItem, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick() }
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = image.imageResId),
            contentDescription = image.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = image.title,
            fontSize = 20.sp,
            color = Color.Green
        )
    }
}
