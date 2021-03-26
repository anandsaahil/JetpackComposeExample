package com.example.jetpackcomposeexample.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeexample.view.home.setImage
import com.example.data.entity.UserEntity

@Composable
fun ItemRow(user: UserEntity) {
    Card(
        shape = RoundedCornerShape(14.dp),
        backgroundColor = Color.White,
        elevation = 4.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row {
            val image: Painter = painterResource(setImage(user.name!!))
            Image(
                modifier = Modifier
                    .size(100.dp, 100.dp),
                painter = image,
                alignment = Alignment.CenterStart,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = user.name!!,
                    Modifier.padding(0.dp,12.dp,0.dp,0.dp),
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = "27 years  |  Android Developer",
                    Modifier.padding(0.dp,5.dp,0.dp,0.dp),
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                )
            }
            if (user.name!! == "Glenna Reichert" || user.name!! == "Clementina DuBuque" || user.name!! == "Clementine Bauch" || user.name!! == "Patricia Lebsack" || user.name!! == "Mrs. Dennis Schulist"){
                GenderTag("Female")
            }else{
                GenderTag("Male")
            }
        }
    }
}