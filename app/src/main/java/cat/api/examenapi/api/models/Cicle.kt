package cat.api.examenapi.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Cicle(
    @Expose
    @SerializedName("id") val idCicle: Int?,

    @Expose
    @SerializedName("nom") val nomCicle: String?,

    @Expose
    @SerializedName("nivell") val nivellCicle: String?
)