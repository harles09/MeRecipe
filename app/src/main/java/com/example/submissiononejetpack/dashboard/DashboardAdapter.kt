package com.example.submissiononejetpack.dashboard

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissiononejetpack.databinding.RecipeListBinding
import com.example.submissiononejetpack.model.RecipeModel
import com.example.submissiononejetpack.recipes.RecipeActivity

class DashboardAdapter:RecyclerView.Adapter<DashboardAdapter.ListViewHolder>() {
    //variable listRecipe tipe data ArrayList dengan inisial RecipeModel
    private var listRecipe = ArrayList<RecipeModel>()

    //fungsi yang diguanakan untuk mengetahui apakah recipenya sudah ada isinya atau belum
    fun setRecipe(recipes:List<RecipeModel>?){
        if(recipes == null) return
        this.listRecipe.clear()
        this.listRecipe.addAll(recipes)
    }

    //fungsi recyclerview
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        //menginisialisasi layout recipe list
        val recipeBinding = RecipeListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(recipeBinding)
    }

    //fungsi recyclerview
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        //menginisialisasi data dan posisi dari data tersebut
        val recipes = listRecipe[position]
        holder.bind(recipes)
    }

    //fungsi recyclerview
    //menghitung data yang ada pada listRecipe
    override fun getItemCount(): Int = listRecipe.size

    //mengikat data agar sesuai dengan RecipeModel
    class ListViewHolder(private val binding: RecipeListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(recipe: RecipeModel){
            with(binding){
                //mengubah text menjadi data
                binding.tvItemTitle.text = recipe.recipeTitle
                binding.tvItemSubtitle.text = recipe.jumlahBahan
                //menggunakan library image untuk memasukkan gambar
                Glide.with(itemView.context)
                    .load(recipe.recipeImage)
                    .override(300,300)
                    .into(ivItemImage)
                //ketika salah satu data ke klik maka buka activity baru dan kirim EXTRA_Data bersamaan
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, RecipeActivity::class.java)
                    intent.putExtra(RecipeActivity.EXTRA_DATA, recipe.recipeId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }


}