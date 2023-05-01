package com.application.fetchuserdata.repositry

import com.application.fetchuserdata.models.UserData
import com.application.fetchuserdata.service.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ApiRepositry @Inject constructor(val apiservice: ApiInterface){

    fun userData(): Flow<UserData>{
        return flow {
            val response = apiservice.userInfo()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

}