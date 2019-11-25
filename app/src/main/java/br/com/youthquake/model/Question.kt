package br.com.youthquake.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Question{

    @SerializedName("idQuestion")
    @Expose
    val idQuestion: Int? = null

    @SerializedName("question")
    @Expose
    val question: String? = null

    @SerializedName("firstOption")
    @Expose
    val firstOption: String? = null

    @SerializedName("secondOption")
    @Expose
    val secondOption: String? = null

    @SerializedName("thirdOption")
    @Expose
    val thirdOption: String? = null

    @SerializedName("fourthOption")
    @Expose
    val fourthOption: String? = null

    @SerializedName("rightAnswer")
    @Expose
    val rightAnswer: String? = null
}
