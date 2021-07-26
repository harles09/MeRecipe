package com.example.submissiononejetpack.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissiononejetpack.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    // menginisiasi ActivityDashboard (karena menggunakan viewbinding)
    private lateinit var binding:ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //memanggil viewmodel
        val viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[DashboardViewModel::class.java]
        //menginisialisasi recipe
        val recipe = viewModel.getRecipe()
        //memanggil DashboardAdapter dan mengubah setRecipe sesuai recipe viewmodel
        val dashboardAdapter = DashboardAdapter()
        dashboardAdapter.setRecipe(recipe)
        // mengubah recyclerview layout menjadi linear dan mengubah adapternya menjadi dashboardAdapter
        with(binding.rvRecipe){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = dashboardAdapter
        }
    }
}