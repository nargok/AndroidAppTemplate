package com.example.qiitaapp.presentation.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.qiitaapp.domain.model.Article
import com.example.qiitaapp.domain.model.vo.ArticleId
import com.example.qiitaapp.presentation.viewmodel.ArticlesScreenState

@Composable
fun ArticleListScreen(
    state: ArticlesScreenState,
    onItemClick: (id: ArticleId) -> Unit,
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
                ArticleItem(item = article, onItemClick = onItemClick)
            }
        }

        if (state.isLoading)
            CircularProgressIndicator()
    }

}


@Composable
fun ArticleItem(
    item: Article,
    onItemClick: (id: ArticleId) -> Unit
) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onItemClick(item.id) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            AsyncImage(
                model = item.author.profileImageUrl,
                contentDescription = item.author.id,
                modifier = Modifier
                    .size(36.dp)
                    .clip(shape = CircleShape)
            )

            Text(
                item.title,
                style = TextStyle(
                    fontSize = 14.sp,
                )
            )
        }
    }
}