package com.application.fetchuserdata.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

 open class BaseFragment(layoutId:Int) : Fragment(layoutId) {

    var mcontext: Context? = null
    lateinit var fragment_activity :FragmentActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {

            mcontext = context

            fragment_activity= requireActivity()

        } catch (e: Exception) {

        }

    }




}
