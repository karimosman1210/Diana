package com.mazad.Diana.gui.login

import com.mazad.Diana.base_class.BaseView
import com.mazad.Diana.data.UserResponse

interface LoginInterface :BaseView{
    fun sucessLogin(data: UserResponse)


}