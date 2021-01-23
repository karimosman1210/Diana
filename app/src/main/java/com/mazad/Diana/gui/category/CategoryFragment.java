package com.mazad.Diana.gui.category;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mazad.Diana.R;
import com.mazad.Diana.adapter.CategoryAdapter;
import com.mazad.Diana.adapter.MySliderAdapter;
import com.mazad.Diana.base_class.BaseFragment;
import com.mazad.Diana.data.CategoriesResponse;
import com.mazad.Diana.data.Sale_typeResponse;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.DummyData;
import com.mazad.Diana.utels.utels.ToastUtil;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.mazad.Diana.utels.AppConstant.catList;
import static com.mazad.Diana.utels.AppKey.TYPE_SALE;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends BaseFragment implements CategoryView {
    @BindView(R.id.imageSlider)
    SliderView imageSlider ;
    @BindView(R.id.recyclerCat)
    RecyclerView recyclerCat ;
    CategoryAdapter categoryAdapter ;
    MySliderAdapter sliderAdapter ;
    CategoryPresenter presenter;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this, view);
        initVaribles();
        return view;
    }

    private void initVaribles() {
        presenter=new CategoryPresenter();
        presenter.attachView(this);
        if (catList==null){
            presenter.MyCliantsData(getContext());
        }else {
            categoryAdapter=new CategoryAdapter(catList,getContext());
            recyclerCat.setAdapter(categoryAdapter);
        }
        recyclerCat.setLayoutManager(new LinearLayoutManager(getContext()));
        sliderAdapter=new MySliderAdapter(getContext(), DummyData.listSLider());
        imageSlider.setSliderAdapter(sliderAdapter);
    }

    @Override
    public void categoryList(List<CategoriesResponse> responseList) {
        catList=responseList;
        categoryAdapter=new CategoryAdapter(catList,getContext());
        recyclerCat.setAdapter(categoryAdapter);
    }
}
