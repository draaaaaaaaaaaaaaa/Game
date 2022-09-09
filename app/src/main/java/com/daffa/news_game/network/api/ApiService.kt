package com.daffa.news_game.network.api

import com.daffa.news_game.network.response.GameResponseItem
import retrofit2.Call

import retrofit2.http.GET


interface ApiService {

    @GET("api/games/news")
    fun getGame(): Call<List<GameResponseItem>>

}