package br.com.youthquake.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("idUser")
    @Expose
    var idUser:Long? = 0

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("login")
    @Expose
    var login: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("status_message")
    @Expose
    var messageStatus: String? = null

    @SerializedName("path_picture")
    @Expose
    var picture: String? = null

    @SerializedName("level")
    @Expose
    var level: Int? = 0

}