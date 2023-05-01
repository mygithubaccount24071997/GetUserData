package com.application.fetchuserdata.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import com.application.fetchuserdata.models.UserData
import com.application.fetchuserdata.repositry.ApiRepositry
import com.application.fetchuserdata.service.Resource
import com.application.fetchuserdata.utils.UtilsDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart


import javax.inject.Inject

@HiltViewModel
class ApiViewModel @Inject constructor(
    application: Application,
    private val repository: ApiRepositry
) : AndroidViewModel(application) {

    fun getuserData() = liveData<Resource<UserData>> {
        if (UtilsDefault.isOnline()) {
            repository.userData()
                .onStart {
                    emit(Resource.loading(data = null))
                }.catch {
                    emit(Resource.error(data = null, msg = "Cannot reach server..try again"))
                }.collect {
                    emit(Resource.success(it))
                }
        } else {
            emit(Resource.internet(data = null, msg = "No internet connection"))
        }

    }


}
