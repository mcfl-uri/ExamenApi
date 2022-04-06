package cat.api.examenapi.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Modul(

    @Expose
    @SerializedName("id") val idModul: Int?,

    @Expose
    @SerializedName("cicleId") val idCicleModul: String?,

    @Expose
    @SerializedName("nom") val nomModul: String?
)