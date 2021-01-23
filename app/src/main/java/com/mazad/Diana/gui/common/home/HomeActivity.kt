package com.mazad.Diana.gui.common.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.mazad.Diana.R
import com.mazad.Diana.gui.direct_add_details.AddsDirectDetailsFragment
import com.mazad.Diana.gui.display_mazadat.DisplayMazadatFragment
import com.mazad.Diana.gui.hogozaty.HogozatyFragment
import com.mazad.Diana.gui.list_direct_adds.ListDirectAddsFragment
import com.mazad.Diana.gui.login.LoginActivity
import com.mazad.Diana.gui.my_adds.MyAddsFragment
import com.mazad.Diana.gui.my_booked.MyBookedFragment
import com.mazad.Diana.gui.my_store.MyStoreFragment
import com.mazad.Diana.gui.upload_ads.UploadAddsFragment
import com.mazad.Diana.gui.upload_mazad.UploadMazadFragment
import com.mazad.Diana.utels.AppConstant
import com.mazad.Diana.utels.AppConstant.*
import com.mazad.Diana.utels.FragmentHandler
import com.mazad.Diana.utels.FragmentHandler.selectedPosition
import com.mazad.Diana.utels.ToastUtel
import com.mazad.Diana.utels.prefs.PrefUtils
import com.mazad.Diana.utels.utels.IntentUtiles
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemSelectedListener {
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    var navDrawer: NavigationView? = null
    var uploadAds = UploadAddsFragment()
    val listdirectAddFragment = ListDirectAddsFragment()
    val addsDetailsFragment = AddsDirectDetailsFragment()
    val myBookFragment = MyBookedFragment()
    val myStoreFragment = MyStoreFragment()
    val uploadMazadFragment = UploadMazadFragment()
    val displayMazadatFragment = DisplayMazadatFragment()
    val myAddsFragment = MyAddsFragment()
    val hogozatyFragment = HogozatyFragment()

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navDrawer?.setNavigationItemSelectedListener(this)

        nav_icon.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                drawer_layout.openDrawer(GravityCompat.END)
            }
        })
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_drawer)
        navView.setNavigationItemSelectedListener(this)

        setupNavButton()
        val nav_Menu = navView!!.menu
        if (userResponse==null){
            nav_Menu.findItem(R.id.logout).isVisible = false
            nav_Menu.findItem(R.id.pesonProfile).isVisible = false
            nav_Menu.findItem(R.id.hgozaty).isVisible = false
            nav_Menu.findItem(R.id.myAdds).isVisible = false
            nav_Menu.findItem(R.id.login).isVisible = true


        }else{
            nav_Menu.findItem(R.id.logout).isVisible = true
            nav_Menu.findItem(R.id.pesonProfile).isVisible = true
            nav_Menu.findItem(R.id.hgozaty).isVisible = true
            nav_Menu.findItem(R.id.myAdds).isVisible = true
            nav_Menu.findItem(R.id.login).isVisible = false

        }
    }


    private fun setupNavButton() {
        displayHomeFragment()
        val bottomNavigationView =
            findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.getItemId()) {
                    R.id.upload -> {
                        displayUploadFragment()
                    }
                    R.id.home -> {
                        displayHomeFragment()
                    }
                    R.id.myStorage -> {
                        displayStoreFragment()
                    }
                }
                return true
            }

        })


    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.getItemId()) {
            R.id.pesonProfile -> {

            }
            R.id.app_info -> {
                // ToastUtel.errorToast(this, "cancelled")
            }
            R.id.nav_AboutUs -> {

            }
            R.id.contact_menu -> {

            }
            R.id.login -> {
                IntentUtiles.openActivity(this, LoginActivity::class.java)
                finishAffinity()
            }
            R.id.myAdds -> {
                if (userResponse != null) {
                    when (saleTypeId) {

                        1, 2, 3 -> {

                        }
                        4, 5, 6 -> {
                            display(MY_ADDS_FRAGMENT)

                        }
                    }
                } else {
                    ToastUtel.errorToast(this, "لا يمكن رؤية حجوزاتك  بدون تسجيل الدخول")
                }
            }
            R.id.hgozaty -> {
                if (userResponse != null) {
                    when (saleTypeId) {

                        1, 2, 3 -> {

                        }
                        4, 5, 6 -> {
                            display(HOGAZATY_FRAGMENT)

                        }
                    }
                } else {
                    ToastUtel.errorToast(this, "لا يمكن رؤية حجوزاتك  بدون تسجيل الدخول")
                }
            }
            R.id.logout -> {

                val builder =
                    AlertDialog.Builder(this@HomeActivity)
                builder.setMessage("تاكيد تسجيل الخروج")
                builder.setPositiveButton(
                    "تاكيد"
                ) { dialog, id ->
                    PrefUtils.saveObjectToSharedPreference(
                        this,
                        PrefUtils.PREF,
                        PrefUtils.User_data, null
                    )
                    AppConstant.userResponse = null
                    catList = null
                    mazadatList = null
                    directList = null
                    IntentUtiles.openActivity(this, LoginActivity::class.java)
                    finishAffinity()
                    dialog.dismiss()


                }
                builder.setNegativeButton(
                    "الغاء"
                ) { dialog, id ->


                }
                val alert = builder.create()
                alert.show()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.END)
        return true

    }

    fun display(position: Int) {
        when (position) {
            UPLOAD_ADDS -> {
                FragmentHandler.displayView(UPLOAD_ADDS, this, uploadAds, R.id.containerAppFragment)
            }
            LIST_DIRECT_ADD_FRAGMENT -> {
                FragmentHandler.displayView(
                    LIST_DIRECT_ADD_FRAGMENT, this, listdirectAddFragment, R.id.containerAppFragment
                )

            }
            ADDS_DETAILS_PAGE -> {
                FragmentHandler.displayView(
                    ADDS_DETAILS_PAGE, this, addsDetailsFragment, R.id.containerAppFragment
                )

            }
            MY_BOOK_FRAGMENT -> {
                FragmentHandler.displayView(
                    MY_BOOK_FRAGMENT, this, myBookFragment, R.id.containerAppFragment
                )
            }
            MY_STORE_FRAGMENT -> {
                FragmentHandler.displayView(
                    MY_STORE_FRAGMENT, this, myStoreFragment, R.id.containerAppFragment
                )
            }
            UPLOAD_MAZAD_FRAGMENT -> {
                FragmentHandler.displayView(
                    UPLOAD_MAZAD_FRAGMENT, this, uploadMazadFragment, R.id.containerAppFragment
                )
            }
            DISPLAY_MAZAD_FRAGMENT -> {
                FragmentHandler.displayView(
                    DISPLAY_MAZAD_FRAGMENT, this, displayMazadatFragment, R.id.containerAppFragment
                )
            }
            MY_ADDS_FRAGMENT -> {
                FragmentHandler.displayView(
                    MY_ADDS_FRAGMENT, this, myAddsFragment, R.id.containerAppFragment
                )
            }
            HOGAZATY_FRAGMENT -> {
                FragmentHandler.displayView(
                    HOGAZATY_FRAGMENT, this, hogozatyFragment, R.id.containerAppFragment
                )
            }
        }


    }

    fun showHideBottonBar(visability: Int) {
        bottom_navigation.visibility = visability
    }

    fun displayHomeFragment() {
        when (saleTypeId) {
            1, 2, 3 -> {
                display(DISPLAY_MAZAD_FRAGMENT)


            }
            4, 5, 6 -> {
                display(LIST_DIRECT_ADD_FRAGMENT)

            }
        }
    }

    fun displayStoreFragment() {
        if (userResponse != null) {
            when (saleTypeId) {

                1, 2, 3 -> {

                }
                4, 5, 6 -> {
                    display(MY_STORE_FRAGMENT)

                }
            }
        }else{
            ToastUtel.errorToast(this, "لا يمكن رؤية خزانتك  بدون تسجيل الدخول")
        }

    }

    fun displayUploadFragment() {
        if (userResponse != null) {
            when (saleTypeId) {

                1, 2, 3 -> {
                    display(UPLOAD_MAZAD_FRAGMENT)

                }
                4, 5, 6 -> {
                    display(UPLOAD_ADDS)

                }
            }
        }else{
            ToastUtel.errorToast(this, "لا يمكن اضافه اعلان بدون تسجيل دخولك")
        }

    }

    override fun onBackPressed() {
        selectedPosition = FragmentHandler.getSelectPoistion()
       if(selectedPosition==DISPLAY_MAZAD_FRAGMENT|| selectedPosition==LIST_DIRECT_ADD_FRAGMENT){
           finish()
       }else{
           displayHomeFragment()
       }

    }



}
