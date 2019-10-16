package br.com.youthquake.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movements {

    @SerializedName("idMovement")
    @Expose
    var idMovement: Long? = null
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

    @SerializedName("type")
    @Expose
    var type: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("reference")
    @Expose
    var reference: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("dateMovement")
    @Expose
    var dateMovement: String? = null
        get() = field
        set(value) {
            field = value
        }

    @SerializedName("descriptionMovement")
    @Expose
    var descriptionMovement: String? = null
        get() = field
        set(value) {
            field = value
        }
}