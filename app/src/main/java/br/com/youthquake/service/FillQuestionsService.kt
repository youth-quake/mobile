package br.com.youthquake.service

import br.com.youthquake.model.Question
import feign.Param
import feign.RequestLine

interface FillQuestionsService {

    @RequestLine("GET questions/{idQuestion}")
    fun getQuestions(@Param("idQuestion") id: Int): Question?
}