package br.com.youthquake.service
import br.com.youthquake.model.User
import feign.Headers
import feign.RequestLine

interface UserService {

    @RequestLine("POST user/include")
    @Headers("Content-Type: application/json")
    fun insertUser(user: User): User?

    @RequestLine("POST login")
    @Headers("Content-Type: application/json")
    fun loginUser(user: User): User?

    @RequestLine("POST user/update")
    @Headers("Content-Type: application/json")
    fun updateUser(user: User): User?
}