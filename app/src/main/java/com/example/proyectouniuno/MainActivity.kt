package com.example.proyectouniuno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectouniuno.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var data = ArrayList<Products>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        getAllProducts()

    }

    private fun getAllProducts() {
        val retrofit = ServiceBuilder.buildService(ServiceInterface::class.java)

        retrofit.getAllProducts().enqueue(object : retrofit2.Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                try {

                    val responseBody = response.body()!!
                    data = responseBody.products

                    var adapter = ProductAdapter(data)
                    binding.recyclerview.adapter = adapter



                }
                catch (ex: java.lang.Exception){

                    ex.printStackTrace()

                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("Failed","Api Error"+ t.message)
            }

        })
    }
}