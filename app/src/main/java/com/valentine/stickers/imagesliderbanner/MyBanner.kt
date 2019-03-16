package com.valentine.stickers.imagesliderbanner

import com.google.gson.annotations.SerializedName

class MyBanner {

    @SerializedName("imageUrl")
    var imageUrl: String? = null

    @SerializedName("playStoreUrl")
    var playStoreUrl: String? = null

    @SerializedName("appName")
    var appName: String? = null
}
