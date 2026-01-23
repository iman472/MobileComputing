package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import com.example.myapplication.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen()
        }
    }
}

@Composable
fun MyScreen() {

    var counter by remember { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            Image(
                painter = painterResource(id = R.drawable.pic),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )

            Text("Welcome to my Compose App", fontSize = 24.sp)

            Text("This is a smaller description text.", fontSize = 16.sp)

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { counter++ }) {
                Text("Click me")
            }

            Text("Button clicked $counter times", fontSize = 20.sp)

            Spacer(modifier = Modifier.height(20.dp))
        }

        items(20) { index ->
            Text("Scrollable item #$index", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
