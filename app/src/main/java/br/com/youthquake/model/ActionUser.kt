package br.com.youthquake.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ActionUser {

    @SerializedName("idActionUser")
    @Expose
    var idActionUser: Int = 0

    @SerializedName("idActionSystem")
    @Expose
    var idActionSystem: ActionSystem? = null

    @SerializedName("quantity")
    @Expose
    var quantity: Int = 0

    @SerializedName("progress")
    @Expose
    var progress: Int = 0

}