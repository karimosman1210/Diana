package com.mazad.Diana.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mazad.Diana.R;
import com.mazad.Diana.data.CategoriesResponse;
import com.mazad.Diana.gui.common.home.HomeActivity;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.utels.IntentUtiles;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.VH> {
    List<CategoriesResponse> categoriesResponseList ;
    Context context;

    public CategoryAdapter(List<CategoriesResponse> stringList, Context context) {
        this.categoriesResponseList = stringList;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cat, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        CategoriesResponse category=categoriesResponseList.get(position);
        holder.tvUserNameFollowAuctionDetails.setText(category.getTitle());

        holder.itemView.setOnClickListener(view -> {
            AppConstant.catId =category.getId();
            IntentUtiles.openActivity(context, HomeActivity.class);
        });

    }

    @Override
    public int getItemCount() {
        return categoriesResponseList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView tvUserNameFollowAuctionDetails;
        public VH(@NonNull View itemView) {
            super(itemView);
            tvUserNameFollowAuctionDetails=itemView.findViewById(R.id.tvUserNameFollowAuctionDetails);
        }
    }
}
