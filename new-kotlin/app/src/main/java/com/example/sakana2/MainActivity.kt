package com.example.sakana2

import android.R.attr.y
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.FabPosition
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sakana2.design.MainScreen
import com.example.sakana2.ui.theme.Sakana2Theme
import com.example.sakana2.design.BarHome
import com.example.sakana2.design.BarBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Sakana2Theme {
                Appkanri()
            }
        }
    }
}

@Composable
fun Appkanri() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "DeadlinesB"

    Scaffold(
        bottomBar = {
            BarBar(
                currentTab = currentRoute,
                onTabClick = {route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        },
        floatingActionButton = {
            BarHome(
                currentTab = currentRoute,
                onTabClick = { navController.navigate("HomeB") },
                modifier = Modifier.offset(y = 57.dp) //もっとかしこくしたい
            )
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "HOmeB",//koreirukane
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("DeadlinesB") {
                Text("最近の予定画面")
            }
            composable("SearchB") {
                Text("検索画面")
            }
            composable("HomeB") {
                MainScreen()
            }
            composable("CalendarB") {
                Text("カレンダー画面")
            }
            composable("ProfileB") {
                Text("プロフィール画面")
            }
        }
    }
}