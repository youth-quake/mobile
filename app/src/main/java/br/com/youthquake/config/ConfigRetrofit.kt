package br.com.youthquake.config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigRetrofit {

    fun init(){
        Retrofit.Builder()
            .baseUrl("http://192.168.0.1:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}