package com.example.timetracker.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timetracker.model.getDateTime
import java.time.LocalDateTime



@Preview(showBackground = true)
@Composable
fun HomeScreen(){
        MainContent()
}



@Composable
fun MainContent(modifier:Modifier = Modifier){
    val dateState = remember {
            mutableStateOf("")
    }
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = Color(0xFF1289A7)
    ) {
        Column(
            modifier = modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                Text(
                    text = dateState.value,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize
                    )
                )
            Spacer(modifier = modifier.height(30.dp))
            CreateCardButton(context = LocalContext.current){ date->
                dateState.value = date
            }

        }
    }
}

@Composable
private fun CreateCardButton(modifier: Modifier = Modifier, context: Context, onClick:(String)->Unit) {
    Surface(
        modifier = modifier
            .size(130.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(corner = CornerSize(50))
    ) {

        Card(
            modifier = Modifier.clickable {
                onClick(getDateTime().toString())
                Toast.makeText(context, "Date and Time are Stored in History", Toast.LENGTH_SHORT)
                    .show()
            },
            colors = CardDefaults.cardColors(Color(0xFF10ac84)),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Tap",
                    style = TextStyle(
                        fontSize = 30.sp
                    )
                )
            }
        }
    }
}