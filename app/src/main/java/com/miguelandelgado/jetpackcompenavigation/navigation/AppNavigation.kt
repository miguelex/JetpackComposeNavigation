package com.miguelandelgado.jetpackcompenavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.miguelandelgado.jetpackcompenavigation.screens.FirstScreen
import com.miguelandelgado.jetpackcompenavigation.screens.SecondScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = AppScreens.FirstScreen.route ){
        composable(route = AppScreens.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(route = AppScreens.SecondScreen.route + "/{text}",
        arguments = listOf(navArgument(name = "text"){
            type = NavType.StringType
        })) {
            SecondScreen(navController, it.arguments?.getString("text"))
        }

    }
}