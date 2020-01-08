package com.augrocerrydelivery.utils

class AppConstatnts {

    companion object{

        const val BASE_URL = "https://adsandurlapp.com/driverapp/"
        const val PASSWORD_RESET_URL: String = "https://open-api.xyz/password_reset/"

        const val NETWORK_TIMEOUT = 6000L
        const val TESTING_NETWORK_DELAY = 0L // fake network delay for testing
        const val TESTING_CACHE_DELAY = 0L // fake cache delay for testing

        const val PAGINATION_PAGE_SIZE = 10

        const val GALLERY_REQUEST_CODE = 201
        const val PERMISSIONS_REQUEST_READ_STORAGE: Int = 301
        const val CROP_IMAGE_INTENT_CODE: Int = 401

        //prfs variable
        const val USER_DATA ="user_data"
        const val USER_PREFS ="user_prefs"

    }
}