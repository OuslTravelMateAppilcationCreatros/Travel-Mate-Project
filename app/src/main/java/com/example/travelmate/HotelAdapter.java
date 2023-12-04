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

public class HotelAdapter extends RecyclerView.Adapter<HotelViewHolder>{

    private Context context;
    private List<HotelDataClass> dataList;//Change

    // Constructor for dataList
    public HotelAdapter(Context context, List<HotelDataClass> dataList) {//Change
        this.context = context;
        this.dataList = dataList;
    }

    //Implement methods
    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//Change
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_recycler_item, parent, false);// Change
        return new  HotelViewHolder(view);//Need to Change
    }
    //get data and put to the xml
    @Override
    public void onBindViewHolder(@NonNull  HotelViewHolder holder, int position) {//Change
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recDesc.setText(dataList.get(position).getDataDesc());
        holder.recLang.setText(dataList.get(position).getDataLang());
        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Hotel_Details.class);//Change
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
    public void searchDataList(ArrayList<HotelDataClass> searchList){//Need to Change
        dataList = searchList;
        notifyDataSetChanged();
    }
}

// Recycle View id pass to get value from recycler_item XML
class HotelViewHolder extends RecyclerView.ViewHolder{// Change
    ImageView recImage;
    TextView recTitle, recDesc, recLang;
    CardView recCard;
    public HotelViewHolder(@NonNull View itemView) {// Change
        super(itemView);
        recImage = itemView.findViewById(R.id.HotelrecImage); // Change
        recCard = itemView.findViewById(R.id.HotelrecCard);//Change
        recDesc = itemView.findViewById(R.id.HotelrecDesc);// Change
        recLang = itemView.findViewById(R.id.HotelrecLang);// Change
        recTitle = itemView.findViewById(R.id.HotelrecTitle);// Change
    }
}
