package com.example.qiitaapp.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.qiitaapp.presentation.viewmodel.ArticleDetailViewModel
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewStateWithHTMLData

@Composable
fun ArticleDetailsScreen() {
    val viewModel: ArticleDetailViewModel = hiltViewModel()
    val article = viewModel.state.value.article

    if (article != null) {
        val content = requireNotNull(article.htmlContent)
        val webViewState = rememberWebViewStateWithHTMLData(data = content)

        Column(
            modifier = Modifier
                .padding(8.dp)
                .verticalScroll(rememberScrollState())
        ) {
            WebView(state = webViewState)

        }
    }
}