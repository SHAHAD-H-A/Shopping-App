package com.shahad.app.shoppingapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.shahad.app.shoppingapp.R
import com.shahad.app.shoppingapp.ui.component.CategoryItem
import com.shahad.app.shoppingapp.ui.navigation.NavScreen
import com.shahad.app.shoppingapp.ui.theme.appColors
import com.shahad.app.shoppingapp.viewModels.HomeViewModel
import com.shahad.app.shoppingapp.viewModels.models.CategoryUI
import com.shahad.app.shoppingapp.viewModels.states.HomeStateScreen

fun NavGraphBuilder.homeRoute(navHostController: NavHostController){
    composable(NavScreen.Home.route){
        HomePage(navController = navHostController)
    }
}

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val saleCategory by viewModel.saleCategory.collectAsState()
    val newCategory by viewModel.newCategory.collectAsState()
    val clothesCategory by viewModel.clothesCategory.collectAsState()
    val shoesCategory by viewModel.shoesCategory.collectAsState()
    val accessoriesCategory by viewModel.accessoriesCategory.collectAsState()
    HomeScreen(
        modifier = modifier,
        saleCategory = saleCategory,
        newCategory = newCategory,
        clothesCategory = clothesCategory,
        shoesCategory = shoesCategory,
        accessoriesCategory = accessoriesCategory
    )

}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    saleCategory: HomeStateScreen<CategoryUI>,
    newCategory: HomeStateScreen<CategoryUI>,
    clothesCategory: HomeStateScreen<CategoryUI>,
    shoesCategory: HomeStateScreen<CategoryUI>,
    accessoriesCategory: HomeStateScreen<CategoryUI>
){
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ){
        item {
            Box(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .fillParentMaxHeight(0.5f)
            ){
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription =null,
                    modifier = Modifier.matchParentSize(),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .background(
                            Brush.verticalGradient(
                                0F to Color.Transparent,
                                .5F to Color.Black.copy(alpha = 0.5F),
                                1F to Color.Black.copy(alpha = 0.8F)
                            )
                        )
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(id = R.string.fashion_sale),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 48.sp,
                            textAlign = TextAlign.Start,
                            color = Color.White,
                        )
                    )
                    TextButton(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.appColors.primary
                        ),
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        Text(
                            text = "Check",
                            modifier = Modifier
                                .padding(horizontal = 40.dp),
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White,
                            )
                        )
                    }
                }
            }
        }
        item{
            saleCategory.takeIf { it is HomeStateScreen.Success }?.let {
                CategoryItem(
                    modifier = Modifier,
                    categoryUI = (it as HomeStateScreen.Success<CategoryUI>).data
                )
            }
        }
        item{
            newCategory.takeIf { it is HomeStateScreen.Success }?.let {
                CategoryItem(
                    modifier = Modifier,
                    categoryUI = (it as HomeStateScreen.Success<CategoryUI>).data
                )
            }
        }
        item{
            shoesCategory.takeIf { it is HomeStateScreen.Success }?.let {
                CategoryItem(
                    modifier = Modifier,
                    categoryUI = (it as HomeStateScreen.Success<CategoryUI>).data
                )
            }
        }
        item{
            clothesCategory.takeIf { it is HomeStateScreen.Success }?.let {
                CategoryItem(
                    modifier = Modifier,
                    categoryUI = (it as HomeStateScreen.Success<CategoryUI>).data
                )
            }
        }
        item{
            accessoriesCategory.takeIf { it is HomeStateScreen.Success }?.let {
                CategoryItem(
                    modifier = Modifier,
                    categoryUI = (it as HomeStateScreen.Success<CategoryUI>).data
                )
            }
        }
    }
}
