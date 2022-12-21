package com.shahad.app.shoppingapp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shahad.app.shoppingapp.R
import com.shahad.app.shoppingapp.ui.theme.appColors
import com.shahad.app.shoppingapp.viewModels.models.CategoryUI

@Composable
fun CategoryItem(
    modifier: Modifier,
    categoryUI: CategoryUI
){
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = categoryUI.title,
                    style = TextStyle(
                        color = MaterialTheme.appColors.primaryText,
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = categoryUI.description,
                    style = TextStyle(
                        color = MaterialTheme.appColors.gray,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
            Text(
                text = stringResource(id = R.string.view_all),
                style = TextStyle(
                    color = MaterialTheme.appColors.primaryText,
                    fontSize = 14.sp,
                )
            )
        }
        LazyRow(
            contentPadding = PaddingValues(start = 16.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(categoryUI.content){
                ProductItem(
                    modifier = Modifier,
                    productUI = it
                )
            }
        }
    }
}