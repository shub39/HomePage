package com.shub39.homepage.homepage

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mikepenz.hypnoticcanvas.shaderBackground
import com.mikepenz.hypnoticcanvas.shaders.MeshGradient
import com.shub39.homepage.core.presentation.generateColorList
import com.skydoves.landscapist.coil3.CoilImage
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.placeholder.shimmer.Shimmer
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.DiceSix

@Composable
fun HomePage(
    state: HomePageState,
    action: (HomePageAction) -> Unit
) {
    val seedColor by animateColorAsState(
        targetValue = state.seedColor
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .shaderBackground(
                MeshGradient(
                    colors = generateColorList(seedColor).toTypedArray(),
                    scale = 10f
                ),
                speed = state.meshSpeed
            ),
        color = Color.Transparent
    ) {
        if (state.currentData != null) {
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, MaterialTheme.colorScheme.primaryContainer)
                            )
                        )
                        .fillMaxSize()
                )

                Row(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    CoilImage(
                        imageModel = { state.currentData.recenttracks.track[0].image[3].text },
                        component = rememberImageComponent {
                            +ShimmerPlugin(
                                Shimmer.Resonate(
                                    baseColor = Color.Transparent,
                                    highlightColor = MaterialTheme.colorScheme.onSurface
                                )
                            )
                        },
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.small)
                            .size(80.dp)
                    )

                    Column {
                        Text(
                            text = state.currentData.recenttracks.track[0].name,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = state.currentData.recenttracks.track[0].artist.text,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.Bold,
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    IconButton(
                        onClick = {
                            action(HomePageAction.OnRandomColors)
                        }
                    ) {
                        Icon(
                            imageVector = FontAwesomeIcons.Solid.DiceSix,
                            contentDescription = "Randomise",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}