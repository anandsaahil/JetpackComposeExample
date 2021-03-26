package com.example.jetpackcomposeexample.nav

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.jetpackcomposeexample.nav.Destinations.DetailView
import com.example.jetpackcomposeexample.nav.Destinations.Home
import com.example.jetpackcomposeexample.nav.Destinations.View1
import com.example.jetpackcomposeexample.nav.Destinations.View2
import com.example.jetpackcomposeexample.nav.Destinations.View3

object Destinations {
    const val Home = "home"
    const val DetailView = "detailView"
    const val View1 = "view1"
    const val View2 = "view2"
    const val View3 = "view3"
}

class Action(navController: NavHostController) {
    val home: () -> Unit = { navController.navigate(Home) }
    val detailView: () -> Unit = { navController.navigate(DetailView) }
    val view1: () -> Unit = { navController.navigate(View1) }
    val view2: () -> Unit = { navController.navigate(View2) }
    val view3: () -> Unit = { navController.navigate(View3) }
    val navigateBack: () -> Unit = { navController.popBackStack() }
}