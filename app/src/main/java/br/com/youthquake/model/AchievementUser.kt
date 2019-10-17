package br.com.youthquake.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AchievementUser {

    @SerializedName("idAchievementUser")
    @Expose
    var idAchievementUser: Int = 0
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("idAchievement")
    @Expose
    var idAchievement: AchievementSystem? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("quantity")
    @Expose
    var quantity: Int = 0
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("progress")
    @Expose
    var progress: Int = 0
        get() = field
        set(value) {
            field = value
        }
}