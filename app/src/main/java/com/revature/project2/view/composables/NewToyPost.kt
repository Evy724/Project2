package com.revature.project2.view.composables

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.revature.project2.viewmodel.AllToysViewModel
import java.time.format.TextStyle

//@Composable
//fun postNewToy(){
//    Image(modifier = Modifier
//        .padding(10.dp)
//        .fillMaxWidth()
//        .height(100.dp)
//        .wrapContentHeight(),
//
//        shape= CircleShape,
//        onClick = { println("Intent to img upload prompt") })

@Composable
fun screenTitle() {
    Text("New Toy Post", fontSize = 40.sp, modifier = Modifier.padding(10.dp).wrapContentHeight(), textAlign = TextAlign.Center)
}

@Composable
fun inputToyName() {
    var text by remember{ mutableStateOf("")}

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Toy Name")},
        modifier = Modifier.padding(10.dp).wrapContentHeight()
    )

}

@Composable
fun toyDescription() {
    var value by remember { mutableStateOf(" \n \n \n ") }

    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Toy Description") },
        maxLines = 4,
        modifier = Modifier.padding(10.dp)
    )
}

@Composable
fun ageOfToy() {
    var text by remember{ mutableStateOf("")}

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Age of Toy")},
        modifier = Modifier.padding(10.dp).wrapContentHeight()
    )
}

@Composable
fun postToy() {
    Button(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .height(100.dp)
        .wrapContentHeight(),
        shape = RoundedCornerShape(25),
        onClick = { /*TODO*/ })
    {
        Text(
            text = "Post Toy",
            fontSize = 15.sp,
            textAlign = TextAlign.Center
        )
    }
}