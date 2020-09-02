package id.itborneo.movieapp.data.remote



import id.itborneo.movieapp.data.model.MovieResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    companion object {
        val API_KEY = "b64d761def5c00e40e6a36e0032741bf"
    }

    @GET("3/movie/5/lists")
    fun getMovie(
        @Query("page") page: Int,
        @Query("total_result") totalResult: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("languange") languange: String = "en-US"
    ): Flowable<MovieResponse>


}