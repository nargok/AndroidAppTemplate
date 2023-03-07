package com.example.qiitaapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qiitaapp.application.ArticleViewUseCase
import com.example.qiitaapp.domain.model.vo.ArticleId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle,
    private val useCase: ArticleViewUseCase
) : ViewModel() {
    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
        _state.value = _state.value.copy(
            error = exception.message,
            isLoading = false
        )
    }

    private var _state = mutableStateOf(
        ArticleDetailScreenState(
            article = null,
            isLoading = true
        )
    )

    val state: State<ArticleDetailScreenState> get() = _state

    init {
        val articleId = ArticleId(stateHandle.get<String>("article_id") ?: "")
        getArticle(articleId)
    }

    private fun getArticle(id: ArticleId) {
        viewModelScope.launch(errorHandler) {
            _state.value = _state.value.copy(
                article = useCase.find(id),
                isLoading = false
            )
        }
    }
}