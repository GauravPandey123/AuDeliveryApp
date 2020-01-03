package com.augrocerrydelivery.ui.activity

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.augrocerrydelivery.utils.DataStateChangeListener
import com.augrocerrydelivery.utils.UICommunicationListener
import com.codingwithmitch.openapi.ui.*

abstract class BaseActivity : AppCompatActivity(), DataStateChangeListener,
    UICommunicationListener {
    override fun expandAppBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideSoftKeyboard() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isStoragePermissionGranted(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUIMessageReceived(uiMessage: UIMessage) {
        when(uiMessage.uiMessageType){

            is UIMessageType.AreYouSureDialog -> {
                areYouSureDialog(
                    uiMessage.message,
                    uiMessage.uiMessageType.callback
                )
            }

            is UIMessageType.Toast -> {
                displayToast(uiMessage.message)
            }

            is UIMessageType.Dialog -> {
                displayInfoDialog(uiMessage.message)
            }

            is UIMessageType.None -> {
              //  Log.i(TAG, "onUIMessageReceived: ${uiMessage.message}")
            }
        }    }
}