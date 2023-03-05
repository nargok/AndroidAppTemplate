package com.example.qiitaapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qiitaapp.presentation.theme.QiitaAppTheme
import com.example.qiitaapp.presentation.ui.theme.ArticleListScreen
import com.example.qiitaapp.presentation.viewmodel.ArticlesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QiitaAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    QiitaApp()
                }
            }
        }
    }
}


@Composable
private fun QiitaApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "articles") {
        composable(route = "articles") {
            val viewModel: ArticlesViewModel = hiltViewModel()
            ArticleListScreen(
                state = viewModel.state.value,
                onItemClick = { id ->
                    Log.d("Clicked Article ID", id)
                }
            )
        }
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QiitaAppTheme {
        Greeting("Android")
    }
}