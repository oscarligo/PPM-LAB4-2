package com.example.ppm_lab4_2


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.height
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController



@Composable
fun ImageCard(image: ImageClass) {

    Card(
        modifier = Modifier
            .padding(top = 7.dp)
            .padding(horizontal = 7.dp)
            .fillMaxWidth()
            .clickable {

            },
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {


            AsyncImage(
                model = image.imageUrl,
                contentDescription = "Imagen ${image.id}",
                placeholder = painterResource(R.drawable.placeholder),
                error = painterResource(R.drawable.placeholder),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()

            )


            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Text(
                    text = "${image.id}. ${image.title}",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = image.description,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun ImagesList(images: List<ImageClass>) {
    LazyColumn {
        items(images) { image ->
            ImageCard(image)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImagesScreen(navController: NavController) {

        Scaffold (
            topBar = {
                TopAppBar(
                    title = { Text("", textAlign = TextAlign.Center) },
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary
                    )
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.height(40.dp)
                ) {

                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {navController.navigate("add") },
                    modifier = Modifier.size(100.dp),
                    shape = RoundedCornerShape(40.dp),
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Agregar Imagen",
                        modifier = Modifier.size(50.dp)
                    )
                }
            },

        ) { paddingValues ->
            Surface(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                color =  MaterialTheme.colorScheme.background
            ) {
                ImagesList(images = images)
            }
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewImagesScreen() {

        Scaffold (
            topBar = {
                TopAppBar(
                    title = { Text("", textAlign = TextAlign.Center) },
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary
                    )
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.height(40.dp)
                ) {

                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { },
                    modifier = Modifier.size(100.dp),
                    shape = RoundedCornerShape(40.dp),
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Agregar Imagen",
                        modifier = Modifier.size(50.dp)
                    )
                }
            },
//            floatingActionButtonPosition = FabPosition.Center
        ) { paddingValues ->
            Surface(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                color =  MaterialTheme.colorScheme.background
            ) {
                ImagesList(images = images)
            }
        }

}