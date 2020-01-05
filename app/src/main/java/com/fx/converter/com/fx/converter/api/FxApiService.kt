package com.fx.converter.com.fx.converter.api

import com.fx.converter.FxApiResponse
import com.fx.converter.accessUrl
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FxApiService {
    @Headers("Cache-Control: max-age=640000", "Accept: application/json")
    @GET(accessUrl)
    fun getFxDataOnline(@Query("access_key") accessKey:String): Call<FxApiResponse>
}