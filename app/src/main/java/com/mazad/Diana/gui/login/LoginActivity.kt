package com.mazad.Diana.gui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import butterknife.ButterKnife
import com.mazad.Diana.R
import com.mazad.Diana.base_class.BaseActivity
import com.mazad.Diana.data.UserResponse
import com.mazad.Diana.gui.main_page.MainPage
import com.mazad.Diana.gui.signup.SignUpActivity
import com.mazad.Diana.gui.signup.User_Profile_image
import com.mazad.Diana.utels.AppConstant
import com.mazad.Diana.utels.AppConstant.userResponse
import com.mazad.Diana.utels.ToastUtel
import com.mazad.Diana.utels.prefs.PrefUtils
import com.mazad.Diana.utels.prefs.PrefUtils.PREF
import com.mazad.Diana.utels.prefs.PrefUtils.User_data
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginPresenter>(), LoginInterface {
    lateinit var  coordinatoLogin : CoordinatorLayout
    lateinit var loginPresenter: Login_Prsenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ButterKnife.bind(this)
        coordinatoLogin=findViewById(R.id.coordinatoLogin)

        loginPresenter = Login_Prsenter()
        loginPresenter.attachView(this)
        listenerView()
//        val user = FirebaseAuth.getInstance().getCurrentUser()
//        if (user != null) {
//            startActivity(Intent(this@LoginActivity,CategoryActivity::class.java))
//            finish()
//        }
    }


    private fun listenerView() {
        newAccTv.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            }

        })
        rBtnLogin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                loginPresenter.loginData(
                    emailLogin.text.toString().trim(),
                    passLogin.text.toString().trim(),
                    this@LoginActivity, coordinatoLogin
                )
            }
        })
        visitTv.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                startActivity((Intent(this@LoginActivity, MainPage::class.java)))

            }
        })
    }


    override fun sucessLogin(data: UserResponse) {
        userResponse = data
        PrefUtils.saveObjectToSharedPreference(this, PREF, User_data, data)
        ToastUtel.showSuccessToast(this, "تم تسجيل الدخول بنجاح")
        startActivity(Intent(this, MainPage::class.java))
        finish()    }


}
