package com.flip.card.refernbuy.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.flip.card.refernbuy.Activites.ProductDetailActivity;
import com.flip.card.refernbuy.R;
import com.flip.card.refernbuy.interfaces.IOnBackPressed;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryListing extends Fragment implements IOnBackPressed {

    ImageView imageView;
    boolean myCondition = true;


    public CategoryListing() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category_listing, container, false);


        imageView = view.findViewById(R.id.product);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }


    @Override
    public boolean onBackPressed() {

        if (myCondition) {
            //action not popBackStack
            return true;
        } else {
            return false;
        }
    }
}
