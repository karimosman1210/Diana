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
import com.mazad.Diana.data.SubTitleDropDown;

import java.util.List;


public class DetailsDropDownAdapter extends RecyclerView.Adapter<DetailsDropDownAdapter.VH> {
    Context context;
    List<SubTitleDropDown> sidesProductList;
    TitleDropAdapter.OnManufacturerListener listener;
    int row_index = -1;

    public DetailsDropDownAdapter(Context context, List<SubTitleDropDown> sidesProductList, TitleDropAdapter.OnManufacturerListener listener) {
        this.context = context;
        this.sidesProductList = sidesProductList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.add_ons_product, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        SubTitleDropDown sidesProduct = sidesProductList.get(position);
        holder.titleTv.setText(sidesProduct.getTitle());
        holder.checkedIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();
                listener.onManufacturerClick(String.valueOf(sidesProduct.getMainTitleId()), String.valueOf(sidesProduct.getId()));
            }
        });

        if (row_index != -1) {
            if (row_index == position) {
                sidesProductList.get(position).setChecked(true);
                holder.checkedIv.setImageResource(R.drawable.select_icon);
            } else {
                holder.checkedIv.setImageResource(R.drawable.un_select);
                sidesProductList.get(position).setChecked(false);
            }
        }

    }

    @Override
    public int getItemCount() {
        return sidesProductList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView titleTv;
        ImageView checkedIv;

        public VH(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.titleTv);
            checkedIv = itemView.findViewById(R.id.checkedIv);

        }
    }
}
