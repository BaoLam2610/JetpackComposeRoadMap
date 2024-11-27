@file:OptIn(ExperimentalMaterial3Api::class)

package com.lambao.jetpackcompose.basic.ui.demo

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lambao.jetpackcompose.basic.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MusicContainerScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Playing from playlist\nHyper",
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Center
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_expand_more),
                            modifier = Modifier.size(16.dp),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_settings),
                            modifier = Modifier.size(20.dp),
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Image(
            painter = painterResource(R.drawable.bg_gradient),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = Color.Transparent
        ) {


            MusicColumnContainer()
        }
    }
}

@Composable
fun MusicColumnContainer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.img_thumbnail),
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.8f)
                .aspectRatio(1f),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.weight(1f))
        SongTitleArea(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        SongSliderArea(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )
        SongTimelineArea(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        SongControlArea(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun SongTitleArea(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Wrecked", style = MaterialTheme.typography.titleLarge.copy(color = Color.White))
        Text(
            "Alan Walker",
            style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFF888888))
        )
    }
}

@Composable
fun SongSliderArea(modifier: Modifier = Modifier) {
    var sliderValue by remember { mutableFloatStateOf(0f) }
    Slider(
        value = sliderValue,
        onValueChange = {
            sliderValue = it
        },
        modifier = modifier,
        colors = SliderDefaults.colors(
            thumbColor = Color.White,
            activeTrackColor = Color.White,
            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        thumb = {
            Box(
                Modifier
                    .size(20.dp)
                    .background(Color.White, CircleShape)
            )
        }
    )
}

@Composable
fun SongTimelineArea(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("0:52", style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFF888888)))
        Text("4:26", style = MaterialTheme.typography.bodySmall.copy(color = Color(0xFF888888)))
    }
}

@Composable
fun SongControlArea(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_suffer),
            modifier = Modifier.size(24.dp),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(4.dp))
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_replay_10),
            modifier = Modifier.size(32.dp),
            contentDescription = null
        )
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_pause),
            modifier = Modifier.size(56.dp),
            contentDescription = null
        )
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_foward_10),
            modifier = Modifier.size(32.dp),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(4.dp))
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_repeat),
            modifier = Modifier.size(24.dp),
            contentDescription = null
        )
    }
}