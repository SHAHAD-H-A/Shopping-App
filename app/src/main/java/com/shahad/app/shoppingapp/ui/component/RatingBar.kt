package com.shahad.app.shoppingapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shahad.app.shoppingapp.R
import com.shahad.app.shoppingapp.ui.theme.appColors
import kotlin.math.round


@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    starsColor: Color = Color(0xFFFFBA49),
) {

    val filledStars = round(rating).toInt()
    val unfilledStars = (stars - kotlin.math.ceil(rating)).toInt()
//    val halfStar = !(rating.rem(1).equals(0.0))


    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        repeat(filledStars) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null,
                tint = starsColor
            )
        }

//        if (halfStar) {
//            Icon(
//                imageVector = Icons.Filled.Star,
//                contentDescription = null,
//                tint = starsColor
//            )
//        }

        repeat(unfilledStars) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null,
                tint = MaterialTheme.appColors.gray
            )
        }
    }
}
