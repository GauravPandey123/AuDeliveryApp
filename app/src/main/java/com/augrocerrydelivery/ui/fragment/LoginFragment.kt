package com.augrocerrydelivery.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController
import com.augrocerrydelivery.R
import com.augrocerrydelivery.api.login.requets.LoginRequets
import com.codingwithmitch.openapi.ui.auth.AuthViewModel
import kotlinx.android.synthetic.main.login_fragment.*
import javax.inject.Inject

class LoginFragment : Fragment(), NavController.OnDestinationChangedListener {

    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    lateinit var loginViewModel  : AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel= ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)
        setUpElements()
      //  setUpObservers()
    }

    private fun setUpObservers(phoneNo : String,image : String, driverId : String,password:String,lattiude:String,logitude : String,fcmToken : String,language:String) {
        val requestBody= LoginRequets(phoneNo,image,driverId,password,lattiude,logitude,fcmToken,language)

        loginViewModel.authRepository.loginDriver(requestBody).observe(viewLifecycleOwner, Observer {

        })
    }


    private fun setUpElements() {
        textViewForgotPassword.setOnClickListener {
            navForgotPassowrd()
        }
    }

    private fun navForgotPassowrd() {
        findNavController().navigate(R.id.action_launcherFragment_to_forgotPasswordFragment)

    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}