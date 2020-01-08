package com.augrocerrydelivery.ui.state

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AuthViewState(
    var loginFields: LoginFields? = LoginFields()

    ) : Parcelable


@Parcelize
data class LoginFields(
    var driverId: String? = null,
    var mobileno: String? = null,
    val password: String? = null
) : Parcelable {
    class LoginError {

        companion object {

            fun mustFillAllFields(): String {
                return "You can't login without an driverId and Phone."
            }

            fun none(): String {
                return "None"
            }

        }
    }

    fun isValidForLogin(): String {

        if (driverId.isNullOrEmpty() || mobileno.isNullOrEmpty()
            || password.isNullOrEmpty()
        ) {

            return LoginError.mustFillAllFields()
        }
        return LoginError.none()
    }


    override fun toString(): String {
        return "LoginState(driverId=$driverId,mobilenp=$mobileno,password=$password)"
    }

}