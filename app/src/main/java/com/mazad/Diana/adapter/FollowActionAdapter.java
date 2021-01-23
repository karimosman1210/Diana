package com.mazad.Diana.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mazad.Diana.R;
import com.mazad.Diana.data.BookListResponse;
import com.mazad.Diana.data.FollowMazadResponse;
import com.mazad.Diana.gui.UserDetails.UserDetailsActivity;
import com.mazad.Diana.data.Auction;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.utels.IntentUtiles;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.mazad.Diana.utels.AppKey.userData;

public class FollowActionAdapter extends RecyclerView.Adapter<FollowActionAdapter.Holder> {
    private Context context;
    private List<FollowMazadResponse> arrayList;

    public FollowActionAdapter(Context context, List<FollowMazadResponse> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView tv_username, tv_time, tv_endPrice;
        CircleImageView image_user;

        public Holder(View itemView) {
            super(itemView);

            tv_username = (TextView) itemView.findViewById(R.id.tvUserNameFollowAuctionDetails);
            tv_time = (TextView) itemView.findViewById(R.id.tvTimeFollowAuctionDetails);
            tv_endPrice = (TextView) itemView.findViewById(R.id.tvEndPriceFollowAuctionDetails);
            image_user = (CircleImageView) itemView.findViewById(R.id.imageUserFollowAuctionDetails);
        }
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(context).inflate(R.layout.item_follow_recycle_auction, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        final FollowMazadResponse item_recycle = arrayList.get(position);
        holder.tv_username.setText(item_recycle.getUser().getFirstName());
        holder.tv_time.setText(item_recycle.getTimePublish());
        holder.tv_endPrice.setText("المبلغ"+" : "+item_recycle.getNewPrice().toString());
        Picasso.get().load(AppConstant.BASE_IMAGE +item_recycle.getUser().getImage()).into(holder.image_user);
        holder.image_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle =new Bundle();
                bundle.putParcelable(userData,item_recycle.getUser());
                IntentUtiles.openActivity(context, UserDetailsActivity.class,bundle,false);

            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
