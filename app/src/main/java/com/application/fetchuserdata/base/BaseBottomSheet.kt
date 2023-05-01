package com.application.fetchuserdata.base


import android.content.Context
import android.os.Bundle

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class BaseBottomSheet : BottomSheetDialogFragment() {
    var mcontext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            mcontext = context
        } catch (e: Exception) {
        }

    }


}