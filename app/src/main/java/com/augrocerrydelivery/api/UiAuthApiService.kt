package com.augrocerrydelivery.api

import androidx.lifecycle.LiveData
import com.augrocerrydelivery.api.login.requets.LoginRequets
import com.augrocerrydelivery.api.login.response.LoginResponse
import com.augrocerrydelivery.utils.GenericApiResponse
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UiAuthApiService {

    @POST("driver-login.php")
    fun login(@Body loginRequets: LoginRequets) : LiveData<GenericApiResponse<LoginResponse>>

}