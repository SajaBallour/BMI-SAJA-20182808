package com.saja.bmianalyzerproject.OOP;

import static android.os.Build.VERSION_CODES.R;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.protobuf.StringValue;
import com.saja.bmianalyzerproject.R;

public class Holder extends RecyclerView.ViewHolder {
    private final TextView date;
    private final TextView Status;
    private final TextView length;
    private final TextView weight;
    private BMIRecord record;
    //private view;
    public Holder(@NonNull View itemView) {
        super(itemView);
        this.date = itemView.findViewById(com.saja.bmianalyzerproject.R.id.date);
        this.Status = itemView.findViewById(com.saja.bmianalyzerproject.R.id.status);
        this.length =itemView.findViewById(com.saja.bmianalyzerproject.R.id.length);
        this.weight=itemView.findViewById(com.saja.bmianalyzerproject.R.id.weight);
    }



    public void setBMIRecord (BMIRecord record){
        this.record=record;
        date.setText(record.getDate());
        Status.setText(record.getStatus());
        weight.setText(String.valueOf(record.getWeight()));
        length.setText(String.valueOf(record.getLength()));
    }

}
