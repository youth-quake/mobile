package br.com.youthquake.config

import br.com.youthquake.data.User
import br.com.youthquake.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigRetrofit {

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("http://192.168.0.104:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun userInclude():UserService{
        return retrofit.create(UserService::class.java)
    }
}