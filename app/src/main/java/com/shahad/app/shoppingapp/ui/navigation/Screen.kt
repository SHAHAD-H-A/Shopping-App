package com.shahad.app.shoppingapp.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.shahad.app.shoppingapp.R

sealed class NavScreen(
    route: String,
    @StringRes title: Int,
    @DrawableRes val icon: Int
): Screen(route, title){
    object Home: NavScreen("HOME_SCREEN", R.string.home,R.drawable.ic_home)
    object Shop: NavScreen("SHOP_SCREEN", R.string.shop,R.drawable.ic_shope)
    object Bag: NavScreen("BAG_SCREEN", R.string.bag,R.drawable.ic_bag)
    object Favorite: NavScreen("FAVORITE_SCREEN", R.string.favorite,R.drawable.ic_favorite)
    object Profile: NavScreen("PROFILE_SCREEN", R.string.profile,R.drawable.ic_profile)

}

sealed class Screen(
    val route: String,
    @StringRes val title: Int
)
