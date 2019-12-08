package br.com.youthquake.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Friends {
    @SerializedName("idFriends")
    @Expose
    var idFriends: Long? = 0
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("user1")
    @Expose
    var user1: User? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("user2")
    @Expose
    var user2: User? = null
        get() = field
        set(value) {
            field = value
        }
}