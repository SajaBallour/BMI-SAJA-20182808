package com.saja.bmianalyzerproject.OOP;

public class BMIRecord {
    String date;
    String Status;
    int length;
    int weight;
    private String id;

    public BMIRecord(String date,String Status, int weight, int length) {
        this.date= date;
        this.Status= Status;
        this.length= length;
        this.weight= weight;
    }
    public BMIRecord(){}
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
