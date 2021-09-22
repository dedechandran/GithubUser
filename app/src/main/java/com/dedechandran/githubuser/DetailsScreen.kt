package com.dedechandran.githubuser

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource

@ExperimentalMaterialApi
@Composable
fun DetailsScreen(modifier: Modifier = Modifier, userId: String, onNavigateBack: () -> Unit) {
    Scaffold(
        topBar = {
            GithubUserAppBar(
                title = "Details",
                onBackPressed = {
                    onNavigateBack.invoke()
                },
            )
        }
    ) {
        val user = DataSource.getDetails(userId)
        user?.let {
            GithubUserDetails(user = it)
        }
    }
}

@Composable
fun GithubUserDetails(modifier: Modifier = Modifier, user: GithubUser) {
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = user.image),
            contentDescription = "",
            modifier = modifier
                .wrapContentSize()
                .clip(CircleShape)
        )
        Text(
            text = user.name,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.spacing_1)))
        Text(text = user.location)
    }
}