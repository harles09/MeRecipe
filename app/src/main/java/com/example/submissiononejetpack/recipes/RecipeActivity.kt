package com.example.submissiononejetpack.recipes

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.submissiononejetpack.databinding.ActivityRecipeBinding
import com.example.submissiononejetpack.model.RecipeModel

class RecipeActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
    private lateinit var binding: ActivityRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[RecipeViewModel::class.java]

        val extras = intent.extras
        if(extras != null){
            val recipeId =extras.getString(EXTRA_DATA)
            if(recipeId != null) {
                viewModel.setSelectedRecipe(recipeId)
                getRecipeData(viewModel.getRecipe() as RecipeModel)
            }
        }
    }

    private fun getRecipeData(recipeModel:RecipeModel){
        Glide.with(this)
            .load(recipeModel.recipeImage)
            .transform(RoundedCorners(20))
            .into(binding.imagePoster)

        binding.btVideo.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeModel.linkVideo))
            startActivity(intent)
        }

        binding.tvTitle.text = recipeModel.recipeTitle
        binding.tvBahan.text = recipeModel.bahan
        binding.tvLangkah.text = recipeModel.steps
    }
}