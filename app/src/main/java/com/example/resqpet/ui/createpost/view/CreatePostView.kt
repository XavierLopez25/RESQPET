package com.example.resqpet.ui.createpost.view

import android.graphics.Bitmap
import android.net.Uri
import android.content.ContentValues
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.resqpet.R
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.resqpet.ui.createpost.viewmodel.CreatePostViewModel
import com.example.resqpet.ui.createpost.viewmodel.PostDetailViewModel


@Composable
fun CreatePost(navController: NavController, postsViewModel: CreatePostViewModel, postDetailViewModel: PostDetailViewModel) {


    val viewModel: CreatePostViewModel = postsViewModel
    val postsViewModel: PostDetailViewModel = postDetailViewModel

    LaunchedEffect(key1 = navController.currentBackStackEntry) {
        viewModel.resetFields()
    }

    val postDataAdopt by viewModel.postAdoption.observeAsState()

    val postDataEventHC by viewModel.postEventHC.observeAsState()

    val context = LocalContext.current

    val pickImageLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            // Save the Uri in your ViewModel
            viewModel.saveImageUri(uri)
        }


    val takePictureLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicturePreview()) { bitmap: Bitmap? ->
            if (bitmap != null) {
                println("Success: Bitmap received.")

                // Convert Bitmap to Uri and save it in your ViewModel
                val uri = bitmap.let { imageBitmap ->
                    val values = ContentValues().apply {
                        // Ensure unique file name
                        put(
                            MediaStore.Images.Media.DISPLAY_NAME,
                            "Title_${System.currentTimeMillis()}.jpg"
                        )
                        put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                    }

                    val contentResolver = context.contentResolver
                    val imageUri =
                        contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

                    imageUri?.let {
                        contentResolver.openOutputStream(it)?.use { outputStream ->
                            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                        }
                    }
                    imageUri
                }
                viewModel.saveImageUri(uri)
            } else {
                println("Error: Bitmap is null.")
            }
        }


    // Estado para mantener la categoría seleccionada
    var selectedCategory by remember { mutableStateOf("none") }

    Column{
        Column(modifier = Modifier.weight(2f)){

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(R.color.backgroundColor))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(colorResource(R.color.secondaryColor))
                        .align(Alignment.TopStart)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 24.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Create",
                            color = colorResource(R.color.backgroundColor),
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(start = 25.dp)
                        )
                        Text(
                            text = "Post",
                            color = colorResource(R.color.backgroundColor),
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(start = 45.dp)
                        )
                        Text(
                            text = "Unlock Paw-sibilities: ",
                            color = colorResource(R.color.primaryColor),
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleSmall,
                            modifier = Modifier.padding(top = 10.dp, start = 10.dp)
                        )
                        Text(
                            text = "Create your Furr-ever Post!",
                            color = colorResource(R.color.primaryColor),
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleSmall,
                            modifier = Modifier.padding(start = 1.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .width(185.dp)
                            .height(185.dp)
                            .graphicsLayer(
                                translationX = -25f,
                                translationY = 100f
                            )
                            .background(Color.Transparent)
                    ) {

                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .width(170.dp)
                                .height(170.dp)
                                .background(
                                    colorResource(R.color.secondaryColor),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .padding(vertical = 10.dp, horizontal = 10.dp)
                        ) {

                            Box(
                                modifier = Modifier
                                    .width(155.dp)
                                    .height(155.dp)
                                    .background(
                                        colorResource(R.color.backgroundColor),
                                        shape = RoundedCornerShape(16.dp)
                                    )
                            ) {
                                Column(modifier = Modifier.align(Alignment.Center)){

                                    Spacer(modifier = Modifier.height(10.dp))

                                    // To open gallery
                                    Button(onClick = { pickImageLauncher.launch("image/*") }, colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.primaryColor))) {
                                        Text("Select from Gallery", color = colorResource(R.color.backgroundColor))
                                    }

                                    Spacer(modifier = Modifier.height(10.dp))

                                    // To take a picture
                                    Button(onClick = { takePictureLauncher.launch() }, colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.primaryColor))) {
                                        Text("Take a Picture", color = colorResource(R.color.backgroundColor))
                                    }

                                    Spacer(modifier = Modifier.height(10.dp))

                                }
                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomEnd)
                        .offset((0).dp, (25).dp)
                        .padding(30.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.99f)
                            .height(420.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(colorResource(R.color.primaryColor))
                            .padding(30.dp)
                    ) {

                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            item {
                                Text(
                                    text = "Post Category",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(R.color.backgroundColor),
                                    style = MaterialTheme.typography.titleMedium,
                                )

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {

                                        Checkbox(
                                            checked = selectedCategory == "adoption",
                                            onCheckedChange = { checked ->
                                                if (checked) selectedCategory = "adoption"
                                            }
                                        )

                                        Text(
                                            text = "Adoption",
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(R.color.backgroundColor),
                                            style = MaterialTheme.typography.titleSmall
                                        )
                                    }

                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {

                                        Checkbox(
                                            checked = selectedCategory == "event",
                                            onCheckedChange = { checked ->
                                                if (checked) selectedCategory = "event"
                                            }
                                        )

                                        Text(
                                            text = "Event",
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(R.color.backgroundColor),
                                            style = MaterialTheme.typography.titleSmall
                                        )

                                    }
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {

                                        Checkbox(
                                            checked = selectedCategory == "health_care",
                                            onCheckedChange = { checked ->
                                                if (checked) selectedCategory = "health_care"
                                            }
                                        )

                                        Text(
                                            text = "Health & Care",
                                            fontWeight = FontWeight.Bold,
                                            color = colorResource(R.color.backgroundColor),
                                            style = MaterialTheme.typography.titleSmall
                                        )

                                    }
                                }
                            }

                            item {

                                // Muestra los campos de texto basados en la selección
                                when (selectedCategory) {
                                    "adoption" -> {
                                        AdoptView(postDataAdopt, viewModel)
                                    }
                                    "event", "health_care" -> {
                                        EventHCView(postDataEventHC, viewModel)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Column{
            Row (modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .background(colorResource(R.color.backgroundColor))
            ){
                IconButton(onClick = { viewModel.resetFields() }, modifier = Modifier.size(150.dp).offset(x = (-40).dp)) {
                    Image(painter = painterResource(id = R.drawable.adoptbutton), contentDescription = "Descripción de la imagen")
                }
                Text(text = stringResource(R.string.cancel), style = MaterialTheme.typography.titleLarge, fontSize = 25.sp, color = colorResource(R.color.primaryColor), modifier = Modifier.offset(x = (-145).dp, y = 35.dp))

                IconButton(onClick = { viewModel.createNewPostWithImage(selectedCategory, postDataAdopt, postDataEventHC)
                                     navController.popBackStack()
                                     postDetailViewModel.addNewPost(viewModel.getId(), selectedCategory, postDataAdopt, postDataEventHC, viewModel.getImageUri())}, modifier = Modifier.size(150.dp).offset(x = (50).dp),) {
                    Image(painter = painterResource(id = R.drawable.adoptbutton), contentDescription = "Descripción de la imagen")
                    Text(text = stringResource(R.string.adopt), style = MaterialTheme.typography.titleLarge, fontSize = 25.sp, color = colorResource(R.color.primaryColor), modifier = Modifier.offset(x = (-10).dp, y = 10.dp))
                }
            }
        }
    }
}