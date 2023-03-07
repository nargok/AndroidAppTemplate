package com.example.qiitaapp.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.qiitaapp.presentation.viewmodel.ArticleDetailViewModel

@Composable
fun ArticleDetailsScreen() {
    val viewModel: ArticleDetailViewModel = hiltViewModel()
    val article = viewModel.state.value.article

    if (article != null) {
        Column(
            modifier = Modifier.padding(8.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(article.title)
            Text(article.author.id)
            Spacer(modifier = Modifier.height(32.dp))
            Text(requireNotNull(article.body))
        }
    }
}