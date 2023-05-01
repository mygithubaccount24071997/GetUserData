package com.application.fetchuserdata.base

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity: AppCompatActivity() {

    var mcontext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mcontext = this

    }


    fun toast(message:String){
        Toast.makeText(mcontext,message,Toast.LENGTH_SHORT).show()
    }


}