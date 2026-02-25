package com.example.todolist

import android.graphics.drawable.Icon
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.todolist.ui.theme.TODOlistTheme
import kotlin.math.roundToInt
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TODOlistTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    TextInputArea()
                }
            }
        }
    }


}

@Composable
fun TextInputArea () {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }

    var inputUnit by remember { mutableStateOf("cm") }
    var outputUnit by remember { mutableStateOf("cm 센치미터") }

    var isExpand by remember { mutableStateOf(false) }
    var onExpand by remember { mutableStateOf(false) }

    val conversion = remember { mutableStateOf(0.01) }

    val customTextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        color = Color.Black
    )
    fun convertUnits() {
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0;
        val result = (inputValueDouble * conversion.value * 100.0).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("")
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
        }, label = {Text("Enter!")})
        Spacer(Modifier.height(16.dp))

        Row {
            Box {
                Button(onClick = { isExpand = true }) {
                    Text("Select");
                    Icon(
                        Icons.Outlined.ArrowDropDown,
                        contentDescription = "unit dropdown"
                    )
                }
                DropdownMenu(expanded = isExpand, {
                    isExpand = false
                }) {
                    DropdownMenuItem({ Text("cm 센치미터") }, {
                        isExpand = false
                        inputUnit = "cm"
                        conversion.value = 0.01
                        convertUnits()
                    })
                    DropdownMenuItem({ Text("mm 밀리미터") }, {
                        isExpand = false
                        inputUnit = "mm"
                        conversion.value = 0.001
                        convertUnits()
                    })
                    DropdownMenuItem({ Text("m 미터") }, {
                        isExpand = false
                        inputUnit = "M"
                        conversion.value = 1.0
                        convertUnits()
                    })
                    DropdownMenuItem({ Text("km 칼로미터") }, {
                        isExpand = false
                        inputUnit = "KM"
                        conversion.value = 100.0
                        convertUnits()
                    })
                }
            }
            Spacer(Modifier.width(12.dp))
            Box{
                Button(onClick = {onExpand = true}){
                    Text("Select")
                    Icon(
                        Icons.Outlined.ArrowDropDown,
                        contentDescription = "unit dropdown")}
                DropdownMenu(expanded = onExpand, {
                    onExpand = false
                }) {
                    DropdownMenuItem({ Text("cm")}, {})
                    DropdownMenuItem({ Text("mm")}, {})
                    DropdownMenuItem({ Text("m")}, {})
                    DropdownMenuItem({ Text("km")}, {})
                }
            }
        }
        Text("RESUlt : ${outputValue}", TextStyle = MaterialTheme.typography.headlineMedium)
    }
    }

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    TODOlistTheme {
        TextInputArea()
    }
}