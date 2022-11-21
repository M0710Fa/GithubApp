package com.example.githubapp.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.githubapp.model.repository.User

@Composable
fun UserDetail(user: User){
    Row(
        modifier = Modifier.padding(4.dp)
    ) {
        AsyncImage(
            model = user.avatarUrl.value,
            contentDescription = "AvatarImage",
            modifier = Modifier
                .padding(4.dp)
                .clip(CircleShape)
                .weight(1f)
        )
        Column(
            modifier = Modifier
                .padding(4.dp)
                .weight(3f).align(alignment = CenterVertically)
        ) {
            Text(text = "ID: ${user.userId.value}")
            Text(text = "名前: ${user.name}")
            Text(text = "URL: ${user.htmlUrl.value}")
        }
    }
}