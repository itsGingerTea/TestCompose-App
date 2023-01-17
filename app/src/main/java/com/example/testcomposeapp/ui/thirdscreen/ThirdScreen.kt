package com.example.testcomposeapp.ui.thirdscreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testcomposeapp.ui.thirdscreen.components.RallyTabRow
import com.example.testcomposeapp.ui.theme.TestComposeAppTheme

@Composable
fun ThirdScreen() {
    TestComposeAppTheme {
        val navController = rememberNavController()

        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination

        val currentScreen =
            rallyTabRowScreens.find { it.route == currentDestination?.route } ?: Overview

        Scaffold(
            topBar = {
                RallyTabRow(
                    allScreens = rallyTabRowScreens,
                    onTabSelected = { newScreen -> navController.navigateSingleTopTo(newScreen.route) },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            RallyNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}