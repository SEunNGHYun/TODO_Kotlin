package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.todolist.ui.theme.TODOlistTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TODOlistTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    CaptainGame()
                }
            }
        }
    }


}

@Composable
fun CaptainGame () {
    val treasuresFound = remember { mutableStateOf(0)}
    val direction = remember { mutableStateOf("North") }
    val stormOrTreasure = remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize(), Arrangement.Center) {

        Box(Modifier.fillMaxWidth() )

            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

                Text("treasure : ${treasuresFound.value}")
                Text("direction : ${direction.value}")
                Text("stormOrTreasure ${stormOrTreasure.value}")
                Spacer(modifier = Modifier.height(12.dp))

                Text("향해를~", fontSize = 35.sp)
                Spacer(modifier = Modifier.height(25.dp))
                Button({
                    direction.value = "North"
                    if (Random.nextBoolean()){
                        treasuresFound.value += 1
                        stormOrTreasure.value = "Found a Treasure!"
                    } else {
                        stormOrTreasure.value = "Storm Ahead!"
                    }
                }) { Text("North") }
                Row(Modifier.fillMaxWidth(), Arrangement.Center) {
                    Button({
                        direction.value = "West"
                        if (Random.nextBoolean()){
                            treasuresFound.value += 1
                            stormOrTreasure.value = "Found a Treasure!"
                        } else {
                            stormOrTreasure.value = "Storm Ahead!"
                        }
                    }) { Text("West") }
                    Spacer(Modifier.width(20.dp))
                    Button({
                        direction.value = "East"
                        if (Random.nextBoolean()){
                            treasuresFound.value += 1
                            stormOrTreasure.value = "Found a Treasure!"
                        } else {
                            stormOrTreasure.value = "Storm Ahead!"
                        }
                    }) { Text("East") }
                }
                Button({
                    direction.value = "South"
                    if (Random.nextBoolean()){
                        treasuresFound.value += 1
                        stormOrTreasure.value = "Found a Treasure!"
                    } else {
                        stormOrTreasure.value = "Storm Ahead!"
                    }
                }) { Text("South") }
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    TODOlistTheme {
        CaptainGame()
    }
}