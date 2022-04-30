package com.example.composelearning.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelearning.ui.theme.Blue200
import com.example.composelearning.ui.theme.Blue700

/**
 * 抽取的公共的标题控件
 */
@Composable
fun TopAppBar(content: @Composable () -> Unit) {
    val appBarHeight = 56.dp
    Row(
        modifier = Modifier
            .background(
                Brush.linearGradient(listOf(Blue200, Blue700))
            )
            .fillMaxWidth()
            .height(appBarHeight),
        //下面是文字的居中设置
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar() {
        Text(text = "文字", style = TextStyle(color = Color.White))
    }
}