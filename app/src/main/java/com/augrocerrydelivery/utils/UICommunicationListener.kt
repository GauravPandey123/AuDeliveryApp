package com.augrocerrydelivery.utils

import com.codingwithmitch.openapi.ui.UIMessage

interface UICommunicationListener {

    fun onUIMessageReceived(uiMessage: UIMessage)
}