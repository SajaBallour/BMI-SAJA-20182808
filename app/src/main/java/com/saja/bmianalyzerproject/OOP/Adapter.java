package com.saja.bmianalyzerproject.OOP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saja.bmianalyzerproject.R;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Holder> {
    private ArrayList<BMIRecord> records;
    private Context context;

    public Adapter (Context context, ArrayList<BMIRecord> records) {
        this.records=records;
        this.context = context;
    }
    // @NonNull
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_element_bmi,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        //holder.bindRestaurant(records.get(position));
        BMIRecord food;
        food = records.get(position);
        holder.setBMIRecord(food);
    }

    @Override
    public int getItemCount() {
        return records.size();
    }



}
