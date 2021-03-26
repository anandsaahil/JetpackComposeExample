package com.example.jetpackcomposeexample.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeexample.R
import com.example.jetpackcomposeexample.components.ItemRow
import com.example.jetpackcomposeexample.components.MaterialCircularProgressIndicatorComponent
import com.example.jetpackcomposeexample.utils.Status
import com.example.data.entity.UserEntity

@Composable
fun Home(model: HomeViewModel = viewModel()) {
    val topMovies by model.getUsers.observeAsState()
    when (topMovies?.status) {
        Status.ERROR -> Text("error")
        Status.LOADING -> {
            MaterialCircularProgressIndicatorComponent()
        }
        Status.SUCCESS -> UserList(topMovies?.data?.body().orEmpty())
    }
}

@Composable
private fun UserList(userList:List<UserEntity>){
    LazyColumn() {
        itemsIndexed(userList) { index, item ->
            UserRow(item)
        }
    }
}

@Composable
private fun UserRow(data:UserEntity) {
    Row(modifier = Modifier.background(Color(0xFFFFF8F8F8))
        .fillMaxWidth()
        .padding(1.dp)) {
        ItemRow(data)
    }
}

fun setImage(user: String):Int{
    return when (user) {
        "Clementine Bauch" -> {
            R.drawable.fem1
        }
        "Ervin Howell" -> {
            R.drawable.male2
        }
        "Patricia Lebsack" -> {
            R.drawable.fem2
        }
        "Mrs. Dennis Schulist" -> {
            R.drawable.fem3
        }
        "Leanne Graham" -> {
            R.drawable.male1
        }
        "Kurtis Weissnat" -> {
            R.drawable.male1
        }
        "Clementina DuBuque" ->{
            R.drawable.fem2
        }
        "Glenna Reichert" -> {
            R.drawable.fem3
        }
        else -> {
            R.drawable.male2
        }
    }
}