package br.com.youthquake.service

import br.com.youthquake.model.Question
import feign.Param
import feign.RequestLine

interface FillQuestionsService {

    @RequestLine("GET /questions/{id}")
    fun getQuestions(@Param("id") id: Int): Question?
}