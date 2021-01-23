package com.mazad.Diana.gui.splash

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.mazad.Diana.R
import com.mazad.Diana.base_class.BaseActivity
import com.mazad.Diana.data.UserResponse
import com.mazad.Diana.gui.login.LoginActivity
import com.mazad.Diana.gui.main_page.MainPage
import com.mazad.Diana.utels.StaticMethod.Companion.toggleFullScreen
import com.mazad.Diana.utels.utels.IntentUtiles
import kotlinx.android.synthetic.main.splash_screan.*
import java.util.*

class SplashScrean : BaseActivity<SplashPresenter>(), SplashView {
    var animFadein: Animation? = null
    lateinit var splashPresenter:SplashPresenter
    var userResponseResult: UserResponse? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screan)
        toggleFullScreen(this)
        splashPresenter= SplashPresenter()
        splashPresenter.attachView(this)
        animFadein = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.fade_in
        )
        setLocale("ar")
        delayShowText()
    }

    private fun delayShowText() {
        animFadein = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.fade_in
        )
        imgsplash.startAnimation(animFadein)
        val handler = Handler()

        handler.postDelayed({
            // do any thing her
            splashPresenter.activityFinishedSplashTimer(this,userResponseResult)

        }, 4000)

    }


    fun setLocale(lang: String?) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        this.resources.updateConfiguration(config, null)
    }

    override fun openHomeUserActivity() {
        IntentUtiles.openActivityInNewStack(this, MainPage::class.java)
        finish()

    }

    override fun openIntro() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()

    }
}
