package com.shahad.app.shoppingapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shahad.app.shoppingapp.R
import com.shahad.app.shoppingapp.ui.theme.appColors
import com.shahad.app.shoppingapp.viewModels.models.ProductUI
import java.util.*
import kotlin.math.roundToInt

@Composable
fun ProductItem(
    modifier: Modifier,
    productUI: ProductUI
){
    val priceStyle = if(productUI.isDiscount) {
        TextStyle(
            color = MaterialTheme.appColors.gray,
            textDecoration = TextDecoration.LineThrough,
            fontSize = 14.sp,
        )
    }else{
        TextStyle(
            color = MaterialTheme.appColors.primaryText,
            fontSize = 14.sp,
        )
    }
    val popColor = if (productUI.isDiscount) MaterialTheme.appColors.primary else Color(0xFF222222)

    Box(modifier = modifier){
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Image(
                painter = painterResource(R.drawable.main_image),
                contentDescription = productUI.name,
                modifier = Modifier
                    .width(148.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillBounds,
            )
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
               RatingBar(rating = productUI.rating)
               Text(
                   text = "(${productUI.rating.roundToInt()})" ,
                   color = MaterialTheme.appColors.secondaryText,
                   textAlign = TextAlign.Center,
                   fontSize = 10.sp
               )
            }
            Text(
                text = productUI.brandName.uppercase(Locale.getDefault()),
                style = TextStyle(
                    fontSize = 11.sp,
                    color = MaterialTheme.appColors.secondaryText,
                )
            )
            Text(
                text = productUI.name,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = MaterialTheme.appColors.primaryText,
                    fontWeight = FontWeight.Bold,
                )
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ){
                Text(
                    text = "${productUI.price}$",
                    style = priceStyle
                )
                if(productUI.isDiscount){
                    Text(
                        text = "${productUI.discount}$",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color(0xFFFF3E3E)
                        )
                    )
                }
            }
        }
        if(productUI.isPop){
            Text(
                text = productUI.pop,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(popColor)
                    .wrapContentSize()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                style = TextStyle(
                    fontSize = 11.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                ),
            )
        }
    }
}

@Preview
@Composable
fun PreviewProduct(){
    val productUI = ProductUI(
        name = "Evening Dress",
        brandName = "Dorothy Perkins",
        rating = 2.8,
        isPop = true,
        discount = 23,
        price = 40,
        isDiscount = true,
        id = 2,
        imageUrl = "",
        pop = "-20%"
    )
    ProductItem(modifier = Modifier, productUI = productUI)
}
