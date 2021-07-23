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

    private var listRecipe = ArrayList<RecipeModel>()

    fun setRecipe(recipes:List<RecipeModel>?){
        if(recipes == null) return
        this.listRecipe.clear()
        this.listRecipe.addAll(recipes)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val recipeBinding = RecipeListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(recipeBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val recipes = listRecipe[position]
        holder.bind(recipes)
    }

    override fun getItemCount(): Int = listRecipe.size

    class ListViewHolder(private val binding: RecipeListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(recipe: RecipeModel){
            with(binding){
                binding.tvItemTitle.text = recipe.recipeTitle
                binding.tvItemSubtitle.text = recipe.jumlahBahan
                Glide.with(itemView.context)
                    .load(recipe.recipeImage)
                    .into(ivItemImage)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, RecipeActivity::class.java)
                    intent.putExtra(RecipeActivity.EXTRA_DATA, recipe.recipeId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }


}