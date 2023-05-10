package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

class MainActivity : ComponentActivity() {
    private lateinit var namePositionData: NamePosition

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val listName = listOf<String>("Zeel Modh", "Savan solanki", "Tirth patel")
        val listPosition = listOf<String>("IOS \nCross platform", "React Native \nReact Js",
            "Native Android \nJava \nKotlin \nJetpack compose", "", "", "", "", "", "", "", "", "")
//        val listPosition2 = listOf<String>("IOS \n Cross platform ", "React Native", "Native Android")
//        val listPosition3 = listOf<String>("IOS ", "React Native", "Native Android")
//        val listPosition4 = listOf<String>("IOS ", "React Native", "Native Android")

        namePositionData = NamePosition("Zeel Modh", ItemList(listPosition))


        setContent {
            Conversation(messages = namePositionData)
//            Greeting("Zeel Modh", "Android Developer")
        }
    }
}

@Composable
fun Conversation(messages: NamePosition) {
    LazyColumn {
        items(messages.itemList.positionList) { message ->
            Greeting(messages.name, message)
        }
    }
}

@Composable
fun Greeting(name: String, profile: String) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .border(0.7.dp, color = Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_icon),
            contentDescription = "Profile picture",
            modifier = Modifier
                .padding(5.dp)
                .size(45.dp))

        Spacer(modifier = Modifier.height(10.dp))

        Column {
            Text(
                text = name, modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 5.dp, 0.dp, 0.dp), color = Color.Black)

            Spacer(modifier = Modifier.height(5.dp))

            Text(text = profile, modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp, 0.dp, 0.dp, 0.dp), color = Color.DarkGray)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    JetPackComposeTheme {
//        Greeting("Zeel Modh", NamePosition )
//    }
//}