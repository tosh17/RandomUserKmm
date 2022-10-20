package ru.thstdio.firstapp2.android.presentation.list

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import ru.thstdio.firstapp2.domain.model.UserInfo

@Composable
fun UserListScreen(viewModel: UserListViewModel = viewModel()) {
    val uiState by viewModel.state.collectAsState()
    Crossfade(targetState = uiState) { state ->
        when (state) {
            UserListScreenState.Loading -> LoadingState()
            is UserListScreenState.SuccessLoad -> SuccessLoadState(state)
        }
    }

}

@Composable
private fun LoadingState() {
    Column {
        repeat(10) {
            LoadingShimmerEffect()
        }
    }
}

@Composable
fun LoadingShimmerEffect() {

    //These colors will be used on the brush. The lightest color should be in the middle

    val gradient = listOf(
        Color.LightGray.copy(alpha = 0.9f), //darker grey (90% opacity)
        Color.LightGray.copy(alpha = 0.3f), //lighter grey (30% opacity)
        Color.LightGray.copy(alpha = 0.9f)
    )

    val transition = rememberInfiniteTransition() // animate infinite times

    val translateAnimation = transition.animateFloat( //animate the transition
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000, // duration for the animation
                easing = FastOutLinearInEasing
            )
        )
    )
    val brush = linearGradient(
        colors = gradient,
        start = Offset(200f, 200f),
        end = Offset(
            x = translateAnimation.value,
            y = translateAnimation.value
        )
    )
    ShimmerUserItem(brush = brush)
}

@Composable
private fun ShimmerUserItem(brush: Brush) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(brush)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .height(16.dp)
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(brush)
        )
    }
}

@Composable
private fun SuccessLoadState(uiState: UserListScreenState.SuccessLoad) {
    val users = uiState.users

    LazyColumn {
        items(users.size) { index ->
            UserItem(users[index])
        }
    }
}


@Composable
private fun UserItem(item: UserInfo) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = rememberAsyncImagePainter(item.icon),
            contentDescription = null,
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = item.name,
            fontWeight = FontWeight(700),
            fontSize = 18.sp
        )
    }
}
