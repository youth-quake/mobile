package br.com.youthquake.service

import br.com.youthquake.model.Friends
import feign.Param
import feign.RequestLine

interface FillFriendsService {
    @RequestLine("GET friend/{idUser}")
    fun getFriends(@Param("idUser") idUser: Int): List<Friends>?
}