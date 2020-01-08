package com.augrocerrydelivery.ui.state

sealed class AuthStateEvent {

    data class LoginAttemptEvent(
        val email: String,
        val mobilNo: String,
        val password: String

    ) : AuthStateEvent()

    class CheckPreviousAuthEvent() : AuthStateEvent()

    class None : AuthStateEvent()
}