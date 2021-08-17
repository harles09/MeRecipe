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
    //extra data digunakan untuk menampung data yang dikirim dari activity lain
    companion object {
        const val EXTRA_DATA = "extra_data"
    }
    // menginisiasi ActivityRecipe (karena menggunakan viewbinding)
    private lateinit var binding: ActivityRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //agar membuat back button pada bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //memanggil viewmodel
        val viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[RecipeViewModel::class.java]

        val extras = intent.extras
        //mengecek data extras apakah ada isinya atau tidak
        if(extras != null){
            val recipeId =extras.getString(EXTRA_DATA)
            //mengecek apakah recipeId ada atau tidak
            if(recipeId != null) {
                //mengirim recipeId ke viewmodel
                viewModel.setSelectedRecipe(recipeId)
                getRecipeData(viewModel.getRecipe() as RecipeModel)
            }
        }
    }
    //memanggil RecipeData pada model
    private fun getRecipeData(recipeModel:RecipeModel){
        //menggunakan library image untuk memasukkan gambar
        Glide.with(this)
            .load(recipeModel.recipeImage)
            .transform(RoundedCorners(20))
            .override(300,300)
            .into(binding.imagePoster)
        //jika button di klik akan memanggil aplikasi lain dan membuka link video
        binding.btVideo.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeModel.linkVideo))
            startActivity(intent)
        }
        //mengubah text menjadi RecipeData dengan inisialisasi pada RecipeModel
        binding.tvTitle.text = recipeModel.recipeTitle
        binding.tvBahan.text = recipeModel.bahan
        binding.tvLangkah.text = recipeModel.steps
    }
}