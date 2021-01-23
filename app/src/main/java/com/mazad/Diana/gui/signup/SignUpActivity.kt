package com.mazad.Diana.gui.signup

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mazad.Diana.R
import com.mazad.Diana.adapter.AddriessAdapter
import com.mazad.Diana.adapter.TitleDropAdapter
import com.mazad.Diana.base_class.BaseActivity
import com.mazad.Diana.data.Countrys
import com.mazad.Diana.data.UserResponse
import com.mazad.Diana.utels.MainAppConstant
import com.mazad.Diana.utels.StaticMethod
import com.mazad.Diana.utels.takeimage.TakeImageReceiveView
import com.mazad.Diana.utels.takeimage.TakeImageUtiles
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.io.File


private val IMAGE_PICK_CODE = 1000;

//Permission code
private val PERMISSION_CODE = 1001;
var imageUtiles: TakeImageUtiles? = null
var isFILE = false
var filePath: File? = null
var presenter: SignUpPresenter? = null
var dialog: BottomSheetDialog? = null
var adapter: AddriessAdapter? = null
var countryList: List<Countrys>? = null
var currentSelectCountry:Countrys?=null
private var countryId = -1;

class SignUpActivity : BaseActivity<SignUpPresenter>(), TakeImageReceiveView, SignUpInterface,
    AddriessAdapter.clickCountry {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initVaribles()
        clickListner()
    }

    private fun initVaribles() {
        imageUtiles = TakeImageUtiles(this)
        presenter = SignUpPresenter()
        presenter?.attachView(this)
        presenter?.getCountries(this)
    }

    private fun clickListner() {
        Upload_user_image_add.setOnClickListener {
            imageUtiles?.selectImage(this, this)

        }
        signUpBtn.setOnClickListener {
            signUpData()
        }

        countryTv.setOnClickListener({
            ShowDialog()
        })

    }

    private fun signUpData() {
        var firstName = firstName.text.toString().trim()
        var neckName = nickName.text.toString().trim()
        var email = emailTv.text.toString().trim()
        var password = passwordTv.text.toString().trim()
        var conPass = confirmPassTv.text.toString().trim()
        var phone = phoneTv.text.toString().trim()
        presenter?.signUpData(
            phone, password, firstName, neckName, email, conPass, this,
            filePath,countryId, coorSignUp
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            if (requestCode == MainAppConstant.REQUEST_CAMERA) {
                isFILE = false
                if (data.extras == null) return
                val photo = data.extras!!["data"] as Bitmap?
                val tempUri = TakeImageUtiles.getImageUri(this, photo)
                val finalFile = File(TakeImageUtiles.getRealPathFromURI(this, tempUri))
                filePath = finalFile
                val bitmap = BitmapFactory.decodeFile(filePath!!.getAbsolutePath())
                Upload_user_image_add.setImageBitmap(bitmap)
                // requestPhoto =photo ;
//                imageUtiles!!.onCaptureImageResult(data, this, this)
            } else if (requestCode == MainAppConstant.SELECT_FILE) {
                isFILE = true
                imageUtiles!!.onCaptureImageResult(data, this, this)
                filePath = TakeImageUtiles.CreateFile(this, data)
                StaticMethod.printJson("patthhh", filePath)
                val bitmap = BitmapFactory.decodeFile(filePath!!.getAbsolutePath())
                Upload_user_image_add.setImageBitmap(bitmap)
//                imageUtiles!!.onCaptureImageResult(data, this, this)
            }
        }

    }

    override fun AftergettingImage(
        bitmap: Bitmap?,
        array: ByteArray?,
        fileName: String?,
        FilePath: File?
    ) {
    }

    override fun sucessSignUp(data: UserResponse) {
        StaticMethod.printJson("dsada", data)
        finish()
    }

    override fun listCountry(data: List<Countrys>) {
        countryList=data
    }

    fun ShowDialog() {
        val view: View = layoutInflater.inflate(R.layout.address_bottom_sheet, null)
        dialog = BottomSheetDialog(this)
        dialog!!.setContentView(view)
        dialog!!.show()
        val addressRv: RecyclerView = view.findViewById(R.id.addressRv)
        addressRv.layoutManager = LinearLayoutManager(this)
        adapter = AddriessAdapter(countryList, this,this)
        addressRv.adapter= adapter


    }

    override fun currentCountry(country: Countrys?) {
        if (country != null) {
            countryId=country.id
        }
        currentSelectCountry=country
        countryTv.setText(currentSelectCountry?.name)
        dialog?.cancel()
    }
}


