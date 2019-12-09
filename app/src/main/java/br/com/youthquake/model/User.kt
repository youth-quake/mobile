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

    @SerializedName("score")
    @Expose
    var score:Int? = 0
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("firstAccess")
    @Expose
    var firstAcess:Int? = 0
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

    @SerializedName("picture")
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

    @SerializedName("movements")
    @Expose
    var movements: List<Movements>? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("target")
    @Expose
    var target: List<Target>? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("achievementUsers")
    @Expose
    var achievementUsers: List<AchievementUser>? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("actionUsers")
    @Expose
    var actionUsers: List<ActionUser>? = null
        get() = field
        set(value) {
            field = value
        }


}