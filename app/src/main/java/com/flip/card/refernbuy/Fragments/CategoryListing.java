package com.flip.card.refernbuy.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flip.card.refernbuy.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryListing extends Fragment {


    public CategoryListing() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category_listing, container, false);
    }

}
