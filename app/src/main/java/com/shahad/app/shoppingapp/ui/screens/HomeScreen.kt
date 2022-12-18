package com.shahad.app.shoppingapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.shahad.app.shoppingapp.ui.navigation.NavScreen
import com.shahad.app.shoppingapp.viewModels.HomeViewModel

fun NavGraphBuilder.homeRoute(navHostController: NavHostController){
    composable(NavScreen.Home.route){
        HomeScreen(navController = navHostController)
    }
}

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    )
}
