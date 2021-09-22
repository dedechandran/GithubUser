package com.dedechandran.githubuser

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dedechandran.githubuser.ui.theme.GithubUserTheme

@ExperimentalMaterialApi
@Composable
fun HomeScreen(modifier: Modifier = Modifier, onItemClicked: (String) -> Unit) {
    Scaffold(
        topBar = {
            GithubUserAppBar(title = "Github User Apps")
        }
    ) {
        GithubUserList(onItemClicked = onItemClicked)
    }
}


@ExperimentalMaterialApi
@Composable
fun GithubUserList(modifier: Modifier = Modifier, onItemClicked: (String) -> Unit) {
    val data = remember {
        DataSource.generateFakeData(10)
    }
    LazyColumn {
        items(data) { user ->
            GithubUserItem(item = user, onItemClicked = onItemClicked)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun GithubUserItem(
    modifier: Modifier = Modifier,
    item: GithubUser,
    onItemClicked: (String) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                horizontal = dimensionResource(id = R.dimen.spacing_2),
                vertical = dimensionResource(id = R.dimen.spacing_1)
            ),
        onClick = {
            onItemClicked.invoke(item.id.toString())
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(dimensionResource(id = R.dimen.spacing_1)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "",
                modifier = modifier
                    .wrapContentSize()
                    .clip(CircleShape)
            )
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = dimensionResource(id = R.dimen.spacing_1)),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = item.name,
                    modifier = modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.spacing_1)))
                Text(text = item.location, modifier = modifier.fillMaxWidth())
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val fakeData1 = DataSource.generateFakeData(1)
    GithubUserTheme {
        GithubUserItem(item = fakeData1.first(), onItemClicked = {})
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun GithubUserAppBarPreview() {
    GithubUserAppBar(title = "Github User Apps")
}