package com.example.qiitaapp.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.qiitaapp.presentation.viewmodel.ArticleDetailViewModel
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewStateWithHTMLData

@Composable
fun ArticleDetailsScreen() {
    val viewModel: ArticleDetailViewModel = hiltViewModel()
    val article = viewModel.state.value.article

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("記事詳細") },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(Icons.Outlined.Favorite, "Favorite")
                        Icon(Icons.Filled.FavoriteBorder, "Favorite")
                    }
                }
            )
        },
    ) { contentPadding ->
        if (article != null) {
            val content = requireNotNull(article.htmlContent)
            val webViewState = rememberWebViewStateWithHTMLData(data = content)

            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                WebView(state = webViewState)

            }
        }
    }
}