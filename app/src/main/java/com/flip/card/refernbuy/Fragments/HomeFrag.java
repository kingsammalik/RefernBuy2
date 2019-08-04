package com.flip.card.refernbuy.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.flip.card.refernbuy.Activites.MainActivity;
import com.flip.card.refernbuy.R;
import com.flip.card.refernbuy.adapters.RecyclerViewDataAdapter;
import com.flip.card.refernbuy.models.SectionDataModel;
import com.flip.card.refernbuy.models.SingleItemModel;
import com.liuzhuang.afgridlayout.AutoFitGridLayout;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFrag extends Fragment {
    SliderLayout sliderLayout;
    ArrayList<SectionDataModel> allSampleData;
    AutoFitGridLayout autoFitGridLayout;


    public HomeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        sliderLayout = view.findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.SWAP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(2); //set scroll delay in seconds :
        setSliderViews();

        allSampleData = new ArrayList<SectionDataModel>();


        createDummyData();


        RecyclerView my_recycler_view = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        autoFitGridLayout = (AutoFitGridLayout)view.findViewById(R.id.grid);

        autoFitGridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                CategoryListing categoryListing = new CategoryListing();
                transaction.replace(R.id.main_fragment_container, categoryListing).commit();
            }
        });

        my_recycler_view.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(getActivity(), allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);

        return view;
    }


    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(getActivity());

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.sss);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.zzz);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.shooping);
                    break;
                case 3:
                    sliderView.setImageUrl("https://mondrian.mashable.com/uploads%252Fcard%252Fimage%252F847067%252F995c27df-12fb-4cba-b2bc-59235461a038.jpg%252F950x534__filters%253Aquality%252890%2529.jpg?signature=127DmNBGJdzDipgpMWWAnPtN-6M=&source=https%3A%2F%2Fblueprint-api-production.s3.amazonaws.com");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("The quick brown fox jumps over the lazy dog.\n" +
                    "Jackdaws love my big sphinx of quartz. " + (i + 1));
            final int finalI = i;

            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(getActivity(), "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();

                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }

    }

    public void createDummyData() {
        for (int i = 1; i <= 1; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("Flash Sale" + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("₹ 200 ", "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
    }

}
