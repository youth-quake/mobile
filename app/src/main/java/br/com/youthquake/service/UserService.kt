package br.com.youthquake.service

import br.com.youthquake.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("http://192.168.0.104:8080/user/include")
    fun insertUser(@Body user: User): Call<User>
}