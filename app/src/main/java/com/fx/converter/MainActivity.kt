package com.fx.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.fx.converter.com.fx.converter.api.FxApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fxDataTest.setOnClickListener {
            Toast.makeText(it.context, "Fetching data from server", Toast.LENGTH_SHORT).show()
            getForeignExchangeRates()
            initView()

        }
    }

    fun initView(){
        //TODO:: setupp recycler view

    }
    fun getForeignExchangeRates() {
        var gson = GsonBuilder().setLenient().create()
        var retrofit =
            Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        val serviceImplementation = retrofit.create(FxApiService::class.java)
        val call = serviceImplementation.getFxDataOnline(access_key)
        call.enqueue(object : Callback<FxApiResponse> {
            override fun onFailure(call: Call<FxApiResponse>?, t: Throwable?) {
                Log.d(
                    "RETROFIT_TEST ${Thread.currentThread().name}",
                    "Service Call failed with the response ${t?.message}"
                )
                fxDataTest!!.text = t?.message
            }

            override fun onResponse(
                call: Call<FxApiResponse>?,
                response: Response<FxApiResponse>?
            ) {
                Log.d(
                    "RETROFIT_TEST ${Thread.currentThread().name}",
                    "Service Call failed with the response ${response?.body()}"
                )
                fxDataTest!!.text = response?.body()?.toString()
            }

        })
    }
}
