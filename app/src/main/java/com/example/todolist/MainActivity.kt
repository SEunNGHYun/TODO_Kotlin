package com.example.todolist

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.ui.theme.TODOlistTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
        TODOlistTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                TodoListScreen(
                    name = "Android",
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
    }
}

@Composable
fun TodoListScreen(name: String, modifier: Modifier = Modifier) {
    Column(){
        Text("Conver")
        OutlinedTextField("", {

        })
        Row(){
            val context = LocalContext.current
            Button(
                {Toast.
                makeText(context,
                    "Thank for click",
                    Toast.LENGTH_LONG).show()
                }){
                Text("클릭")
            }
        }
    }
    Text("result")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TODOlistTheme {
        TodoListScreen("Android")
    }
}