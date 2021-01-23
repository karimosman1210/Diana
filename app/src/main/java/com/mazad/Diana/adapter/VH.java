package com.mazad.Diana.adapter;
import android.view.View;
import android.widget.ImageView;


import com.mazad.Diana.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class VH {

    public static class slidervH extends SliderViewAdapter.ViewHolder {
        public ImageView imageViewBackground;
        public View itemView;

        public slidervH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.imgeId);
            this.itemView = itemView;

        }
    }
}





