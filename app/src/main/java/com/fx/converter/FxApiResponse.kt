package com.fx.converter

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class FxApiResponse(@SerializedName("date")
                         val date: String = "",
                         @SerializedName("success")
                         val success: Boolean = false,
                         @SerializedName("timestamp")
                         val timestamp: Int = 0,
                         @SerializedName("rates")
                         val rates:Map<String,String> = mapOf(),
                         @SerializedName("base")
                         val base: String = "")