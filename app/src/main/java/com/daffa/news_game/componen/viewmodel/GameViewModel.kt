package com.daffa.news_game.componen.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daffa.news_game.network.api.ApiConfig
import com.daffa.news_game.network.response.GameResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GameViewModel : ViewModel() {

    private val listGame = MutableLiveData<List<GameResponseItem>>()

    fun getGameModel() {
        ApiConfig().getApiService().getGame().enqueue(object : Callback<List<GameResponseItem>> {
            override fun onResponse(
                call: Call<List<GameResponseItem>>,
                response: Response<List<GameResponseItem>>
            ) {
                listGame.value = response.body()
            }

            override fun onFailure(call: Call<List<GameResponseItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t", )
            }
        })
    }

    fun getListGame(): LiveData<List<GameResponseItem>> = listGame
}