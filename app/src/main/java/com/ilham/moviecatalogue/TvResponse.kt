package com.ilham.moviecatalogue

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvResponse (
    @SerializedName("results")
    val tvshow : List<TvShow>
) : Parcelable {
    constructor() : this(mutableListOf())
}
