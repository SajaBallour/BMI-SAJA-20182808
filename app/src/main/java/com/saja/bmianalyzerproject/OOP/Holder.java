package com.saja.bmianalyzerproject.OOP;

import static android.os.Build.VERSION_CODES.R;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.protobuf.StringValue;
import com.saja.bmianalyzerproject.R;

public class Holder extends RecyclerView.ViewHolder {
    TextView date;
    TextView Status;
    TextView length;
    TextView weight;
    BMIRecord record;
    Context context;

    public Holder(@NonNull View itemView) {
        super(itemView);
        date = itemView.findViewById(com.saja.bmianalyzerproject.R.id.date);
        Status = itemView.findViewById(com.saja.bmianalyzerproject.R.id.status);
        length =itemView.findViewById(com.saja.bmianalyzerproject.R.id.length);
        weight=itemView.findViewById(com.saja.bmianalyzerproject.R.id.weight);
        context = itemView.getContext();
    }



    public void setBMIRecord (BMIRecord record){
        this.record=record;
        date.setText(record.getDate());
        Status.setText(record.getStatus());
        weight.setText(String.valueOf(record.getWeight()));
        length.setText(String.valueOf(record.getLength()));
    }

}
