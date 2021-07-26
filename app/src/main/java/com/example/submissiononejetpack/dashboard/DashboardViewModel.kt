package com.example.submissiononejetpack.dashboard

import androidx.lifecycle.ViewModel
import com.example.submissiononejetpack.model.RecipeData
import com.example.submissiononejetpack.model.RecipeModel

class DashboardViewModel:ViewModel() {
    //fungsi untuk memanggil data dari RecipeData
    fun getRecipe(): List<RecipeModel> = RecipeData.generateRecipeData()

}