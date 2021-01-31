package com.firmfreez.android.developerslife.view.base

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.view.View
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.firmfreez.android.developerslife.R
import com.firmfreez.android.developerslife.di.App
import com.google.android.material.appbar.MaterialToolbar

abstract class BaseFragment: Fragment() {
    var toolbar: MaterialToolbar? = null

    init {
        App.instance.component?.inject(this)
    }

    protected fun setToolBar(title: String,
                             withBackButton: Boolean,
                             view: View,
                             @ColorRes color: Int = R.color.purple_500,
                             @ColorRes textColor: Int = R.color.black) {
        toolbar = view.findViewById(R.id.toolbar)
        toolbar?.background = ContextCompat.getDrawable(requireContext(), color)
        toolbar?.setTitleTextColor(ContextCompat.getColor(requireContext(), textColor))
        toolbar?.setSubtitleTextColor(ContextCompat.getColor(requireContext(), textColor))
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title = title
        if (withBackButton) {
            actionBar?.setDisplayHomeAsUpEnabled(true)
            actionBar?.setDisplayShowHomeEnabled(true)
            toolbar?.setNavigationOnClickListener { activity?.onBackPressed() }
            actionBar?.setHomeAsUpIndicator(ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_arrow_back))
        }
    }

    /**
     * Проверяет подключение к интернету. Для работы программы оно необходимо
     * @return Boolean
     */
    protected fun checkNetworkConnection(): Boolean {
        val manager = (requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val network =  manager?.activeNetwork
            val capabilities = manager?.getNetworkCapabilities(network)
            when {
                capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true -> return true
                capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true -> return true
                capabilities?.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) == true -> return true
                else -> {}
            }
        } else {
            manager?.activeNetworkInfo?.run {
                when(type) {
                    ConnectivityManager.TYPE_WIFI -> return true
                    ConnectivityManager.TYPE_MOBILE -> return true
                    ConnectivityManager.TYPE_ETHERNET -> return true
                    else -> {}
                }
            }
        }
        return false
    }
}