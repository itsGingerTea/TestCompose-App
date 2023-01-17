package com.example.testcomposeapp

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testcomposeapp.ui.theme.TestComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeAppTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun App() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { AppBottomNavigation(navController = navController)}
    ) {
        AppNavHost(navController = navController)
    }
}

@Composable
fun AppBottomNavigation(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.First,
        BottomNavItem.Second,
        BottomNavItem.Third
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigateSingleTopTo(item.screen_route)
                },
                icon = {
                    Icon(painterResource(id = item.icon), contentDescription = item.title)
                },
                label = {
                    Text(text = item.title,
                        fontSize = 9.sp)
                },
                alwaysShowLabel = true
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestComposeAppTheme {
        App()
    }
}