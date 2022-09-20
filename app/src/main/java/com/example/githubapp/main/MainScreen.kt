package com.example.githubapp.main

import android.widget.SearchView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel()) {
    val uiState by mainViewModel.uiState
    val user by mainViewModel.userDetail

    Column(modifier = Modifier.fillMaxWidth()) {
        SearchView(
            searchQuery = mainViewModel.searchQuery,
            onSearchButtonTapped = { mainViewModel.onSearchTapped() }
        )
        when(uiState){
            is MainViewModel.UiState.Initial ->{
                InitialView()
            }
            is MainViewModel.UiState.Success ->{
                UserDetail(user = user)
            }
            is MainViewModel.UiState.Loading ->{
                LoadingView()
            }
            is MainViewModel.UiState.Failure ->{
                ErrorView()
            }
        }
    }
}

@Composable
fun SearchView(
    searchQuery: MutableState<String>,
    onSearchButtonTapped: () -> Unit
){
  Row() {
      TextField(
          label = { Text(text = "Githubアカウントを入力")},
          value = searchQuery.value,
          onValueChange = { text ->
              searchQuery.value = text
          })
      Button(
          onClick = {
              onSearchButtonTapped()
          }
      ) {
          Text(text = "検索")
      }
  }
}

@Composable
fun InitialView(){
    Text(text = "検索してください")
}

@Composable
fun LoadingView(){
    Column {
        CircularProgressIndicator()
        Text(text = "読み込み中")
    }
}

@Composable
fun ErrorView(){
    Text(text = "読み込み失敗")
}