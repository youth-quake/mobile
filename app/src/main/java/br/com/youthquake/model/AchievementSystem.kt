package br.com.youthquake.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AchievementSystem {

    @SerializedName("idAchievement")
    @Expose
    var idAchievement: Int = 0
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

    @SerializedName("numberRequired")
    @Expose
    var numberRequired: Int = 0
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("description")
    @Expose
    var description: String? = null
        get() = field
        set(value) {
            field = value
        }
}