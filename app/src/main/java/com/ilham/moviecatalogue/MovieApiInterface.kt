package com.ilham.moviecatalogue

import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=1b65e3147cd3061807436b1f725ad390")
    fun getMovieList(): Call<MovieResponse>
}