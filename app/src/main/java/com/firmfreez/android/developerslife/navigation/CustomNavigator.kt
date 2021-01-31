package com.firmfreez.android.developerslife.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.github.terrakok.cicerone.androidx.TransactionInfo

class CustomNavigator(activity: AppCompatActivity, containerId: Int = -1): AppNavigator(activity, containerId) {
    override fun commitNewFragmentScreen(
        screen: FragmentScreen,
        type: TransactionInfo.Type,
        addToBackStack: Boolean
    ) {
        val fragment = screen.createFragment(fragmentFactory)
        if (fragment is DialogFragment) {
            fragment.show(activity.supportFragmentManager, "dialog_fragment")
        } else super.commitNewFragmentScreen(screen, type, addToBackStack)
    }
}