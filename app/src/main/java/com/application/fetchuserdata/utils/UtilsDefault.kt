package com.application.fetchuserdata.utils

import android.content.*
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.application.fetchuserdata.app.BaseApplication
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object UtilsDefault {

    fun isOnline(): Boolean {
        val haveConnectedWifi = false
        val haveConnectedMobile = false
        val cm = BaseApplication.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val netInfo = cm.activeNetwork
        if (netInfo != null) {
            val nc = cm.getNetworkCapabilities(netInfo)

            return (nc!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(
                NetworkCapabilities.TRANSPORT_WIFI
            ))
        }

        return haveConnectedWifi || haveConnectedMobile
    }

    fun getDateTime(date: String): String {
        //println("get Date: $date")0
        val dateForm2 = SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa")
        val utc = TimeZone.getTimeZone("GMT")
        if (date.contains("/")) {
            val dateFormat = SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
            return dateForm2.format(dateFormat.parse(date))
        }else if(date.contains("(")){
            val inputFormat: DateFormat = SimpleDateFormat(
                "E MMM dd yyyy HH:mm:ss 'GMT'z", Locale.ENGLISH)
            val convert_date: Date = inputFormat.parse(date)
            return dateForm2.format(convert_date)

        } else if (date.contains("T")) {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") //2021-03-04T13:54:28.841Z
            dateFormat.timeZone = utc
            //dateFormat.timeZone = TimeZone.getTimeZone("UTC+5:30")
            return dateForm2.format(dateFormat.parse(date))
        } else {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return dateForm2.format(dateFormat.parse(date))
        }
    }

}