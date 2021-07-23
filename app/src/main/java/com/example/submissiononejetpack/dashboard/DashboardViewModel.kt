package com.example.submissiononejetpack.dashboard

import androidx.lifecycle.ViewModel
import com.example.submissiononejetpack.model.RecipeData
import com.example.submissiononejetpack.model.RecipeModel

class DashboardViewModel:ViewModel() {

    fun getRecipe(): List<RecipeModel> = RecipeData.generateRecipeData()

}