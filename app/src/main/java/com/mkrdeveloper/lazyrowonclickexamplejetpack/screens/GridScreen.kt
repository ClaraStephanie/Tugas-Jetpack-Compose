package com.mkrdeveloper.lazyrowonclickexamplejetpack.screens

import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.Model.Doggie
import com.mkrdeveloper.lazyrowonclickexamplejetpack.screens.GridScreen
import com.data.Data
import com.mkrdeveloper.lazyrowonclickexamplejetpack.ui.theme.LazyRowOnClickExampleJetpackTheme

@Composable
fun GridScreen(
    modifier: Modifier = Modifier,
    doggieItem: List<Doggie> = Data.pet
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(140.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(doggieItem, key = {it.id}){
            GridItem(doggieItem = it)
        }
    }

}

@Preview (showBackground = true)
@Composable
private fun GridScreenPreview() {
    LazyRowOnClickExampleJetpackTheme {
        GridScreen(doggieItem = Data.pet)
    }


}
