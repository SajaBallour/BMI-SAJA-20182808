package com.saja.bmianalyzerproject.OOP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saja.bmianalyzerproject.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Holder>{
    private ArrayList<BMIRecord> records;
    private Context context;

    public Adapter (ArrayList<BMIRecord> records, Context context) {
        this.records=records;
        this.context=context;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.element_bmi,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        BMIRecord record;
        record = records.get(position);
        holder.setBMIRecord(record);
    }

    @Override
    public int getItemCount() {
        return records.size();
    }



}
