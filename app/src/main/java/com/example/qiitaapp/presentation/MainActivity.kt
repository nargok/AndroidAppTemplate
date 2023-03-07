package com.example.qiitaapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.qiitaapp.domain.model.Article
import com.example.qiitaapp.presentation.theme.QiitaAppTheme
import com.example.qiitaapp.presentation.ui.ArticleDetailsScreen
import com.example.qiitaapp.presentation.ui.theme.ArticleListScreen
import com.example.qiitaapp.presentation.viewmodel.ArticlesScreenState
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
                    Log.d("Clicked Article ID", id.value)
                    navController.navigate("articles/${id.value}")
                }
            )
        }
        composable(route = "articles/{article_id}",
            arguments = listOf(navArgument("article_id") {
                type = NavType.StringType
            })
        ) {
            ArticleDetailsScreen()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val articles: List<Article> = listOf<Article>(
//        Article("aaa", "hogehoge"),
//        Article("bbb", "fugafuga"),
    )

    ArticleListScreen(state = ArticlesScreenState(articles, isLoading = true), onItemClick = {})
}