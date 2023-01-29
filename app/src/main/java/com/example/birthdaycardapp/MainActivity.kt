package com.example.birthdaycardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycardapp.ui.theme.BirthdayCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayCardGreeting(getString(R.string.person_name), from = getString(R.string.wisherName))
                }
            }
        }
    }
}

@Composable
fun BirthdayCardGreeting(name: String, from: String) {
    val image = painterResource(id = R.drawable.birthday_image)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(
                text = "Happy Birthday $name",
                fontSize = 30.sp,
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.Start)
                    .padding(vertical = 20.dp, horizontal = 8.dp)

            )
            Text(
                text = "From $from",
                fontSize = 30.sp,
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.End)
                    .padding(horizontal = 8.dp)

            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BirthdayCardAppTheme {
        BirthdayCardGreeting("Ali", from = "Hamza Akram")
    }
}