package com.example.travelmate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class HireGuideAdapter extends RecyclerView.Adapter<HireGuideViewHolder> { //Need to Change

    private Context context;
    private List<HireGuideDataClass> dataList;//Change

    // Constructor for dataList
    public HireGuideAdapter(Context context, List<HireGuideDataClass> dataList) {//Change
        this.context = context;
        this.dataList = dataList;
    }

    //Implement methods
    @NonNull
    @Override
    public HireGuideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//Change
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guide_recycler_item, parent, false);// Change
        return new  HireGuideViewHolder(view);//Need to Change
    }
    //get data and put to the xml
    @Override
    public void onBindViewHolder(@NonNull  HireGuideViewHolder holder, int position) {//Change
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recDesc.setText(dataList.get(position).getDataDesc());
        holder.recLang.setText(dataList.get(position).getDataLang());
        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Hire_Guide_Details.class);//Change
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Description", dataList.get(holder.getAdapterPosition()).getDataDesc());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Key",dataList.get(holder.getAdapterPosition()).getKey());
                intent.putExtra("Language", dataList.get(holder.getAdapterPosition()).getDataLang());
                context.startActivity(intent);
            }
        });
    }
    //return typ
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public void searchDataList(ArrayList<HireGuideDataClass> searchList){//Need to Change
        dataList = searchList;
        notifyDataSetChanged();
    }
}

// Recycle View id pass to get value from recycler_item XML
class HireGuideViewHolder extends RecyclerView.ViewHolder{// Change
    ImageView recImage;
    TextView recTitle, recDesc, recLang;
    CardView recCard;
    public HireGuideViewHolder(@NonNull View itemView) {// Change
        super(itemView);
        recImage = itemView.findViewById(R.id.GuiderecImage); // Change
        recCard = itemView.findViewById(R.id.GuiderecCard);//Change
        recDesc = itemView.findViewById(R.id.GuiderecDesc);// Change
        recLang = itemView.findViewById(R.id.GuiderecLang);// Change
        recTitle = itemView.findViewById(R.id.GuiderecTitle);// Change
    }
}
