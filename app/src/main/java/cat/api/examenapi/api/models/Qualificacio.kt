package cat.api.examenapi.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Qualificacio(
    @Expose
    @SerializedName("id") val idQuali: Int?,

    @Expose
    @SerializedName("modul") val idQualiModul: Int?,

    @Expose
    @SerializedName("alumne") val idAlumneQuali: Int?,

    @Expose
    @SerializedName("nota") val notaQuali: String?
)