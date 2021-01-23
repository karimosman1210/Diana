package com.mazad.Diana.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mazad.Diana.R;
import com.mazad.Diana.data.AddDetails;
import com.mazad.Diana.data.HogozatyResponse;
import com.mazad.Diana.gui.common.home.HomeActivity;
import com.mazad.Diana.gui.direct_add_details.AddsDirectDetailsFragment;
import com.mazad.Diana.utels.AppConstant;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.mazad.Diana.utels.AppConstant.ADDS_DETAILS_PAGE;

public class HogozatyAdapter extends RecyclerView.Adapter<HogozatyAdapter.VH> {
    Context context ;
    List<HogozatyResponse> addsList;

    public HogozatyAdapter(Context context, List<HogozatyResponse> addsList) {
        this.context = context;
        this.addsList = addsList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.hogozaty_item, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        HogozatyResponse response =addsList.get(position);
        holder.descTv.setText(response.getDirectsale().getGeneralDescription());
        holder.priceTv.setText("العدد المطلوب "+" : " + response.getNumberProducts());
        Picasso.get().load(AppConstant.BASE_IMAGE+response.getDirectsale().getImg1()).into(holder.imgeAdIv);
        holder.dateTv.setText(response.getTimePublish());
        try {
            holder.addressTv.setText(response.getUser().getCountrys().getName());

        }catch (Exception  e){}

        if (response.getApproved().equals("0")){
            holder.rePublishTv.setText("لم يتم الموافقه");
        }else {
            holder.rePublishTv.setText("تم الموافقة علي الطلب");
            holder.rePublishTv.setBackground(context.getDrawable(R.color.green));
        }


        holder.itemView.setOnClickListener(v -> {
            AddsDirectDetailsFragment.idAdds=response.getDirectsale().getId();
            ((HomeActivity)context).display(ADDS_DETAILS_PAGE);
        });
    }

    @Override
    public int getItemCount() {
        return addsList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView descTv ,priceTv,dateTv,addressTv,rePublishTv;
        ImageView imgeAdIv,bookedIv;
        public VH(@NonNull View itemView) {
            super(itemView);
            descTv=itemView.findViewById(R.id.descTv);
            priceTv=itemView.findViewById(R.id.priceTv);
            dateTv=itemView.findViewById(R.id.dateTv);
            addressTv=itemView.findViewById(R.id.addressTv);
            imgeAdIv=itemView.findViewById(R.id.imgeAdIv);
            bookedIv=itemView.findViewById(R.id.bookedIv);
            rePublishTv=itemView.findViewById(R.id.rePublishTv);
        }
    }
}
