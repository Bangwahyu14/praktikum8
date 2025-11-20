package com.example.praktikum8

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.praktikum8.ui.theme.view.Beranda
import com.example.praktikum8.ui.theme.view.FormIsian
import com.example.praktikum8.ui.theme.view.TampilData

// Enum untuk daftar screen
enum class Navigasi {
    Beranda,
    Formulirku,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Beranda.name,
            modifier = Modifier.padding(isiRuang)
        ) {

            composable(Navigasi.Beranda.name) {
                Beranda(
                    onSubmitClick = {
                        navController.navigate(Navigasi.Formulirku.name)
                    }
                )
            }


            composable(Navigasi.Formulirku.name) {
                FormIsian(navController = navController)
            }


            composable(
                route = "Detail/{nama}/{jenisKelamin}/{alamat}",
                arguments = listOf(
                    navArgument("nama") { defaultValue = "" },
                    navArgument("jenisKelamin") { defaultValue = "" },
                    navArgument("alamat") { defaultValue = "" }
                )
            ) { backStackEntry ->
                val nama = backStackEntry.arguments?.getString("nama")
                val jenisKelamin = backStackEntry.arguments?.getString("jenisKelamin")
                val alamat = backStackEntry.arguments?.getString("alamat")

                TampilData(
                    navController = navController,
                    nama = nama,
                    jenisKelamin = jenisKelamin,
                    alamat = alamat
                )
            }
        }
    }
}