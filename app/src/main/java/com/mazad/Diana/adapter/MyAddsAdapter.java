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
import com.mazad.Diana.data.AddDetails;
import com.mazad.Diana.data.DirectAddResponse;
import com.mazad.Diana.gui.common.home.HomeActivity;
import com.mazad.Diana.gui.direct_add_details.AddsDirectDetailsFragment;
import com.mazad.Diana.utels.AppConstant;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.mazad.Diana.utels.AppConstant.ADDS_DETAILS_PAGE;
import static com.mazad.Diana.utels.AppKey.BOOKED;
import static com.mazad.Diana.utels.AppKey.UNBOOKED;

public class MyAddsAdapter extends RecyclerView.Adapter<MyAddsAdapter.VH> {
    Context context ;
    List<AddDetails> addsList;

    public MyAddsAdapter(Context context, List<AddDetails> addsList) {
        this.context = context;
        this.addsList = addsList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.direct_post_item, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        AddDetails response =addsList.get(position);
        holder.descTv.setText(response.getGeneralDescription());
        holder.priceTv.setText(response.getPrice()+" " + context.getString(R.string.egp));
        Picasso.get().load(AppConstant.BASE_IMAGE+response.getImg1()).into(holder.imgeAdIv);
        holder.dateTv.setText(response.getTimePublish());
            holder.addressTv.setText(response.getUsers().getCountrys().getName());

        holder.itemView.setOnClickListener(v -> {
            AddsDirectDetailsFragment.idAdds=response.getId();
            ((HomeActivity)context).display(ADDS_DETAILS_PAGE);
        });
    }

    @Override
    public int getItemCount() {
        return addsList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView descTv ,priceTv,dateTv,addressTv;
        ImageView imgeAdIv,bookedIv;
        public VH(@NonNull View itemView) {
            super(itemView);
            descTv=itemView.findViewById(R.id.descTv);
            priceTv=itemView.findViewById(R.id.priceTv);
            dateTv=itemView.findViewById(R.id.dateTv);
            addressTv=itemView.findViewById(R.id.addressTv);
            imgeAdIv=itemView.findViewById(R.id.imgeAdIv);
            bookedIv=itemView.findViewById(R.id.bookedIv);

        }
    }
}
