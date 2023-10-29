package com.example.resqpet.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.resqpet.ui.animalprofile.view.AnimalProfile
import com.example.resqpet.ui.donation.view.Donation
import com.example.resqpet.ui.editprofile.view.EditProfileScreen
import com.example.resqpet.ui.events.view.MainEvent
import com.example.resqpet.ui.health.view.ServiceRQP
import com.example.resqpet.ui.login.view.LoginResQPet
import com.example.resqpet.ui.mainmenu.view.MainMenuResQPet
import com.example.resqpet.ui.petlist.view.PetList
import com.example.resqpet.ui.postlist.view.PostFiltering
import com.example.resqpet.ui.register.view.RegisterResQPet
import com.example.resqpet.ui.start.view.MainMenu

@Composable
fun Navigation(modifier: Modifier = Modifier) {

    // Create a navigation controller to manage the navigation stack.
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationState.Home.route,
        modifier = modifier
    ) {
        // Define the composable destination for the Home route.
        composable(route = NavigationState.Home.route) {
            MainMenu(navController)
        }

        composable(route = NavigationState.Register.route) {
            RegisterResQPet(navController)
        }

        composable(route = NavigationState.Login.route) {
            LoginResQPet(navController)
        }

        composable(route = NavigationState.MainMenu.route) {
            MainMenuResQPet(navController)
        }

        composable(route = NavigationState.Adopt.route) {
            PetList(navController)
        }

        composable(route = NavigationState.Event.route) {
            MainEvent(navController)
        }

        composable(route = NavigationState.Donate.route) {
            Donation(navController)
        }

        composable(route = NavigationState.Posts.route) {
            PostFiltering(navController)
        }

        composable("postDetail/{postId}") { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")
            // Asegurarte de manejar el caso en el que animalId podría ser null
            println(postId)
            if(postId != null) {
                AnimalProfile(animalId = postId.toInt(), navController)
            }
            // Posiblemente manejar un escenario de 'animalId' nulo mostrando una pantalla de error o una UI de respaldo
        }

        composable(route = NavigationState.Search.route) {
            PostFiltering(navController)
        }

        composable(route = NavigationState.Health.route) {
            ServiceRQP(navController)
        }

        composable(route = NavigationState.Profile.route) {
            EditProfileScreen(navController)
        }

    }
}