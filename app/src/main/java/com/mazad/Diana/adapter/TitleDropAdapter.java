package com.mazad.Diana.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mazad.Diana.R;
import com.mazad.Diana.data.DropDownResponse;

import java.util.List;


public class TitleDropAdapter extends RecyclerView.Adapter<TitleDropAdapter.VH> {
    List<DropDownResponse> sidesResponseList;
    Context context;
    OnManufacturerListener listener;
    public TitleDropAdapter(List<DropDownResponse> sidesResponseList, Context context,OnManufacturerListener onManufacturerListener) {
        this.sidesResponseList = sidesResponseList;
        this.context = context;
        this.listener = onManufacturerListener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.add_ons_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        DropDownResponse add_onsResponse =sidesResponseList.get(position);
        holder.titleHead.setText(add_onsResponse.getMainTitle());
        DetailsDropDownAdapter productAdapter=new DetailsDropDownAdapter(context,add_onsResponse.getSubTitles(),listener);
        holder.addOnsRecycler.setHasFixedSize(true);
        holder.addOnsRecycler.setLayoutManager(new LinearLayoutManager(context));
        holder.addOnsRecycler.setAdapter(productAdapter);
        holder.expandIV.setOnClickListener(v -> {
            if (holder.addOnsRecycler.isShown()) {
                Log.i("basketOrderRV", "closed");
                holder.addOnsRecycler.setVisibility(View.GONE);
            } else {
                Log.i("basketOrderRV", "opened");
                holder.addOnsRecycler.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sidesResponseList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        RecyclerView addOnsRecycler;
        ImageView expandIV;
        TextView titleHead;
        public VH(@NonNull View itemView) {
            super(itemView);
            titleHead=itemView.findViewById(R.id.titleHead);
            addOnsRecycler=itemView.findViewById(R.id.addOnsRecycler);
            expandIV=itemView.findViewById(R.id.expandIV);

        }
    }
    public interface OnManufacturerListener {
        void onManufacturerClick(String mainTitleId,String supId);
    }
}
