package consumer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import ui.annotation.AutogenUI

@AutogenUI
data class ExampleClass(
    val name : String,
    val age : Int
)

@Composable
fun ColumnScope.Test(exampleClass: ExampleClass) {
    Row {
        Text(
            text = "Name: ",
            fontSize = 30.sp
        )
        Text(
            text = exampleClass.name,
            fontSize = 30.sp
        )
    }
    Row {
        Text(
            text = "Age: ",
            fontSize = 30.sp
        )
        TextField("123", onValueChange = { value -> exampleClass.copy(age = value.toInt())} )

//        Text(
//            text = exampleClass.age.toString(),
//            fontSize = 30.sp
//        )
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = WindowState(width = 400.dp, height = 300.dp),
        title = "Medium"
    ) {
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
            Column {
                Test(ExampleClass("Joe",15))
            }
        }
    }
}