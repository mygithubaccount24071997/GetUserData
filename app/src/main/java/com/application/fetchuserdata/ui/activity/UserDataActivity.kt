package com.application.fetchuserdata.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.application.fetchuserdata.R
import com.application.fetchuserdata.base.BaseActivity
import com.application.fetchuserdata.models.Result
import com.application.fetchuserdata.service.Status
import com.application.fetchuserdata.utils.UtilsDefault
import com.application.fetchuserdata.viewmodel.ApiViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_user_data.*

@AndroidEntryPoint
class UserDataActivity : BaseActivity() {

    val apiViewModel: ApiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)

        getUserData()
    }

    private fun getUserData( ) {

        apiViewModel.getuserData().observe(this, Observer {
            it?.let {
                when (it.status) {
                    Status.LOADING -> {
                    }
                    Status.SUCCESS -> {
                        if(it.data!!.results.size>0){
                            setUserData(it.data!!.results.get(0))
                        }
                    }
                    Status.ERROR -> {
                       toast(it.message!!)
                    }
                    Status.INTERNET -> {
                        toast(it.message!!)
                    }
                }
            }
        })
    }


    private fun setUserData(data: Result){
        Glide.with(this).load(data.picture.large).into(imgBackProfile)
        Glide.with(this).load(data.picture.medium).into(imgprofile)
        tvName.text="${data.name.title} .${data.name.first} ${data.name.first}"
        tvEmail.text=data.email
        tvDob.text=UtilsDefault.getDateTime(data.dob.date)
        tvage.text=data.dob.age.toString()
        tvPhoneNo.text=data.phone
        tvCellNo.text=data.cell
        tvcity.text=data.location.city
        tvstate.text=data.location.state
        tvCountry.text=data.location.country
        tvPostcode.text=data.location.postcode
        tvregisdate.text=UtilsDefault.getDateTime(data.registered.date)
        tvStreet.text="${data.location.street.number} ${data.location.street.name}"

    }
}