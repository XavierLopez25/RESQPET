package com.example.resqpet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.resqpet.ui.animalprofile.view.AnimalProfile
import com.example.resqpet.ui.createpost.view.CreatePost
import com.example.resqpet.ui.createpost.viewmodel.CreatePostViewModel
import com.example.resqpet.ui.donation.view.Donation
import com.example.resqpet.ui.editprofile.view.EditProfileScreen
import com.example.resqpet.ui.events.view.MainEvent
import com.example.resqpet.ui.health.view.ServiceRQP
import com.example.resqpet.ui.login.view.LoginResQPet
import com.example.resqpet.ui.login.viewmodel.LoginViewModel
import com.example.resqpet.ui.mainmenu.view.MainMenuResQPet
import com.example.resqpet.ui.petlist.view.PetList
import com.example.resqpet.ui.postlist.view.PostFiltering
import com.example.resqpet.ui.register.view.RegisterResQPet
import com.example.resqpet.ui.register.viewmodel.RegisterViewModel
import com.example.resqpet.ui.start.view.MainMenu

@Composable
fun Navigation(postsViewModel: CreatePostViewModel, registerViewModel: RegisterViewModel, loginViewModel: LoginViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationState.Home.route,
    ) {
        composable(route = NavigationState.Home.route) {
            MainMenu(navController)
        }

        composable(route = NavigationState.Register.route) {
            RegisterResQPet(navController, registerViewModel)
        }

        composable(route = NavigationState.Login.route) {
            LoginResQPet(navController, loginViewModel)
        }

        composable(route = NavigationState.MainMenu.route) {
            MainMenuResQPet(navController, postsViewModel, registerViewModel, loginViewModel)
        }

        composable(route = NavigationState.Adopt.route) {
            PetList(navController, postsViewModel)
        }

        composable(route = NavigationState.Donate.route) {
            Donation(navController)
        }

        composable(route = NavigationState.Posts.route) {
            PostFiltering(navController, postsViewModel)
        }

        composable("animalProfile/{postId}") { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")
            println(postId)
            if(postId != null) {
                AnimalProfile(animalId = postId.toInt(), navController, postsViewModel)
            }
        }

        composable("eventInfo/{postId}") { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")
            println(postId)
            if(postId != null) {
                MainEvent(eventId = postId.toInt(), navController, postsViewModel)
            }
        }

        composable("health_care/{postId}") { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")
            println(postId)
            if(postId != null) {
                ServiceRQP(healthCId = postId.toInt(), navController, postsViewModel)
            }
        }

        composable(route = NavigationState.Profile.route) {
            EditProfileScreen(navController)
        }

        composable(route = NavigationState.AddPost.route) {
            CreatePost(navController, postsViewModel)
        }

    }
}