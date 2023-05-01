package com.application.fetchuserdata.service

import com.application.fetchuserdata.models.UserData
import retrofit2.http.GET

interface ApiInterface {

    @GET(ApiUrl.api)
    suspend fun userInfo(): UserData

}