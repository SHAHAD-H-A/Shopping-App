package com.shahad.app.shoppingapp.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.shahad.app.shoppingapp.ui.screens.homeRoute
import com.shahad.app.shoppingapp.ui.theme.appColors

@Composable
fun ShoppingNavHost(
    navController: NavHostController = rememberNavController()
){
    val bottomNavScreens = listOf(NavScreen.Home,NavScreen.Shop,NavScreen.Bag,NavScreen.Favorite,NavScreen.Profile)
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.appColors.secondary,
                contentColor = MaterialTheme.appColors.primary,
                modifier = Modifier
                    .height(65.dp)
                    .background(
                        color = MaterialTheme.appColors.secondary,
                        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomEnd = 0.dp, bottomStart = 0.dp)
                    )
                    .clip( RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomEnd = 0.dp, bottomStart = 0.dp))
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomNavScreens.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.icon),
                                contentDescription = screen.route
                            )
                        },
                        label = { Text(stringResource(screen.title), fontSize = 10.sp, fontWeight = FontWeight.Medium) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        selectedContentColor = MaterialTheme.appColors.primary,
                        unselectedContentColor = MaterialTheme.appColors.gray,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        },
        modifier = Modifier.navigationBarsPadding()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavScreen.Home.route,
            Modifier.padding(innerPadding)
        ){
            homeRoute(navController)
        }
    }

}