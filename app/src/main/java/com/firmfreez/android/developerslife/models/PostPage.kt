package com.firmfreez.android.developerslife.models

import com.google.gson.annotations.SerializedName

data class PostPage(
	@SerializedName("result")
	val result: List<Post>? = null,

	@SerializedName("totalCount")
	val totalCount: Int? = null
)
