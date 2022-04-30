package com.example.composelearning.ui.page

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.composelearning.model.BottomNavigationItem

@Composable
fun HomeFrame() {
    //首页底部的标题title
    val homeString = listOf("学习", "任务", "菜单", "我的")
    val homeUrl = listOf(
        "http://www.baidu.com",
        "http://www.taobao.com",
        "http://www.sougou.com",
        "http://www.soso.com"
    )
    //标题对应底部的四个tab
    val bottomNavigationItems = listOf(
        BottomNavigationItem(homeString[0], Icons.Filled.Home),
        BottomNavigationItem(homeString[1], Icons.Filled.DateRange),
        BottomNavigationItem(homeString[2], Icons.Filled.Menu),
        BottomNavigationItem(homeString[3], Icons.Filled.Person)
    )
    var currentNavigationIndex by remember {
        mutableStateOf(0)
    }

    Scaffold(bottomBar = {
        BottomNavigation(backgroundColor = MaterialTheme.colors.surface) {
            bottomNavigationItems.forEachIndexed { index, bottomNavigationItem ->
                BottomNavigationItem(
                    selected = currentNavigationIndex == index,
                    onClick = { currentNavigationIndex = index },
                    icon = {
                        Icon(imageVector = bottomNavigationItem.icon, contentDescription = null)
                    },
                    label = {
                        Text(text = bottomNavigationItem.title)
                    },
                    selectedContentColor = Color(0xFF149ee7),
                    unselectedContentColor = Color(0xFF999999),
                    alwaysShowLabel = true
                )
            }
        }
    }) {
        WebViewWidget(
            modifier = Modifier.background(Color.Transparent),
            token = homeUrl[currentNavigationIndex],
            id = "1"
        )
//        Box(modifier = Modifier.absolutePadding(0.dp, 0.dp, 0.dp, 0.dp)) {
//            Text(text = homeString[currentNavigationIndex])
//        }
        when (currentNavigationIndex) {
            0 -> StudyScreen()
            1 -> TaskScreen()
            2 -> MenuScreen()
            3 -> MineScreen()
        }
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewWidget(modifier: Modifier, token: String, id: String) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            val webView = WebView(context)
            webView.settings.javaScriptEnabled = true
            webView.settings.javaScriptCanOpenWindowsAutomatically = true
            webView.settings.domStorageEnabled = true
            webView.settings.loadsImagesAutomatically = true
            webView.settings.mediaPlaybackRequiresUserGesture = false
            webView.webViewClient = WebViewClient()
//            webView.loadUrl("http://h5.tdweilai.com/#/article/list/index/青岛/$id/$token")
            webView.loadUrl(token)
            webView
        })
}