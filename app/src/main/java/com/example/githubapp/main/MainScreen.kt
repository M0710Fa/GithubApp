package com.example.githubapp.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by mainViewModel.uiState
    val user by mainViewModel.userDetail

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = CenterHorizontally) {
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
    onSearchButtonTapped: () -> Unit,
    modifier: Modifier = Modifier
){
  Row(
      horizontalArrangement = Arrangement.Center,
      modifier = modifier.padding(16.dp)
  ) {
      TextField(
          label = { Text(text = "Githubアカウントを入力")},
          value = searchQuery.value,
          onValueChange = { text ->
              searchQuery.value = text
          })
      Button(
          onClick = {
              onSearchButtonTapped()
          },
          modifier = Modifier
              .align(CenterVertically)
              .padding(4.dp)
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
        Text(text = "読み込み中")
    }
}

@Composable
fun ErrorView(){
    Text(text = "読み込み失敗")
}