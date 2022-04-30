package com.example.composelearning.ui.page

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelearning.ui.components.TopAppBar

@Composable
fun StudyScreen() {
    TopAppBar() {
        Text(text = "学习页面", style = TextStyle(color = Color.White))
    }
}

@Preview
@Composable
fun StudyScreenPreview() {
    StudyScreen()
}