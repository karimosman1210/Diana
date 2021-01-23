package com.mazad.Diana.gui.signup

import com.mazad.Diana.base_class.BaseView
import com.mazad.Diana.data.Countrys
import com.mazad.Diana.data.UserResponse

interface SignUpInterface :BaseView {
    fun sucessSignUp(data: UserResponse)
    fun listCountry(data: List<Countrys>)


}