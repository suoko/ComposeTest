package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetest.ui.theme.ComposeTestTheme
import kotlin.String as String
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                //Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    //Greeting("Android")
                    //ClickCounter(clicks = 0){}
            HelloContent()
            LazyVerticalGridDemo()
                //}
            //}
        }
    }
}

@Composable
fun HelloContent() {

}
@OptIn(ExperimentalFoundationApi::class)
@Composable
    fun LazyVerticalGridDemo(){
        val list = (1..10).map { it.toString() }
    Column {
        var name: String by remember {mutableStateOf("Enter a name")}
        Text(
            text = "Hello $name!",
            /*modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5*/
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it},
            //label = { Text("Name") }
        )




        LazyVerticalGrid(
            cells = GridCells.Adaptive(128.dp),

            // content padding
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 16.dp,
                end = 12.dp,
                bottom = 16.dp
            ),
            content = {
                items(list.size) { index ->
                    Card(
                        backgroundColor = Color.Red,
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth(),
                        elevation = 8.dp,
                    ) {
                        Text(
                            text = list[index],
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        )
}
    }

/*

fun HelloContent() {
    Column {
        var name: String by remember {mutableStateOf("")}
        Text(
            text = "Hello $name!",
           )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it}
           )
    }
}


@Composable
fun ClickCounter(clicks: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("I've been clicked $clicks times")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTestTheme {
        Greeting("Android")
    }
}*/