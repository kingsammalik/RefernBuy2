package com.flip.card.refernbuy.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flip.card.refernbuy.R;
import com.flip.card.refernbuy.models.BaseModel;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder>  {

    private List<BaseModel> categoryList;
    private CallBack callBack;
    private int selectedPosition=0;
    private Context context;

    public void setStatus(CallBack callBack){
        this.callBack=callBack;
    }

    public interface CallBack{
        public void onClick(int position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView category;
        public LinearLayout linear_layout;

        public MyViewHolder(View view) {
            super(view);
            category = view.findViewById(R.id.category);
            linear_layout = view.findViewById(R.id.linear_layout);
            linear_layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            selectedPosition = getAdapterPosition();
            notifyDataSetChanged();
            callBack.onClick(selectedPosition);
        }
    }


    public CategoryAdapter(List<BaseModel> categoryList,Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.category.setText(categoryList.get(holder.getAdapterPosition()).getName());


        if(selectedPosition==holder.getAdapterPosition()){
            holder.linear_layout.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        else
        {
            holder.linear_layout.setBackgroundColor(context.getResources().getColor(R.color.grey));
        }
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


}
