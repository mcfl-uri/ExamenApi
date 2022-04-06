package cat.api.examenapi.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Alumne(
    @Expose
    @SerializedName("id") val idAlumne: Int?,

    @Expose
    @SerializedName("nom") val nomAlumne: String?
)