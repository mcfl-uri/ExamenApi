package cat.api.examenapi.api

import cat.api.examenapi.api.models.Cicle
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface ApiInterface {

    @GET("autores")
    fun getAllAuthors(): Call<List<Cicle>>

    @GET("cicles/{id}")
    fun getCicleById(
        @Path("id") number: Int
    ): Call<Cicle>

    @DELETE("/autores/{id}")
    fun deleteAuthor(
        @Path("id") id: Int
    ): Call<Cicle?>

    @Headers("Content-Type: application/json")
    @POST("autores")
    fun postAutor(@Body cicle: Cicle): Call<Cicle>

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