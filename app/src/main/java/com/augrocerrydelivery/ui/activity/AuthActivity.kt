package com.augrocerrydelivery.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.navigation.findNavController
import com.augrocerrydelivery.R
import com.augrocerrydelivery.utils.DataState

class AuthActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)
        findNavController(R.id.auth_nav_host_fragment)

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDataStateChange(dataState: DataState<*>?) {
    }


}