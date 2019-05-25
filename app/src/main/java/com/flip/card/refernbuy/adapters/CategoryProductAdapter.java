package com.flip.card.refernbuy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.flip.card.refernbuy.R;
import com.flip.card.refernbuy.models.BaseModel;

import java.util.List;

public class CategoryProductAdapter extends BaseAdapter {

    private LayoutInflater layoutinflater;
    private Context context;
    private List<BaseModel> customizedListView;

    public CategoryProductAdapter(Context context, List<BaseModel> customizedListView) {
        this.context = context;
        layoutinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.customizedListView = customizedListView;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder listViewHolder;
        if(view == null){
            listViewHolder = new ViewHolder();
            view = layoutinflater.inflate(R.layout.layout_single_subcategory, viewGroup, false);
            listViewHolder.textInListView = view.findViewById(R.id.sub_category);
            listViewHolder.imageInListView = view.findViewById(R.id.img_sub_category);
            view.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)view.getTag();
        }

        //listViewHolder.textInListView.setText(listStorage.get(position).getContent());
        //int imageResourceId = this.context.getResources().getIdentifier(listStorage.get(position).getImageResource(), "drawable", this.context.getPackageName());
        //listViewHolder.imageInListView.setImageResource(imageResourceId);

        return view;
    }

    static class ViewHolder{
        TextView textInListView;
        ImageView imageInListView;
    }

}
