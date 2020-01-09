package com.augrocerrydelivery.ui.state

import com.augrocerrydelivery.api.login.requets.LoginRequets

sealed class AuthStateEvent {

    data class LoginAttemptEvent(
        val loginRequets: LoginRequets
    ) : AuthStateEvent()

    class CheckPreviousAuthEvent() : AuthStateEvent()

    class None : AuthStateEvent()
}