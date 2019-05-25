package com.flip.card.refernbuy.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.flip.card.refernbuy.R;
import com.flip.card.refernbuy.adapters.CategoryAdapter;
import com.flip.card.refernbuy.adapters.CategoryProductAdapter;
import com.flip.card.refernbuy.models.BaseModel;
import com.liuzhuang.afgridlayout.AutoFitGridLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements CategoryAdapter.CallBack {


    public CategoryFragment() {
        // Required empty public constructor
    }

    private List<BaseModel> catList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CategoryAdapter mAdapter;
    private GridView gridLayout;
    private TextView  title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.layout_categories, container, false);

        List<BaseModel> allItems = new ArrayList<BaseModel>();
        title=view.findViewById(R.id.textView);
        recyclerView = view.findViewById(R.id.recycler_view);
        gridLayout = view.findViewById(R.id.gridlayout);
        CategoryProductAdapter customAdapter = new CategoryProductAdapter(getActivity(), allItems);
        gridLayout.setAdapter(customAdapter);
        mAdapter = new CategoryAdapter(catList,getActivity());
        mAdapter.setStatus(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();

        return view;
    }

    private void prepareMovieData() {

        catList.add(new BaseModel("1","Shoes"));
        catList.add(new BaseModel("1","Clothing"));
        catList.add(new BaseModel("1","Bag"));
        catList.add(new BaseModel("1","Luggage"));
        catList.add(new BaseModel("1","Watch"));
        catList.add(new BaseModel("1","Jewellary"));
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(int position) {

        Log.e("tga","position "+position);
        title.setText("Women's "+catList.get(position).getName());
    }
}
