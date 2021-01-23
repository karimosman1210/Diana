package com.mazad.Diana.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mazad.Diana.R;
import com.mazad.Diana.data.Sale_typeResponse;
import com.mazad.Diana.gui.main_page.MainPage;
import com.mazad.Diana.utels.AppConstant;

import java.util.List;

import butterknife.ButterKnife;

import static com.mazad.Diana.utels.AppKey.CATEGORY_PAGE;


public class TypeSaleAdapter extends RecyclerView.Adapter<TypeSaleAdapter.VH> {
    Context context;
    List<Sale_typeResponse> sale_typeList;

    public TypeSaleAdapter(Context context, List<Sale_typeResponse> sale_typeList) {
        this.context = context;
        this.sale_typeList = sale_typeList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sale_type_item, parent, false);
        ButterKnife.bind(this, view);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Sale_typeResponse typeResponse = sale_typeList.get(position);
        holder.titleTypeSale.setText(typeResponse.getTitle());
        holder.itemView.setOnClickListener(view -> {
            AppConstant.saleTypeId = typeResponse.getId();
            ((MainPage) context).displayView(CATEGORY_PAGE);
        });
    }

    @Override
    public int getItemCount() {
        return sale_typeList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView titleTypeSale;

        public VH(@NonNull View itemView) {
            super(itemView);
            titleTypeSale = itemView.findViewById(R.id.titleTypeSale);
        }
    }
}
