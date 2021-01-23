package com.mazad.Diana.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mazad.Diana.R;
import com.mazad.Diana.data.DirectAddResponse;
import com.mazad.Diana.utels.AppConstant;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyStoreAdapter extends RecyclerView.Adapter<MyStoreAdapter.VH> {
    Context context ;
    List<DirectAddResponse> addsList;
    clickView view;
    public MyStoreAdapter(Context context, List<DirectAddResponse> addsList,clickView view) {
        this.context = context;
        this.addsList = addsList;
        this.view=view;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.re_direct_post_item, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        DirectAddResponse response =addsList.get(position);
        holder.descTv.setText(response.getGeneralDescription());
        holder.priceTv.setText(response.getPrice()+" " + context.getString(R.string.egp));
        Picasso.get().load(AppConstant.BASE_IMAGE+response.getImg1()).into(holder.imgeAdIv);
        holder.dateTv.setText(response.getTimePublish());
        holder.addressTv.setText(response.getUsers().getCountrys().getName());
        holder.rePublishTv.setOnClickListener(v -> {
               view.republishAdd(response.getDirectSaleId());
        });
    }

    @Override
    public int getItemCount() {
        return addsList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView descTv ,priceTv,dateTv,addressTv,rePublishTv;
        ImageView imgeAdIv;
        public VH(@NonNull View itemView) {
            super(itemView);
            descTv=itemView.findViewById(R.id.descTv);
            priceTv=itemView.findViewById(R.id.priceTv);
            dateTv=itemView.findViewById(R.id.dateTv);
            addressTv=itemView.findViewById(R.id.addressTv);
            imgeAdIv=itemView.findViewById(R.id.imgeAdIv);
            rePublishTv=itemView.findViewById(R.id.rePublishTv);


        }
    }
    public interface clickView{
        void republishAdd(Integer id);
    }
}
