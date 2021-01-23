package com.mazad.Diana.gui.main_page;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.mazad.Diana.R;
import com.mazad.Diana.base_class.BaseActivity;
import com.mazad.Diana.gui.category.CategoryFragment;
import com.mazad.Diana.gui.sale_type.SaleTypeFragment;
import com.mazad.Diana.utels.FragmentHandler;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.mazad.Diana.utels.AppKey.CATEGORY_PAGE;
import static com.mazad.Diana.utels.AppKey.SALE_TYPE_PAGE;
import static com.mazad.Diana.utels.FragmentHandler.selectedPosition;

public class MainPage extends BaseActivity {
    Bundle bundle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        ButterKnife.bind(this);
        displayView(SALE_TYPE_PAGE);
    }

    public void displayView(int position) {
        switch (position) {
            case SALE_TYPE_PAGE:
                FragmentHandler.displayView(SALE_TYPE_PAGE, this, new SaleTypeFragment(), R.id.containerAppFragment);
                break;
            case CATEGORY_PAGE:
                FragmentHandler.displayView(CATEGORY_PAGE, this, new CategoryFragment(), R.id.containerAppFragment);
                break;
        }
    }

    //setbundle
    public void SetBundle(Bundle bundle, int View_page) {
        this.bundle = bundle;
        displayView(View_page);
    }

    @Override
    public void onBackPressed() {
        selectedPosition = FragmentHandler.getSelectPoistion();
        if (selectedPosition==SALE_TYPE_PAGE){
            finish();
        }else if (selectedPosition==CATEGORY_PAGE){
            displayView(SALE_TYPE_PAGE);
        }else {
            super.onBackPressed();
        }

    }

}
