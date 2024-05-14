package com.comunidadedevspace.imc

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

object MyRoutes {
    const val CALCULATE_SCREEN = "calculate_screen"
    const val RESULT_SCREEN = "result_screen"
}

@Composable
fun AppNavigator(
    initialScreen: String
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = initialScreen
    ) {
        composable(MyRoutes.CALCULATE_SCREEN) {
            CalculateScreen(navController)
        }
        composable(
            route = "${MyRoutes.RESULT_SCREEN}/{result}",
            arguments = listOf(
                navArgument("result") { type = NavType.FloatType }
            )
        ) { backStackEntry ->
            val result = backStackEntry.arguments?.getFloat("result") ?: 0f
            ResultScreen(result)
        }
    }
}