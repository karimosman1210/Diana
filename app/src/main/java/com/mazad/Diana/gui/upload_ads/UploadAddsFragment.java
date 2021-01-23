package com.mazad.Diana.gui.upload_ads;

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
import android.widget.EditText;
import android.widget.ImageView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.mazad.Diana.R;
import com.mazad.Diana.adapter.TitleDropAdapter;
import com.mazad.Diana.base_class.BaseFragment;
import com.mazad.Diana.data.DropDownResponse;
import com.mazad.Diana.gui.common.home.HomeActivity;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.takeimage.TakeImageReceiveView;
import com.mazad.Diana.utels.takeimage.TakeImageUtiles;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.mazad.Diana.utels.AppConstant.LIST_DIRECT_ADD_FRAGMENT;
import static com.mazad.Diana.utels.AppConstant.catId;
import static com.mazad.Diana.utels.MainAppConstant.REQUEST_CAMERA;
import static com.mazad.Diana.utels.MainAppConstant.SELECT_FILE;
import static com.mazad.Diana.utels.takeimage.TakeImageUtiles.CreateFile;
import static com.mazad.Diana.utels.takeimage.TakeImageUtiles.getImageUri;
import static com.mazad.Diana.utels.takeimage.TakeImageUtiles.getRealPathFromURI;

public class UploadAddsFragment extends BaseFragment implements UploadAddsView, TitleDropAdapter.OnManufacturerListener, TakeImageReceiveView {
    UploadAddsPresenter presenter;
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
    TitleDropAdapter adapter;
    public static int FLAG_TYPE = 0;
    HashMap<String, String> capitalCities;
    TakeImageUtiles imageUtiles;
    boolean isFILE = false;
    File filePath_one = null;
    File filePath_two = null;
    File filePath_three = null;
    @BindView(R.id.elegantBtn)
    ElegantNumberButton elegantBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upload_adds, container, false);
        ButterKnife.bind(this, view);
        initVribles();
        return view;
    }

    private void initVribles() {
        ((HomeActivity)getContext()).showHideBottonBar(View.VISIBLE);
        imageUtiles = new TakeImageUtiles(this);
        capitalCities = new HashMap<String, String>();
        dropDownRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter = new UploadAddsPresenter();
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
        ((HomeActivity)getContext()).display(LIST_DIRECT_ADD_FRAGMENT);
    }

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
                presenter.PostDirectSale(catId,getContext(),bandRkamEt.getText().toString(),descreptionET.getText().toString()
                ,StaticMethods.returnJson(keySet),StaticMethods.returnJson(values),priceEt.getText().toString(),filePath_one,filePath_two,filePath_three, AppConstant.userResponse.getUser().get(0).getId(), elegantBtn.getNumber());
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
}