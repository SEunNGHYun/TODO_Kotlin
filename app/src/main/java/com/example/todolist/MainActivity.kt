package com.example.todolist

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        println("on Create")
        Log.i("LIFECYCLE", "onCreate()")
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()
        println("on Start")
        Log.i("LIFECYCLE", "onStart()")
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
        println("onResume")
        Log.i("LIFECYCLE", "onResume()")
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show()

    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart")
        Log.i("LIFECYCLE", "onRestart()")
        Toast.makeText(this, "onRestart()", Toast.LENGTH_SHORT).show()

    }

    override fun onPause() {
        super.onPause()
        println("onPause")
        Log.i("LIFECYCLE", "onPause()")
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()
        println("onStop")
        Log.i("LIFECYCLE", "onStop()")
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
        Log.i("LIFECYCLE", "onDestroy()")
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show()

    }
}

@Composable
fun TodoListScreen(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TODOlistTheme {
        TodoListScreen("Android")
    }
}