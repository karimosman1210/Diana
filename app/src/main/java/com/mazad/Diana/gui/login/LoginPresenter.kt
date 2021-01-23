package com.mazad.Diana.gui.login

import android.content.Context
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.mazad.Diana.R
import com.mazad.Diana.base_class.BasePresenter
import com.mazad.Diana.data.UserResponse
import com.mazad.Diana.data.network.*
import com.mazad.Diana.utels.utels.StaticMethods
import com.mazad.Diana.utels.utels.Validator
import org.json.JSONException
import java.util.*

class LoginPresenter : BasePresenter<LoginInterface>() {

    fun checkLogin(
        phone: String,
        password: String,
        context: Context,
        coordinatorLayout: CoordinatorLayout
    ) {
        val internetAvailable: Boolean = StaticMethods.isConnectingToInternet(context)
        if (!internetAvailable) {
            view.showNoNetworkConnectionBase(coordinatorLayout, context)
            return
        } else if (Validator.isTextEmpty(phone)) {
            view.showErrorMessageBase(
                coordinatorLayout,
                context,
                context.getString(R.string.emptyphone)
            )
            return
        } else if (Validator.isTextEmpty(password)) {
            view.showErrorMessageBase(
                coordinatorLayout,
                context,
                context.getString(R.string.emptyPassword)
            )
            return
        } else if (!Validator.validPasswordLength(password)) {
            view.showErrorMessageBase(
                coordinatorLayout,
                context,
                context.getString(R.string.invaildPasswordLenght)
            )
            return
        }
//        else if (!Validator.validMobileNumber(phone)) {
//           view.showErrorMessageBase(
//               coordinatorLayout,
//               context,
//               context.getString(R.string.invaildphone)
//           )
//            return
//        }
        goCategory(phone,password, context, coordinatorLayout)
    }

    private fun goCategory(
        phone: String,
        password: String,
        context: Context,
        coordinatorLayout: CoordinatorLayout
    ) {


        view.showloadingviewBase(context)
        MainApi.Loginapi(phone,password, object : ConnectionListener<MainResponse<UserResponse?>?> {
            override fun onSuccess(connectionResponse: ConnectionResponse<MainResponse<UserResponse?>?>) {
                view.hideloadingviewBase()
                if (connectionResponse.data!!.success) {
                    if (connectionResponse.data!!.data != null) {
                        view.showSuccessMessageBase(
                            coordinatorLayout,
                            context,
                            connectionResponse.data!!.message
                        )

                        view.sucessLogin(connectionResponse.data?.data!!)
                    } else view.showErrorMessageBase(
                        coordinatorLayout,
                        context,
                        connectionResponse.data!!.message
                    )
                } else {
                    view.showErrorMessageBase(
                        coordinatorLayout,
                        context,
                        connectionResponse.data!!.message
                    )
                }
            }

            override fun onFail(throwable: Throwable) {
                view.hideloadingviewBase()
                StaticMethods.printJson("saddasd", throwable.message)
                view.showErrorMessageBase(
                    coordinatorLayout,
                    context,
                    context.getString(R.string.tryagaing)
                )
            }
        })
    }
    }

