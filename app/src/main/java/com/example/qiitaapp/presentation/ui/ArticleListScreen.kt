package com.example.qiitaapp.presentation.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.qiitaapp.presentation.viewmodel.ArticlesScreenState
import com.example.qiitaapp.presentation.viewmodel.ArticlesViewModel

@Composable
fun ArticleListScreen(
    state: ArticlesScreenState,
    onItemClick: (id: String) -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(
                vertical = 8.dp,
                horizontal = 8.dp
            )
        ) {
            items(state.articles) { article ->
                Text(article.title,
                    modifier = Modifier.clickable { onItemClick(article.id) })

            }
        }

        if (state.isLoading)
            CircularProgressIndicator()
    }

}
