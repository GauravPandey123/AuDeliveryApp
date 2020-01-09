package com.codingwithmitch.openapi.ui.auth

import androidx.lifecycle.*
import com.augrocerrydelivery.ui.respository.auth.AuthRepository
import com.augrocerrydelivery.ui.state.AuthStateEvent

import com.augrocerrydelivery.utils.DataState
import com.augrocerrydelivery.utils.Loading
import com.codingwithmitch.openapi.ui.BaseViewModel
import com.codingwithmitch.openapi.ui.auth.state.AuthViewState
import com.codingwithmitch.openapi.ui.auth.state.LoginFields

import javax.inject.Inject

class AuthViewModel
@Inject
constructor(
    val authRepository: AuthRepository
) : BaseViewModel<AuthStateEvent, AuthViewState>() {
    override fun handleStateEvent(stateEvent: AuthStateEvent): LiveData<DataState<AuthViewState>>? {
         when (stateEvent) {

            is AuthStateEvent.LoginAttemptEvent -> {
                return authRepository.loginDriver(
                    stateEvent.loginRequets
                )
            }


//
//            is AuthStateEvent.None ->{
//                return liveData {
//                    emit(
//                        DataState(
//                            null,
//                            Loading(false),
//                            null
//                        )
//                    )
//                }
//            }
            else ->
                return null

        }
    }

    override fun initNewViewState(): AuthViewState {
        return AuthViewState()
    }

    fun setLoginFields(loginFields: LoginFields) {
        val update = getCurrentViewStateOrNew()
        if (update.loginFields == loginFields) {
            return
        }
        update.loginFields = loginFields
        setViewState(update)
    }

//    fun setAuthToken(authToken: AuthToken){
//        val update = getCurrentViewStateOrNew()
//        if(update.authToken == authToken){
//            return
//        }
//        update.authToken = authToken
//        setViewState(update)
//    }

    fun cancelActiveJobs() {
        handlePendingData()
        authRepository.cancelActiveJobs()
    }

    fun handlePendingData() {
        setStateEvent(AuthStateEvent.None())
    }

    override fun onCleared() {
        super.onCleared()
        cancelActiveJobs()
    }
}
































