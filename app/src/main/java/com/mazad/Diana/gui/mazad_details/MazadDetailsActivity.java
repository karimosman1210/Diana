package com.mazad.Diana.gui.mazad_details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mazad.Diana.R;
import com.mazad.Diana.adapter.DirectDropDownDetailsAdapter;
import com.mazad.Diana.adapter.MySliderAdapter;
import com.mazad.Diana.base_class.BaseActivity;
import com.mazad.Diana.data.MazadResponse;
import com.mazad.Diana.gui.UserDetails.UserDetailsActivity;
import com.mazad.Diana.gui.common.home.HomeActivity;
import com.mazad.Diana.gui.followAction.FollowActionActivity;
import com.mazad.Diana.gui.my_booked.MyBookedFragment;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.AppKey;
import com.mazad.Diana.utels.ToastUtel;
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

import static com.mazad.Diana.utels.AppConstant.MY_BOOK_FRAGMENT;
import static com.mazad.Diana.utels.AppConstant.userResponse;
import static com.mazad.Diana.utels.AppKey.userData;

public class MazadDetailsActivity extends BaseActivity implements MazadDetailsView {
    MazadDetailsPrsenter prsenter;
    MazadResponse mazadResponse;
    @BindView(R.id.sliderPlace)
    SliderView sliderPlace;
    @BindView(R.id.bandRakamTv)
    TextView bandRakamTv;
    @BindView(R.id.descreptionTv)
    TextView descreptionTv;
    @BindView(R.id.priceTv)
    TextView priceTv;
    @BindView(R.id.currentPrice)
    TextView currentPrice;
    @BindView(R.id.right_backTv)
    TextView right_backTv;
    @BindView(R.id.startMazadTv)
    TextView startMazadTv;
    @BindView(R.id.dateAddTv)
    TextView dateAddTv;
    @BindView(R.id.endDateAdd)
    TextView endDateAdd;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.enterMazadLastHuveTv)
    TextView enterMazadLastHuveTv;
    @BindView(R.id.userImageCv)
    CircleImageView userImageCv;
    @BindView(R.id.userNameTv)
    TextView userNameTv;
    @BindView(R.id.isBooked)
    TextView isBooked;
    @BindView(R.id.endTime)
    TextView endTime;
    @BindView(R.id.enterMazadTV)
    TextView enterMazadTV;
    @BindView(R.id.followMazadTv)
    TextView followMazadTv;
    MySliderAdapter mySliderAdapter;
    List<String> imageList;
    DirectDropDownDetailsAdapter dropDownDetailsAdapter;
    @BindView(R.id.dropRv)
    RecyclerView dropRv;
    BottomSheetDialog dialog;
    @BindView(R.id.layoutUserDetailsPostActivity)
    LinearLayout layoutUserDetailsPostActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mazad_details);
        ButterKnife.bind(this);
        initVribles();
    }

    private void initVribles() {
        prsenter=new MazadDetailsPrsenter();
        prsenter.attachView(this);
        dropRv.setLayoutManager(new LinearLayoutManager(this));
        Intent intent=getIntent();
        if (intent.getParcelableExtra("adsModel")!=null){
            mazadResponse=intent.getParcelableExtra("adsModel");
            StaticMethods.printJson("dddd",mazadResponse);
            setData(mazadResponse);
        }
    }

    private void setData(MazadResponse currentAdd) {
        imageList = new ArrayList<>();
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
        mySliderAdapter = new MySliderAdapter(this, imageList);
        sliderPlace.setSliderAdapter(mySliderAdapter);
        sliderPlace.startAutoCycle();

        bandRakamTv.setText(String.valueOf(currentAdd.getBandRkm()));
        descreptionTv.setText(String.valueOf(currentAdd.getGeneralDescription()));
        priceTv.setText(String.valueOf(currentAdd.getPrice()));
        currentPrice.setText(String.valueOf(currentAdd.getNewPrice()));
        dateAddTv.setText(currentAdd.getTimePublish());
        endDateAdd.setText(currentAdd.getMazadEndDate());
        try {
            location.setText(currentAdd.getUsers().getCountrys().getName());
        }catch (Exception e){
            location.setText("مصر");
        }
        Picasso.get().load(AppConstant.BASE_IMAGE + currentAdd.getUsers().getImage()).into(userImageCv);
        userNameTv.setText(String.valueOf(currentAdd.getUsers().getFirstName()));
        if (currentAdd.getRightBack()==0){
            right_backTv.setText("نعم");
        }else {
            right_backTv.setText("لا");

        }
        if (currentAdd.getMazadFinished() == AppKey.UNBOOKED) {
            isBooked.setText(R.string.avilable);
        } else if (currentAdd.getMazadFinished() == AppKey.BOOKED) {
            isBooked.setText(R.string.adds_finish);
        } else {
            isBooked.setText(R.string.avilable);
        }
        if (currentAdd.getEnterMazad()==1){
            enterMazadLastHuveTv.setText("نعم");
        }else if (currentAdd.getEnterMazad()==2){
            enterMazadLastHuveTv.setText("لا");
        }
        if (currentAdd.getEndAddTime()==1){
            endTime.setText("العاشرة مسائا");
        }else if (currentAdd.getEndAddTime()==2){
            endTime.setText("منتصف الليل");
        }
        if (currentAdd.getRaise()==1){
            startMazadTv.setText("الرفعه بقيمه"+" "+currentAdd.getRaiseRkm());
        }else if (currentAdd.getRaise()==2){
            startMazadTv.setText("حرة ومتروكة للمزايد");
        }else if (currentAdd.getRaise()==3){
            startMazadTv.setText( " لا تقل عن  "+currentAdd.getLessRaise());
        }

        if (userResponse != null&&currentAdd.getMazadFinished()==0) {

            enterMazadTV.setVisibility(View.VISIBLE);
            followMazadTv.setVisibility(View.VISIBLE);
            if (AppConstant.userResponse.getUser().get(0).getId().equals(currentAdd.getUsers().getId())) {
                enterMazadTV.setVisibility(View.GONE);
            } else {
                enterMazadTV.setVisibility(View.VISIBLE);
            }

        }else{
            enterMazadTV.setVisibility(View.GONE);
            followMazadTv.setVisibility(View.GONE);
        }

        //dropdown
        dropDownDetailsAdapter = new DirectDropDownDetailsAdapter(currentAdd.getDropdownlistids(), this);
        dropRv.setAdapter(dropDownDetailsAdapter);
    }
    public void ShowDialog() {
        View view = getLayoutInflater().inflate(R.layout.button_sheet, null);
         dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);
        dialog.show();
        Button cashBtn = view.findViewById(R.id.confermBtn);
        Button visaBtn = view.findViewById(R.id.cancel);
        EditText price = view.findViewById(R.id.priceEtSheet);

        cashBtn.setOnClickListener(v -> {

            prsenter.rePublishAdd(mazadResponse.getId(),price.getText().toString(), userResponse.getUser().get(0).getId(),mazadResponse.getCateId(),this);

        });

        visaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();

            }

        });

    }

    @Override
    public void bookedSuccess() {
        dialog.hide();
    }

    @OnClick({R.id.enterMazadTV, R.id.followMazadTv,R.id.layoutUserDetailsPostActivity})
    void onclick(View view) {
        switch (view.getId()) {
            case R.id.enterMazadTV:
                ShowDialog();
                break;
            case R.id.followMazadTv:
                FollowActionActivity.id_MazadAdd=mazadResponse.getId();
            IntentUtiles.openActivity(this, FollowActionActivity.class);
                break;
            case R.id.layoutUserDetailsPostActivity:
                Bundle bundle =new Bundle();
                bundle.putParcelable(userData,mazadResponse.getUsers());
                IntentUtiles.openActivity(this, UserDetailsActivity.class,bundle,false);
                break;



        }
    }
}