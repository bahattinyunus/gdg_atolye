package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.components.CryptoItemRow
import com.example.myapplication.ui.screens.DetailScreen
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: CryptoViewModel by viewModels()
                    CryptoApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun CryptoApp(viewModel: CryptoViewModel) {
    val navController = rememberNavController()
    val state by viewModel.state.collectAsState()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            LazyColumn {
                items(state) { item ->
                    CryptoItemRow(item = item) {
                        navController.navigate("detail/${item.pair}/${item.last}")
                    }
                }
            }
        }
        composable("detail/{pair}/{price}") { backStackEntry ->
            val pair = backStackEntry.arguments?.getString("pair") ?: ""
            val price = backStackEntry.arguments?.getString("price") ?: ""
            DetailScreen(pair = pair, price = price) {
                navController.popBackStack()
            }
        }
    }
}


