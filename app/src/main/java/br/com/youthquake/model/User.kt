package br.com.youthquake.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("idUser")
    @Expose
    var idUser:Long? = 0
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("name")
    @Expose
    var name: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("login")
    @Expose
    var login: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("password")
    @Expose
    var password: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("email")
    @Expose
    var email: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("status_message")
    @Expose
    var messageStatus: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("path_picture")
    @Expose
    var picture: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("level")
    @Expose
    var level: Int? = 0
        get() = field
        set(value) {
            field = value
        }
}