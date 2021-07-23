package com.example.submissiononejetpack.recipes

import androidx.lifecycle.ViewModel
import com.example.submissiononejetpack.model.RecipeData
import com.example.submissiononejetpack.model.RecipeModel

class RecipeViewModel:ViewModel() {
    private lateinit var recipeId:String

    fun setSelectedRecipe(recipeId:String){
        this.recipeId = recipeId
    }

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