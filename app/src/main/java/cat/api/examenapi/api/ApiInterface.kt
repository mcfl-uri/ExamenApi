package cat.api.examenapi.api

import cat.api.examenapi.api.models.Alumne
import cat.api.examenapi.api.models.Cicle
import cat.api.examenapi.api.models.Qualificacio
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface ApiInterface {

    @GET("qualificacions?&modul=1")
    fun getAprovatsModul(
        @Query("nota") notes: List<Int?>?
    ): Call<List<Qualificacio>>

    @GET("cicles/{id}")
    fun getCicleById(
        @Path("id") number: Int
    ): Call<Cicle>

    @DELETE("alumnes/{id}")
    fun deleteAlumne(
        @Path("id") id: Int
    ): Call<Alumne?>

    @FormUrlEncoded
    @PUT("alumnes/{id}")
    fun updateAlumne(
        @Path("id") id: Int?, @Field("nom") nom: String
    ): Call<ResponseBody?>?

    companion object {

        var BASE_URL = "http://10.0.2.2:8888/"

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}