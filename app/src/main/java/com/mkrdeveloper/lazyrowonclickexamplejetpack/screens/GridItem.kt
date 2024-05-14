package com.mkrdeveloper.lazyrowonclickexamplejetpack.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.Model.Doggie
import com.mkrdeveloper.lazyrowonclickexamplejetpack.R
import com.mkrdeveloper.lazyrowonclickexamplejetpack.ui.theme.LazyRowOnClickExampleJetpackTheme

@Composable
fun GridItem(
    modifier: Modifier = Modifier,
    doggieItem: Doggie
) {
    Column (modifier = modifier.fillMaxWidth()
    ){
       Image(
           painter = painterResource(id = doggieItem.photo),
           contentDescription = doggieItem.name,
           modifier = Modifier.fillMaxWidth().size(height = 200.dp, width = 200.dp)
       )
        Spacer(
            modifier = Modifier.height(8.dp))
        Text(
            text = doggieItem.name,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
            )
    }

}

@Preview (showBackground = true)
@Composable
private fun GridItemPreview() {
    LazyRowOnClickExampleJetpackTheme {
        GridItem(doggieItem = Doggie(id = 1, name = "Corgi", photo = R.drawable.img))
    }

}