package com.exemple.capstone.activity.ui.retrofit

import com.google.gson.annotations.SerializedName

data class RestaurantResponse(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class DataItem(

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("maps_url")
	val mapsUrl: String,

	@field:SerializedName("photo_url")
	val photoUrl: String
)
