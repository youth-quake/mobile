package br.com.youthquake.config

import android.os.AsyncTask
import br.com.youthquake.model.User
import br.com.youthquake.service.UserService
import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder

class UserUpdate: AsyncTask<User, Void, User?>() {
    override fun doInBackground(vararg params: User): User? {
        val request = Feign.builder()
            .encoder(JacksonEncoder())
            .decoder(JacksonDecoder())
            .target(
                UserService::class.java,
                "http://52.202.202.227:8081/"
            )
        return try {
            request.updateUser(params[0]!!)
        } catch (e:Exception) {
            null
        }
    }
}