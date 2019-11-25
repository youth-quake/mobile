package br.com.youthquake.config

import android.os.AsyncTask
import br.com.youthquake.model.Question
import br.com.youthquake.service.RequestQuestions

import feign.Feign
import feign.jackson.JacksonDecoder

class FillQuestionsTask : AsyncTask<Int, Void, Question>() {
    override fun doInBackground(vararg params: Int?): Question? {
        val request = Feign.builder()
            .decoder(JacksonDecoder())
            .target(
                RequestQuestions::class.java,
                "http://demo5706957.mockable.io/"
            )

        try {
            return request.getQuestions(params[0]!!)
        } catch (e:Exception) {
            return null
        }
    }
}