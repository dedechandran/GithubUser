package com.dedechandran.githubuser

sealed class Screen(val route: String){
    object Home : Screen(route = "home")
    object Details : Screen(route = "details/{id}"){
        fun createRoute(id: String) = "details/$id"
    }
}
