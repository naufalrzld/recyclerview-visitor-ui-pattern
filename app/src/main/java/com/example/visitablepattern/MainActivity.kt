package com.example.visitablepattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.visitablepattern.base.BaseAdapter
import com.example.visitablepattern.data.CategoryData
import com.example.visitablepattern.data.ProductData
import com.example.visitablepattern.data.remote.RetrofitClient
import com.example.visitablepattern.data.response.MainResponse
import com.example.visitablepattern.data.response.Ovo
import com.example.visitablepattern.databinding.ActivityMainBinding
import com.example.visitablepattern.ui.adapter.VisitorElementFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val baseAdapter by lazy {
        BaseAdapter(VisitorElementFactory())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = baseAdapter
        }

        initView()
    }

    private fun initView() {
        val call = RetrofitClient.getClient().getMainMenu()
        call.enqueue(object : Callback<MainResponse> {
            override fun onResponse(call: Call<MainResponse>, response: Response<MainResponse>) {
                val data = response.body()?.data
                val ovo = data?.ovo ?: Ovo(0, 0)
                val categories = CategoryData(data?.paymentCategories ?: emptyList())
                val product = ProductData(data?.products ?: emptyList())
                baseAdapter.addItems(listOf(ovo, categories, product))
            }

            override fun onFailure(call: Call<MainResponse>, t: Throwable) {

            }

        })
    }
}