package com.mkrdeveloper.lazyrowonclickexamplejetpack.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(
    imageId: Array<Int>,
    names: Array<String>,
    ingredients: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    Column {
        LazyRow (contentPadding = PaddingValues(16.dp)) {
            val itemCount = imageId.size
            items(itemCount) {
                RowItem(
                    modifier.fillMaxWidth(),
                    painter = imageId,
                    title = names,
                    itemIndex = it,
                    navController = navController
                )
            }

        }
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            val itemCount = imageId.size
            items(itemCount) {
                ColumnItem(
                    modifier.fillMaxWidth(),
                    painter = imageId,
                    title = names,
                    ingredients = ingredients,
                    itemIndex = it,
                    navController = navController
                )

            }
        }
    }

}

@Composable
fun RowItem(
modifier: Modifier,
painter: Array<Int>,
title: Array<String>,
itemIndex: Int,
navController: NavController
) {
    Column {
        Row {
            Card(
                modifier
                    .padding(10.dp)
                    .wrapContentSize()
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(route = "DetailScreen/$itemIndex")
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.fillMaxWidth()
//                    verticalAlignment = Alignment.Top,
//                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    Image(
                        painter = painterResource(id = painter[itemIndex]),
                        contentDescription = title[itemIndex],
                        alignment = Alignment.Center,
                        modifier = modifier.size(175.dp).fillMaxWidth()
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = modifier.width(200.dp).padding(10.dp)) {
                        Text(text = title[itemIndex],
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center)


                    }
                }

            }
        }
    }

}


@Composable
fun ColumnItem(
    modifier: Modifier,
    painter: Array<Int>,
    title: Array<String>,
    ingredients: Array<String>,
    itemIndex: Int,
    navController: NavController
) {


    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route = "DetailScreen/$itemIndex")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                alignment = Alignment.Center,
//                modifier = modifier.size(175.dp).fillMaxWidth()
            )
            Column(
            modifier = modifier.padding(10.dp)) {
                Text(text = title[itemIndex], fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = ingredients[itemIndex], fontSize = 18.sp)

            }
        }

    }





//    Card(
//        modifier
//            .padding(10.dp)
//            .wrapContentSize()
//            .clickable {
//                navController.navigate(route = "DetailScreen/$itemIndex")
//            },
//        colors = CardDefaults.cardColors(
//            containerColor = Color.White
//        ),
//        elevation = CardDefaults.cardElevation(10.dp)
//    ) {
//        Row(
//            modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.Top,
//            horizontalArrangement = Arrangement.spacedBy(15.dp)
//        ) {
//            Image(
//                painter = painterResource(id = painter[itemIndex]),
//                contentDescription = title[itemIndex],
//                alignment = Alignment.Center,
//                modifier = modifier.size(140.dp)
//            )
//            Column(modifier.padding(12.dp)) {
//                Text(text = title[itemIndex], fontSize = 24.sp, fontWeight = FontWeight.Bold)
//                Text(text = ingredients[itemIndex], fontSize = 18.sp)
//
//            }
//        }
//
//    }


}



