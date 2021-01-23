package com.mazad.Diana.gui.direct_add_details;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.mazad.Diana.R;
import com.mazad.Diana.adapter.DirectDropDownDetailsAdapter;
import com.mazad.Diana.adapter.MySliderAdapter;
import com.mazad.Diana.base_class.BaseFragment;
import com.mazad.Diana.data.AddDetails;
import com.mazad.Diana.gui.UserDetails.UserDetailsActivity;
import com.mazad.Diana.gui.common.home.HomeActivity;
import com.mazad.Diana.gui.my_booked.MyBookedFragment;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.AppKey;
import com.mazad.Diana.utels.utels.IntentUtiles;
import com.mazad.Diana.utels.utels.StaticMethods;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.mazad.Diana.utels.AppConstant.LIST_DIRECT_ADD_FRAGMENT;
import static com.mazad.Diana.utels.AppConstant.MY_BOOK_FRAGMENT;
import static com.mazad.Diana.utels.AppKey.userData;

public class AddsDirectDetailsFragment extends BaseFragment implements AddsDirectDetailsView {
    AddsDirectDetailsPresenter presenter;
    @BindView(R.id.sliderPlace)
    SliderView sliderPlace;
    @BindView(R.id.bandRakamTv)
    TextView bandRakamTv;
    @BindView(R.id.descreptionTv)
    TextView descreptionTv;
    @BindView(R.id.priceTv)
    TextView priceTv;
    @BindView(R.id.avilabelNumberTv)
    TextView avilabelNumberTv;
    @BindView(R.id.isBooked)
    TextView isBooked;
    @BindView(R.id.dateAddTv)
    TextView dateAddTv;
    @BindView(R.id.dropRv)
    RecyclerView dropRv;
    @BindView(R.id.userNameTv)
    TextView userNameTv;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.userImageCv)
    CircleImageView userImageCv;
    @BindView(R.id.elegantBtn)
    ElegantNumberButton elegantBtn;
    @BindView(R.id.numberBookedLinear)
    LinearLayout numberBookedLinear;
    @BindView(R.id.bookBtn)
    Button bookBtn;
    @BindView(R.id.viewBookedAddTv)
    TextView viewBookedAddTv;
    @BindView(R.id.layoutUserDetailsPostActivity)
    LinearLayout layoutUserDetailsPostActivity;
    MySliderAdapter mySliderAdapter;
    List<String> imageList;
    public static int idAdds;
    DirectDropDownDetailsAdapter dropDownDetailsAdapter;
    AddDetails myAddPostion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_adds_direct_details, container, false);
        ButterKnife.bind(this, view);
        initVaribles();
        return view;
    }

    private void initVaribles() {
        imageList = new ArrayList<>();
        dropRv.setLayoutManager(new LinearLayoutManager(getContext()));
        ((HomeActivity) getContext()).showHideBottonBar(View.GONE);
        // get bundel addID
        presenter = new AddsDirectDetailsPresenter();
        presenter.attachView(this);
        presenter.addDetails(idAdds, getContext());
    }

    @Override
    public void currentAddDetails(AddDetails data) {
        setData(data);
        StaticMethods.printJson("aaddDetaisl", data);
    }


    private void setData(AddDetails currentAdd) {
        myAddPostion = currentAdd;
        bandRakamTv.setText(String.valueOf(currentAdd.getBandRkm()));
        descreptionTv.setText(String.valueOf(currentAdd.getGeneralDescription()));
        priceTv.setText(String.valueOf(currentAdd.getPrice()));
        avilabelNumberTv.setText(String.valueOf(currentAdd.getAvailableNumber()));
        dateAddTv.setText(currentAdd.getTimePublish());
        try {
            location.setText(currentAdd.getUsers().getCountrys().getName());
        }catch (Exception e){
            location.setText("مصر");
        }
        userNameTv.setText(String.valueOf(currentAdd.getUsers().getFirstName()));
        Picasso.get().load(AppConstant.BASE_IMAGE + currentAdd.getUsers().getImage()).into(userImageCv);

        // isbooked
        if (currentAdd.getIsbooked() == AppKey.UNBOOKED) {
            isBooked.setText(R.string.avilable);
        } else if (currentAdd.getIsbooked() == AppKey.BOOKED) {
            isBooked.setText(R.string.adds_finish);
        } else {
            isBooked.setText(R.string.avilable);
        }
        // set 3 image in list
        if (currentAdd.getImg1() != null) {
            imageList.add(AppConstant.BASE_IMAGE + currentAdd.getImg1());
        }
        if (currentAdd.getImg2() != null) {
            imageList.add(AppConstant.BASE_IMAGE + currentAdd.getImg2());
        }
        if (currentAdd.getImg3() != null) {
            imageList.add(AppConstant.BASE_IMAGE + currentAdd.getImg3());
        }
        //slider
        mySliderAdapter = new MySliderAdapter(getContext(), imageList);
        sliderPlace.setSliderAdapter(mySliderAdapter);
        sliderPlace.startAutoCycle();
        //dropdown
        dropDownDetailsAdapter = new DirectDropDownDetailsAdapter(currentAdd.getDropdownlistids(), getContext());
        dropRv.setAdapter(dropDownDetailsAdapter);

        if (AppConstant.userResponse != null) {
            if (AppConstant.userResponse.getUser().get(0).getId().equals(currentAdd.getUsers().getId())) {
                bookBtn.setVisibility(View.GONE);
                numberBookedLinear.setVisibility(View.GONE);
                viewBookedAddTv.setVisibility(View.VISIBLE);
            } else if (!AppConstant.userResponse.getUser().get(0).getId().equals(currentAdd.getUsers().getId())) {
                bookBtn.setVisibility(View.VISIBLE);
                numberBookedLinear.setVisibility(View.VISIBLE);
                viewBookedAddTv.setVisibility(View.GONE);
            }
        } else {
            bookBtn.setVisibility(View.GONE);
            numberBookedLinear.setVisibility(View.GONE);
            viewBookedAddTv.setVisibility(View.GONE);
        }
    }


    @OnClick({R.id.bookBtn, R.id.viewBookedAddTv,R.id.layoutUserDetailsPostActivity})
    void onclick(View view) {
        switch (view.getId()) {
            case R.id.bookBtn:
                presenter.bookAdd(myAddPostion.getId(), myAddPostion.getCateId(), Integer.parseInt(elegantBtn.getNumber()), AppConstant.userResponse.getUser().get(0).getId(), getContext());
                break;
            case R.id.viewBookedAddTv:
                MyBookedFragment.addIdRefrance = myAddPostion.getId();
                ((HomeActivity) getContext()).display(MY_BOOK_FRAGMENT);
                break;

            case R.id.layoutUserDetailsPostActivity:
                Bundle bundle =new Bundle();
                bundle.putParcelable(userData,myAddPostion.getUsers());
                IntentUtiles.openActivity(getContext(), UserDetailsActivity.class,bundle,false);
                break;
        }
    }

    @Override
    public void successBooked() {
        ((HomeActivity) getContext()).display(LIST_DIRECT_ADD_FRAGMENT);
    }
}

