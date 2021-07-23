package com.example.submissiononejetpack.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissiononejetpack.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[DashboardViewModel::class.java]
        val recipe = viewModel.getRecipe()

        val dashboardAdapter = DashboardAdapter()
        dashboardAdapter.setRecipe(recipe)

        with(binding.rvRecipe){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = dashboardAdapter
        }
    }
}