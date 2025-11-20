package com.example.praktikum8.ui.theme.view.uicontroller


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum8.model.DataJK.JenisJK
import com.example.praktikum8.ui.theme.view.FormIsian
import com.example.praktikum8.ui.theme.view.TampilSiswa
import com.example.praktikum8.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulirku,
    Detail
}

@Composable
fun SiswaApp(
    //edit 1: parameter viewModel
    modifier: Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    Scaffold { isiRuang->
        //edit 2 tambahkan variable uiState
        val uiState = viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulirku.name,

            modifier = Modifier.padding(isiRuang)){
            composable(route = Navigasi.Formulirku.name){
                val konteks = LocalContext.current
                FormIsian (
                    pilihanJK = JenisJK.map { id -> konteks.resources.getString(id)},
                    onSubmitButtonClicked = {
                        viewModel.setSiswa(it)
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name){
                TampilSiswa(
                    statusUiSiswa = uiState.value,
                    onBackButtonClicked = {
                        cancelAndBackToFormulirku(navController)
                    }
                )
            }
        }
    }
}


private fun cancelAndBackToFormulirku(
    navController:NavHostController
){
    navController.popBackStack(Navigasi.Formulirku.name,
        inclusive = false)
}