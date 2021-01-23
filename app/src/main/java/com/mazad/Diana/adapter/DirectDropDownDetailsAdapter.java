package com.mazad.Diana.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mazad.Diana.R;
import com.mazad.Diana.data.Dropdownlistid;

import java.util.List;

public class DirectDropDownDetailsAdapter extends RecyclerView.Adapter<DirectDropDownDetailsAdapter.VH> {
    List<Dropdownlistid> dropdownlistids ;
    Context context;

    public DirectDropDownDetailsAdapter(List<Dropdownlistid> dropdownlistids, Context context) {
        this.dropdownlistids = dropdownlistids;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drop_down_item, parent, false);
        return new VH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Dropdownlistid dropdownlistid=dropdownlistids.get(position);
        holder.valueTv.setText(dropdownlistid.getSubTitle().getTitle());
        holder.keyTv.setText(dropdownlistid.getMainTitle().getMainTitle());
    }

    @Override
    public int getItemCount() {
        if (dropdownlistids==null){
            return 0;
        }else {
            return dropdownlistids.size();

        }
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView keyTv,valueTv ;
        public VH(@NonNull View itemView) {
            super(itemView);
            keyTv=itemView.findViewById(R.id.keyTv);
            valueTv=itemView.findViewById(R.id.valueTv);

        }
    }
}
