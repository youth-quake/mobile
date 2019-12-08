package br.com.youthquake.config

import android.os.AsyncTask
import br.com.youthquake.model.Friends
import br.com.youthquake.model.User
import br.com.youthquake.service.FillFriendsService
import feign.Feign
import feign.jackson.JacksonDecoder

class FillFriends  : AsyncTask<Int, Void, List<Friends>>() {
    override fun doInBackground(vararg params: Int?): List<Friends>? {
        val request = Feign.builder()
            .decoder(JacksonDecoder())
            .target(
                FillFriendsService::class.java,
                "http://52.202.202.227:8081/"
            )

        try {
            return request.getFriends(params[0]!!)
        } catch (e:Exception) {
            e.printStackTrace()
        }
        return null
    }
}