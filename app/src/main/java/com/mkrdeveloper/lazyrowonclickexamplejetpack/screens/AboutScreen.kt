package com.mkrdeveloper.lazyrowonclickexamplejetpack.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkrdeveloper.lazyrowonclickexamplejetpack.R
import com.mkrdeveloper.lazyrowonclickexamplejetpack.ui.theme.LazyRowOnClickExampleJetpackTheme


@Composable
fun AboutScreen(modifier: Modifier = Modifier) {
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.img_10),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape))
        Text(
            text = "Clara Stephanie Bernadeth Piay")
        Text(
            text = "clarapiay02Gmail.com")
        Row {
            Text(
                text = "Universitas Prima Indonesia |")
            Text(
                text = " Sistem Informasi")
        }
        }
    }


@Preview (showBackground = true)
@Composable
private fun AboutScreenPreview() {
    LazyRowOnClickExampleJetpackTheme {
        AboutScreen()
    }

}