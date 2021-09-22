package com.dedechandran.githubuser

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@ExperimentalMaterialApi
@Composable
fun GithubUserAppBar(
    modifier: Modifier = Modifier,
    title: String,
    onBackPressed: (() -> Unit)? = null
) {
    Surface(
        modifier = modifier,
        shape = RectangleShape,
        color = MaterialTheme.colors.primarySurface,
        contentColor = contentColorFor(backgroundColor = MaterialTheme.colors.primarySurface),
        elevation = AppBarDefaults.TopAppBarElevation,
    ) {
        ConstraintLayout(
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(AppBarDefaults.ContentPadding),
        ) {
            val (backIcon, titleRef) = createRefs()
            if (onBackPressed != null) {
                Surface(
                    modifier = modifier.constrainAs(backIcon) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    },
                    onClick = {
                        onBackPressed.invoke()
                    },
                    shape = CircleShape,
                    color = Color.Transparent
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
            }
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                modifier = modifier.constrainAs(titleRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }

    }
}