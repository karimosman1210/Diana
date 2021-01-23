package com.mazad.Diana.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mazad.Diana.R;
import com.mazad.Diana.data.Countrys;

import java.util.List;

public class AddriessAdapter extends RecyclerView.Adapter<AddriessAdapter.VH> {
    List<Countrys> countrys ;
    Context context;
    clickCountry view;
    public AddriessAdapter(List<Countrys> countrys, Context context,clickCountry view) {
        this.countrys = countrys;
        this.context = context;
        this.view=view;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.contry_item, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Countrys country=countrys.get(position);
        holder.countryTv.setText(country.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            view.currentCountry(country);
            }
        });

    }

    @Override
    public int getItemCount() {
        return countrys.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView countryTv;
        public VH(@NonNull View itemView) {
            super(itemView);
            countryTv=itemView.findViewById(R.id.countryTv);
        }
    }
    public interface clickCountry{
        void currentCountry(Countrys country) ;
    }
}
