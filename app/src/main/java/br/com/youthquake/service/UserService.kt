package br.com.youthquake.service

import br.com.youthquake.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("user/include")
    fun insertUser(@Body user: User): Call<User>

    @POST("login")
    fun loginUser(@Body user: User): Call<User>
}