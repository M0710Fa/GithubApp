package com.example.githubapp.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapp.model.repository.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {
    //Viewの状態を表すSealed Class
    sealed class UiState{
        //初期状態
        object Initial: UiState()
        //ローディング
        object  Loading: UiState()
        //読み込み成功
        object  Success: UiState()
        //読み込み失敗
        object  Failure: UiState()
    }

    val uiState: MutableState<UiState> = mutableStateOf(UiState.Initial)

    //検索フォームの入力文字
    val searchQuery: MutableState<String> = mutableStateOf("")

    val userDetail = mutableStateOf(User(UserId(0),"", ImageUrl(""), HtmlUrl("")))

    fun onSearchTapped(){
        val searchQuery = searchQuery.value

        viewModelScope.launch {
            uiState.value = UiState.Loading
            try {
                userDetail.value = userRepository.getUser(userName = searchQuery)
                uiState.value = UiState.Success
            }catch (e: Exception){
                uiState.value = UiState.Failure
            }
        }
    }
}