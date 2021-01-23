package com.mazad.Diana.gui.upload_mazad;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mazad.Diana.R;
import com.mazad.Diana.adapter.TitleDropAdapter;
import com.mazad.Diana.base_class.BaseFragment;
import com.mazad.Diana.data.DropDownResponse;
import com.mazad.Diana.gui.common.home.HomeActivity;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.Validator;
import com.mazad.Diana.utels.takeimage.TakeImageReceiveView;
import com.mazad.Diana.utels.takeimage.TakeImageUtiles;
import com.mazad.Diana.utels.utels.StaticMethods;
import com.mazad.Diana.utels.utels.ToastUtil;

import java.io.File;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.mazad.Diana.utels.AppConstant.catId;
import static com.mazad.Diana.utels.MainAppConstant.REQUEST_CAMERA;
import static com.mazad.Diana.utels.MainAppConstant.SELECT_FILE;
import static com.mazad.Diana.utels.takeimage.TakeImageUtiles.CreateFile;
import static com.mazad.Diana.utels.takeimage.TakeImageUtiles.getImageUri;
import static com.mazad.Diana.utels.takeimage.TakeImageUtiles.getRealPathFromURI;

public class UploadMazadFragment extends BaseFragment implements UploadMazadView, TitleDropAdapter.OnManufacturerListener, TakeImageReceiveView {
    UploadMazadPresenter presenter;
    @BindView(R.id.dropDownRecycler)
    RecyclerView dropDownRecycler;
    @BindView(R.id.addBtnAddAdsActivity)
    Button addBtnAddAdsActivity;
    @BindView(R.id.image1)
    ImageView image1;
    @BindView(R.id.image2)
    ImageView image2;
    @BindView(R.id.image3)
    ImageView image3;
    @BindView(R.id.bandRkamEt)
    EditText bandRkamEt;
    @BindView(R.id.descreptionET)
    EditText descreptionET;
    @BindView(R.id.priceEt)
    EditText priceEt;
    @BindView(R.id.raf3aEt)
    EditText raf3aEt;
    @BindView(R.id.raf3aRB)
    RadioButton raf3aRB;
    @BindView(R.id.Raf3aFreeRB)
    RadioButton Raf3aFreeRB;
    @BindView(R.id.Raf3aFreeLessThanRB)
    RadioButton Raf3aFreeLessThanRB;
    @BindView(R.id.rbOneHourAdsLengthAddAdsActivity)
    RadioButton rbOneHourAdsLengthAddAdsActivity;
    @BindView(R.id.enterMazadRG)
    RadioGroup enterMazadRG;
    @BindView(R.id.yesEnterMazad)
    RadioButton yesEnterMazad;
    @BindView(R.id.noEnterMazad)
    RadioButton noEnterMazad;
    TitleDropAdapter adapter;
    public static int FLAG_TYPE = 0;
    HashMap<String, String> capitalCities;
    TakeImageUtiles imageUtiles;
    boolean isFILE = false;
    File filePath_one = null;
    File filePath_two = null;
    File filePath_three = null;
    CheckBox checkBox_money;
    LinearLayout layout_money, layoutDate;
    TextView tvEndDate;
    Calendar calendar;
    DatePickerDialog datePickerDialog;
    RadioGroup rgBackSale, rgAdsLength, rgAdsTime, startMazadRG;
    ImageView adsImage;

    int startMazadePrice = -1, backAvilable = -1, addTimeState = -1, timeFinish = -1, enterMazad = -1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upload_mazad, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        initVribles();
        rgChoise();
        return view;
    }

    private void initView(View view) {
        checkBox_money = view.findViewById(R.id.checkBoxMoneyAddAdsActivity);
        layout_money = view.findViewById(R.id.layoutAddMoneyAddAdsActivity);
        tvEndDate = view.findViewById(R.id.tvEndDateAddAdsActivity);
        rgBackSale = view.findViewById(R.id.rgBackSaleAddAdsActivity);
        rgAdsLength = view.findViewById(R.id.rgAdsLengthAddAdsActivity);
        rgAdsTime = view.findViewById(R.id.rgAdsTimeAddAdsActivity);
        adsImage = view.findViewById(R.id.imageAddAdsActivity);
        layoutDate = view.findViewById(R.id.layoutDateAddAdsActivity);
        startMazadRG = view.findViewById(R.id.startMazadRG);

    }

    private void initVribles() {
        ((HomeActivity) getContext()).showHideBottonBar(View.VISIBLE);
        imageUtiles = new TakeImageUtiles(this);
        capitalCities = new HashMap<String, String>();
        dropDownRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter = new UploadMazadPresenter();
        presenter.attachView(this);
        presenter.dropList(getContext(), catId);
    }

    @Override
    public void dorpDown(List<DropDownResponse> data) {
        adapter = new TitleDropAdapter(data, getContext(), this);
        dropDownRecycler.setAdapter(adapter);
//        for ( int i = 0 ; i <data.size(); i++){
//            if (data.get(i).getIsmandatory()==1){
//                listIds.add(data.get(i).getId());
//            }
//        }
    }

    @Override
    public void successAdded() {
        getActivity().finish();
    }

//    @Override
//    public void successAdded() {
//        ((HomeActivity)getContext()).display(LIST_DIRECT_ADD_FRAGMENT);
//    }

    @Override
    public void onManufacturerClick(String titleId, String supId) {
        capitalCities.put(titleId, supId);

    }

    @OnClick({R.id.addBtnAddAdsActivity, R.id.image1, R.id.image2, R.id.image3})
    void click(View view) {
        Set<String> keySet = capitalCities.keySet();
        Collection<String> values = capitalCities.values();

        switch (view.getId()) {

            case R.id.addBtnAddAdsActivity:

                StaticMethods.printJson("tesdsdsd", keySet);
                StaticMethods.printJson("tesdsdsd", values);
//                presenter.PostDirectSale(catId,getContext(),bandRkamEt.getText().toString(),descreptionET.getText().toString()
//                        ,StaticMethods.returnJson(keySet),StaticMethods.returnJson(values),priceEt.getText().toString(),filePath_one,filePath_two,filePath_three, AppConstant.userResponse.getUser().get(0).getId(), elegantBtn.getNumber());

                addBtnAddHit(keySet,values);

                break;

            case R.id.image1:
                FLAG_TYPE = 1;
                imageUtiles.selectImage(getContext(), this);
                break;
            case R.id.image2:
                FLAG_TYPE = 2;
                imageUtiles.selectImage(getContext(), this);
                break;
            case R.id.image3:
                FLAG_TYPE = 3;
                imageUtiles.selectImage(getContext(), this);
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == REQUEST_CAMERA) {
                isFILE = false;
                if (data.getExtras() == null)
                    return;
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                Uri tempUri = getImageUri(getContext(), photo);
                File finalFile = new File(getRealPathFromURI(getContext(), tempUri));
                if (FLAG_TYPE == 1) {
                    filePath_one = finalFile;
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath_one.getAbsolutePath());
                    image1.setImageBitmap(bitmap);
//                    uploadProfileImageTV.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, null, null, null);
                } else if (FLAG_TYPE == 2) {
                    filePath_two = finalFile;
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath_two.getAbsolutePath());
                    image2.setImageBitmap(bitmap);
//                    uploadIdImageTv.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, null, null, null);
                } else if (FLAG_TYPE == 3) {
                    filePath_three = finalFile;
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath_three.getAbsolutePath());
                    image3.setImageBitmap(bitmap);
//                    uploadIdImageTv.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, null, null, null);
                }

                // requestPhoto =photo ;
                imageUtiles.onCaptureImageResult(data, getContext(), getActivity());
            } else if (requestCode == SELECT_FILE) {
                isFILE = true;
                imageUtiles.onCaptureImageResult(data, getContext(), getActivity());
                if (FLAG_TYPE == 1) {
                    filePath_one = CreateFile(getActivity(), data);
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath_one.getAbsolutePath());
                    image1.setImageBitmap(bitmap);

                } else if (FLAG_TYPE == 2) {
                    filePath_two = CreateFile(getActivity(), data);
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath_two.getAbsolutePath());
                    image2.setImageBitmap(bitmap);
                } else if (FLAG_TYPE == 3) {
                    filePath_three = CreateFile(getActivity(), data);
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath_three.getAbsolutePath());
                    image3.setImageBitmap(bitmap);
                }
                imageUtiles.onCaptureImageResult(data, getContext(), getActivity());

            }
        }


    }

    @Override
    public void AftergettingImage(Bitmap bitmap, byte[] array, String fileName, File FilePath) {

    }


    public void DisplayCalender() {

        tvEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);


                datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvEndDate.setText(dayOfMonth + "/" + (month + 1) + "/" + (year));
//                        end_ads = (dayOfMonth + "/" + (month + 1) + "/" + (year) + " 24:00:00");
                    }
                }, day, month, year);

                //   String format1 = SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.getDefault());

                datePickerDialog.show();
            }
        });

    }

    public void rgChoise() {
        // bdayt elmazad
        startMazadRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.raf3aRB:
                        startMazadePrice = 1;
                        raf3aEt.setText("");
                        raf3aEt.setVisibility(View.VISIBLE);
                        break;
                    case R.id.Raf3aFreeRB:
                        startMazadePrice = 2;
                        raf3aEt.setText("");
                        raf3aEt.setVisibility(View.GONE);
                        break;

                    case R.id.Raf3aFreeLessThanRB:
                        startMazadePrice = 3;
                        raf3aEt.setText("");
                        raf3aEt.setVisibility(View.VISIBLE);
                        break;

                }
            }
        });

        // y7k elrogo3
        rgBackSale.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbYesBackSaleActivity:

                        backAvilable = 1;

                        break;
                    case R.id.rbNoBackSaleActivity:

                        backAvilable = 2;

                        break;

                }
            }
        });

        // when add finish
        rgAdsLength.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbOneHourAdsLengthAddAdsActivity:
                        addTimeState = 1;
                        tvEndDate.setText("");
                        layoutDate.setVisibility(View.GONE);
                        break;

                    case R.id.rbOneDayAdsLengthAddAdsActivity:
                        addTimeState = 2;
                        layoutDate.setVisibility(View.GONE);
                        tvEndDate.setText("");
                        break;
                    case R.id.rbMoreDaysAdsLengthAddAdsActivity:
                        addTimeState = 3;
                        DisplayCalender();
                        layoutDate.setVisibility(View.VISIBLE);

                        break;

                }
            }
        });

        //time finish
        rgAdsTime.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rbTenAdsTimeAddAdsActivity:
                    timeFinish = 1;

                    break;
                case R.id.rbTwelveAdsTimeAddAdsActivity:

                    timeFinish = 2;

                    break;

            }
        });

        //enter mazad
        enterMazadRG.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.yesEnterMazad:

                    enterMazad = 1;

                    break;
                case R.id.noEnterMazad:


                    enterMazad = 2;

                    break;

            }
        });

    }


    private void addBtnAddHit(Set<String> keySet, Collection<String> values) {
        if (startMazadePrice != -1) {
            switch (startMazadePrice) {
                case 1:
                    if (Validator.isTextEmpty(raf3aEt.getText().toString())) {
                        ToastUtil.showErrorToast(getContext(), "من فضلك حدد سعر الرفعة ");

                        return;
                    }
                    break;
                case 3:
                    if (Validator.isTextEmpty(raf3aEt.getText().toString())) {
                        ToastUtil.showErrorToast(getContext(), "من فضلك حدد سعر لا يقل عن ");
                        return;
                    }
                    break;

            }
        } else {
            ToastUtil.showErrorToast(getContext(), "من فضلك اختر بداية المزاد ");
            return;
        }


        if (backAvilable == -1) {
            ToastUtil.showErrorToast(getContext(), "من فضلك حدد احقية الرجوع ");
            return;
        }


        if (addTimeState != -1) {
            switch (addTimeState) {
                case 3:
                    if (Validator.isTextEmpty(tvEndDate.getText().toString())) {
                        ToastUtil.showErrorToast(getContext(), "من فضلك حدد تاريخ انتهاء الاعلان ");
                        return;
                    }
                    break;

            }
        } else {
            ToastUtil.showErrorToast(getContext(), "من فضلك حدد مدة انتهاء الاعلان");
            return;
        }

        if (timeFinish == -1) {
            ToastUtil.showErrorToast(getContext(), "من فضلك حدد  ينتهي في  ");
            return;
        }

        if (enterMazad == -1) {
            ToastUtil.showErrorToast(getContext(), "من فضلك حدد احقية دخول المزاد في النصف الساعه الاخير  ");
            return;
        }

        presenter.PostDirectSale(catId,getContext(),bandRkamEt.getText().toString(),descreptionET.getText().toString()
                ,StaticMethods.returnJson(keySet),StaticMethods.returnJson(values),priceEt.getText().toString(),filePath_one,filePath_two,filePath_three, AppConstant.userResponse.getUser().get(0).getId(),
                addTimeState,timeFinish,tvEndDate.getText().toString(),backAvilable,startMazadePrice,raf3aEt.getText().toString(),
                raf3aEt.getText().toString(),enterMazad);


    }

}