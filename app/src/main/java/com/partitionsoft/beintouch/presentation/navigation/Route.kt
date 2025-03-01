package com.partitionsoft.beintouch.presentation.navigation

sealed class Route(
    val route: String
) {

    data object OnBoardingScreen : Route(route = "onboardingScreen")
    data object HomeScreen : Route(route = "homeScreen")
    data object SearchScreen : Route(route = "searchScreen")
    data object BookmarkScreen : Route(route = "bookmarkScreen")
    data object DetailsScreen : Route(route = "detailsScreen")
    data object AppStartNavigation : Route(route = "appStartNavigation")
    data object NewsNavigation : Route(route = "newsNavigation")
    data object NewsNavigatorScreen : Route(route = "newsNavigatorScreen")

}