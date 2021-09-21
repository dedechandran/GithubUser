package com.dedechandran.githubuser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dedechandran.githubuser.ui.theme.GithubUserTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubUserTheme {
                GithubUserApp()
            }
        }
    }
}

@Composable
fun GithubUserApp(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        GithubUserAppBar()
        GithubUserList()
    }
}

@Composable
fun GithubUserAppBar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = RectangleShape,
        color = MaterialTheme.colors.primarySurface,
        contentColor = contentColorFor(backgroundColor = MaterialTheme.colors.primarySurface),
        elevation = AppBarDefaults.TopAppBarElevation,
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(AppBarDefaults.ContentPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Github User Apps", style = MaterialTheme.typography.h5)
        }

    }
}

@Composable
fun GithubUserList(modifier: Modifier = Modifier) {
    val data = remember {
        DataSource.generateFakeData(10)
    }
    LazyColumn {
        items(data) { user ->
            GithubUserItem(item = user)
        }
    }
}

@Composable
fun GithubUserItem(modifier: Modifier = Modifier, item: GithubUser) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                horizontal = dimensionResource(id = R.dimen.spacing_2),
                vertical = dimensionResource(id = R.dimen.spacing_1)
            )
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
        GithubUserItem(item = fakeData1.first())
    }
}

@Preview(showBackground = true)
@Composable
fun GithubUserAppBarPreview() {
    GithubUserAppBar()
}