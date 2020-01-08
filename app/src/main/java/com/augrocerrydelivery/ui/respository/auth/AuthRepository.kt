package com.augrocerrydelivery.ui.respository.auth

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import com.augrocerrydelivery.api.UiAuthApiService
import com.augrocerrydelivery.api.login.requets.LoginRequets
import com.augrocerrydelivery.api.login.response.LoginResponse
import com.augrocerrydelivery.session.SessionManager
import com.augrocerrydelivery.ui.state.AuthViewState
import com.augrocerrydelivery.utils.ApiSuccessResponse
import com.augrocerrydelivery.utils.DataState
import com.augrocerrydelivery.utils.GenericApiResponse
import com.augrocerrydelivery.utils.NetworkBoundResource
import com.codingwithmitch.openapi.repository.JobManager

import kotlinx.coroutines.Job
import javax.inject.Inject

class AuthRepository
@Inject
constructor(
    val uiAuthApiService: UiAuthApiService,
    val sessionManager: SessionManager,
    val sharedPreferences: SharedPreferences,
    val sharedPrefsEditor: SharedPreferences.Editor
) : JobManager("AuthRepository") {

    private val TAG: String = "AppDebug"

    fun loginDriver(loginRequets: LoginRequets): LiveData<DataState<AuthViewState>> {

        return object : NetworkBoundResource<LoginResponse, Any, AuthViewState>(
            sessionManager.isConnectedToTheInternet(),
            true,
            true,
            false

        ){
            override fun loadFromCache(): LiveData<AuthViewState> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override suspend fun updateLocalDb(cacheObject: Any?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            // not used in this case
            override suspend fun createCacheRequestAndReturn() {

            }

            override suspend fun handleApiSuccessResponse(response: ApiSuccessResponse<LoginResponse>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun createCall(): LiveData<GenericApiResponse<LoginResponse>> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun setJob(job: Job) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }.asLiveData()





    }


    private fun saveAuthenticateUserToPrefs(){

    }




}







