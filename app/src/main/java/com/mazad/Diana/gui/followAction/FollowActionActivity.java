package com.mazad.Diana.gui.followAction;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mazad.Diana.R;
import com.mazad.Diana.adapter.FollowActionAdapter;
import com.mazad.Diana.base_class.BaseActivity;
import com.mazad.Diana.data.Auction;
import com.mazad.Diana.data.BookListResponse;
import com.mazad.Diana.data.FollowMazadResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FollowActionActivity extends BaseActivity implements FollowActionView {
@BindView(R.id.recycleFollowPostDetailsActivity)
    RecyclerView recycleFollowPostDetailsActivity;
    FollowActionAdapter auctionAdapter;
    FollowActionPresenter presenter;
    public static int id_MazadAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_action);
        ButterKnife.bind(this);
        initVarible();

    }

    private void initVarible() {
        recycleFollowPostDetailsActivity.setLayoutManager(new LinearLayoutManager(this));
        presenter=new FollowActionPresenter();
        presenter.attachView(this);
        presenter.addDetails(id_MazadAdd,this);
    }

    @Override
    public void userEnterList(List<FollowMazadResponse> data) {
        auctionAdapter=new FollowActionAdapter(this,data);
        recycleFollowPostDetailsActivity.setAdapter(auctionAdapter);
    }
}
