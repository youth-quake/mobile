package br.com.youthquake.service

import br.com.youthquake.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("user/include")
    fun insertUser(@Body user: User): Call<User>
}