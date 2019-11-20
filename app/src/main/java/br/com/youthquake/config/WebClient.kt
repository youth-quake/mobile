package br.com.youthquake.config

import br.com.youthquake.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

class WebClient {

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://52.202.202.227:8081/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

    fun includeUserService(): UserService{
        return retrofit.create(UserService::class.java)
    }

    fun authenticLoginUser(): UserService{
        return retrofit.create(UserService::class.java)
    }
}