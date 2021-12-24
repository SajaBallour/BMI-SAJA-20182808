package com.saja.bmianalyzerproject.OOP;

import java.util.ArrayList;

public class User {
    private final ArrayList<BMIRecord> records;

    public User(){
        this.records= new ArrayList<>();
        records.add(new BMIRecord("4/12/2000", "Normal",155,60));
        records.add(new BMIRecord("4/12/2000", "Normal",155,60));
        records.add(new BMIRecord("4/12/2000", "Normal",155,60));
        records.add(new BMIRecord("4/12/2000", "Normal",155,60));

    }
    public ArrayList<BMIRecord> getRecords(){
        return records;
    }
}
