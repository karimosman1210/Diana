package com.mazad.Diana.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mazad.Diana.R;
import com.mazad.Diana.data.BookListResponse;
import com.mazad.Diana.data.Dropdownlistid;
import com.mazad.Diana.data.dialogData.DialogListener;
import com.mazad.Diana.data.dialogData.DialogPoP;
import com.mazad.Diana.utels.AppConstant;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.mazad.Diana.utels.AppKey.Un_approved;
import static com.mazad.Diana.utels.AppKey.approved;

public class MyBookListAdapter extends RecyclerView.Adapter<MyBookListAdapter.VH> {
    List<BookListResponse> bookList;
    Context context;
    ConfermInterface confermInterface;
    public MyBookListAdapter(List<BookListResponse> bookList, Context context,ConfermInterface confermInterface) {
        this.bookList = bookList;
        this.context = context;
        this.confermInterface=confermInterface ;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_add_book_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        BookListResponse booked = bookList.get(position);
        holder.boonkedNumber.setText(booked.getNumberProducts());
        holder.dateBookTv.setText(booked.getTimePublish());
        holder.nameUserBookTv.setText(booked.getUser().getFirstName());
        Picasso.get().load(AppConstant.BASE_IMAGE +booked.getUser().getImage()).into(holder.userImageCv);
        if (booked.getApproved().equals(Un_approved)) {
            holder.confermBookBtn.setVisibility(View.VISIBLE);
            holder.successBookBtn.setVisibility(View.GONE);

        } if (booked.getApproved().equals(approved)){
            holder.confermBookBtn.setVisibility(View.GONE);
            holder.successBookBtn.setVisibility(View.VISIBLE);
        }
        holder.confermBookBtn.setOnClickListener(v -> {
            new DialogPoP.Builder(context)
                    .setTitle(context.getString(R.string.attintion))
                    .setMessage(context.getString(R.string.need_conoferm))
                    .setNegativeBtnText(context.getString(R.string.no))
                    .setPositiveBtnText(context.getString(R.string.yes))
                    .isCancellable(true)
                    .OnPositiveClicked(new DialogListener() {
                        @Override
                        public void OnClick() {
                            confermInterface.clickConfermBook(booked);

                        }
                    })
                    .OnNegativeClicked(new DialogListener() {
                        @Override
                        public void OnClick() {

                        }
                    })
                    .build();

        });

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView nameUserBookTv, boonkedNumber, dateBookTv;
        Button confermBookBtn, successBookBtn;
        CircleImageView userImageCv;
        public VH(@NonNull View itemView) {
            super(itemView);
            nameUserBookTv = itemView.findViewById(R.id.nameUserBookTv);
            boonkedNumber = itemView.findViewById(R.id.boonkedNumber);
            dateBookTv = itemView.findViewById(R.id.dateBookTv);
            confermBookBtn = itemView.findViewById(R.id.confermBookBtn);
            successBookBtn = itemView.findViewById(R.id.successBookBtn);
            userImageCv = itemView.findViewById(R.id.userImageCv);
        }
    }
    public interface ConfermInterface{
        void clickConfermBook(BookListResponse booked);
    }
}
