package com.example.testcomposeapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testcomposeapp.ui.firstscreen.FirstScreen
import com.example.testcomposeapp.ui.secondscreen.SecondScreen
import com.example.testcomposeapp.ui.thirdscreen.ThirdScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier

) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.First.screen_route,
        modifier = modifier
    ) {
        composable(route = BottomNavItem.First.screen_route) {
            FirstScreen()
        }
        composable(route = BottomNavItem.Second.screen_route) {
            SecondScreen()
        }
        composable(route = BottomNavItem.Third.screen_route) {
            ThirdScreen()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }