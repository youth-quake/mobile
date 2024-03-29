package br.com.youthquake.config

import android.os.AsyncTask
import br.com.youthquake.model.Question
import br.com.youthquake.service.FillQuestionsService

import feign.Feign
import feign.jackson.JacksonDecoder

class FillQuestions : AsyncTask<Int, Void, Question>() {
    override fun doInBackground(vararg params: Int?): Question? {
        val request = Feign.builder()
            .decoder(JacksonDecoder())
            .target(
                FillQuestionsService::class.java,
                "http://52.202.202.227:8081/"
            )

        try {
            return request.getQuestions(params[0]!!)
        } catch (e:Exception) {
            return null
        }
    }
}