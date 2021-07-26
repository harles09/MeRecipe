package com.example.submissiononejetpack.recipes

import androidx.lifecycle.ViewModel
import com.example.submissiononejetpack.model.RecipeData
import com.example.submissiononejetpack.model.RecipeModel

class RecipeViewModel:ViewModel() {
    //membuat variable recipeId tipe data String
    private lateinit var recipeId:String

    //function ini digunakan agar RecipeModel sama dengan recipeId
    fun setSelectedRecipe(recipeId:String){
        this.recipeId = recipeId
    }

    //function ini menginisialisasi RecipeModel dan mengambil data pada RecipeData apakah datanya ada.
    fun getRecipe(): RecipeModel? {
        var recipe: RecipeModel? = null
        for (recipeEntity in RecipeData.generateRecipeData()) {
            if (recipeEntity.recipeId == recipeId) {
                recipe = recipeEntity
            }
        }
        return recipe
    }
}