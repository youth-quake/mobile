package br.com.youthquake.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Target {

    @SerializedName("idTarget")
    @Expose
    var idTarget: Long = 0
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

    @SerializedName("description")
    @Expose
    var description: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("dtStart")
    @Expose
    var dtStart: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("dtEnd")
    @Expose
    var dtEnd: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("value")
    @Expose
    var value: Double = 0.toDouble()
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("valueAccumulated")
    @Expose
    var valueAccumulated: Double? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("percentage")
    @Expose
    var percentage: Double? = null
        get() = field
        set(value) {
            field = value
        }
}