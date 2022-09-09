package com.daffa.news_game.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResponse(

	@field:SerializedName("GameResponse")
	val gameResponse: List<GameResponseItem?>? = null
) : Parcelable

@Parcelize
data class GameResponseItem(

	@field:SerializedName("thumb")
	val thumb: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("tag")
	val tag: String? = null,

	@field:SerializedName("time")
	val time: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("desc")
	val desc: String? = null
) : Parcelable
