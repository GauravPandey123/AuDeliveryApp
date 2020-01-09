package com.augrocerrydelivery.ui.respository.auth

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import com.augrocerrydelivery.api.UiAuthApiService
import com.augrocerrydelivery.api.login.requets.LoginRequets
import com.augrocerrydelivery.api.login.response.LoginResponse
import com.augrocerrydelivery.session.SessionManager
import com.augrocerrydelivery.utils.*
import com.codingwithmitch.openapi.repository.JobManager
import com.codingwithmitch.openapi.ui.auth.state.AuthViewState

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

        ) {

            override suspend fun updateLocalDb(cacheObject: Any?) {
            }

            // not used in this case
            override suspend fun createCacheRequestAndReturn() {

            }

            override suspend fun handleApiSuccessResponse(response: ApiSuccessResponse<LoginResponse>) {

            }

            override fun createCall(): LiveData<GenericApiResponse<LoginResponse>> {
                return uiAuthApiService.login(loginRequets)
            }

            override fun setJob(job: Job) {
                addJob("attemptLogin", job)

            }

            override fun loadFromCache(): LiveData<AuthViewState> {
                return AbsentLiveData.create()
            }
        }.asLiveData()


    }


//    private fun saveAuthenticateUserToPrefs(loginRequets : LoginRequets) {
//        sharedPrefsEditor.putString(PreferenceKeys.PREVIOUS_AUTH_USER, loginRequets)
//        sharedPrefsEditor.apply()
//    }


}







