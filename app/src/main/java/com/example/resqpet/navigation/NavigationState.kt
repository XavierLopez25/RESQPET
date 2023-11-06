package com.example.resqpet.navigation


sealed class NavigationState(val route: String) {

    object Home: NavigationState("Home")
    object Register: NavigationState("Register")
    object Login: NavigationState("Login")
    object MainMenu: NavigationState("Main Menu")
    object Search: NavigationState("Search")
    object Adopt: NavigationState("Adopt")
    object Event: NavigationState("Event")
    object Donate: NavigationState("Donation")
    object Health: NavigationState("Health")
    object Profile: NavigationState("Profile")
    object Posts: NavigationState("Posts")
    object animalProfileDetail: NavigationState("animalProfile/{postId}")

    object eventDetail: NavigationState("eventInfo/{postId}")

    object hcDetail: NavigationState("health_care/{postId}")



    object AddPost: NavigationState("AddPost")


}