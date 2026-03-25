package com.cheshuina_antonova.student_planner_isp_231.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ScaleFactor
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cheshuina_antonova.student_planner_isp_231.ui_model.DetailsScreen
import com.cheshuina_antonova.student_planner_isp_231.ui_model.Homescreen
import com.cheshuina_antonova.student_planner_isp_231.ui_model.ProfileScreen
import com.cheshuina_antonova.student_planner_isp_231.ui_model.SettingsScreen
import com.cheshuina_antonova.student_planner_isp_231.ui_model.RaspisanieScreen


@Composable
fun StudentPlannerNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ){
        composable(route = Screen.Home.route){
            Homescreen(
                onSubjectClick = { subjectId ->
                    navController.navigate(Screen.Details.createRoute(subjectId))
                },
                onProfileClick = {
                    navController.navigate(Screen.Profile.route)
                },
                onSettingsClick = {
                    navController.navigate(Screen.Settings.route)
                },
                onRaspisanieClick = {
                    navController.navigate(Screen.Raspisanie.route)
                }
            )
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument("subjectId"){
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val subjectId = backStackEntry.arguments?.getString("subjectId") ?: ""
            DetailsScreen(
                subjectId = subjectId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Screen.Profile.route){
            ProfileScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Screen.Settings.route){
            SettingsScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Screen.Raspisanie.route){
            RaspisanieScreen(
                onNavigateBack = { navController.popBackStack() },
            )
        }
    }
}