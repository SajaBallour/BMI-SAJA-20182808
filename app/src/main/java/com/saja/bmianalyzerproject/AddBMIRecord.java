package com.saja.bmianalyzerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;


import java.util.Calendar;
import java.util.Timer;

public class AddBMIRecord extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    Timer t;
    EditText weight,Length,Date,Time;
    ImageView arrow,plus_length,plus_weight,minusLength,minusWeight;
    Button save;
    int UserYear, UserMonth,UserDay, UserHour, UserMinute;
    int Year ,Month,Day,Hour, Minute;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bmirecord);

        arrow=findViewById(R.id.arrow);
        plus_length=findViewById(R.id.plus_length);
        minusLength=findViewById(R.id.minus_length);
        plus_weight=findViewById(R.id.plus_weight);
        minusWeight=findViewById(R.id.minus_weight);
        Date=findViewById(R.id.date);
        Time=findViewById(R.id.time);
        save=findViewById(R.id.save);

        arrow.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Home.class)));
        save.setOnClickListener(view -> { startActivity(new Intent(AddBMIRecord.this,Home.class));});
        plus_weight.setOnClickListener(view ->{plusweight();});
        minusWeight.setOnClickListener(view ->{ minusWeight(); });
        plus_length.setOnClickListener(view ->{plusLength();});
        minusLength.setOnClickListener(view ->{minusLength(); });

        Calendar calendar = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);
        Hour = c.get(Calendar.HOUR);
        Minute = c.get(Calendar.MINUTE);

        Date.setOnClickListener(v -> {
            DatePickerDialog date = new DatePickerDialog(AddBMIRecord.this, AddBMIRecord.this, Year, Month, Day);date.show(); });

        Time.setOnClickListener(v -> {
            TimePickerDialog time= new TimePickerDialog(AddBMIRecord.this, AddBMIRecord.this, Hour, Minute, DateFormat.is24HourFormat(AddBMIRecord.this));time.show(); });

    }
    public void onDateSet(DatePicker view, int year, int month, int day) {
        UserYear = year;
        UserMonth = month;
        UserDay = day;
        String UserDate = UserYear+"-"+UserMonth+"-"+UserDay;
        Date.setText( UserDate );
    }
    public void onTimeSet(TimePicker view, int hour, int minute) {
        UserHour = hour;
        UserMinute = minute;
        String UserTime = UserHour+":"+UserMinute;
        Time.setText(UserTime );
    }

   private void plusLength() {
       i = i + 1;
       displayplusLength(i);

    }
    private void displayplusLength(int number) {
        Length=findViewById(R.id.Length);
        Length.setText("" + number);

    }
    private void minusLength() {
        i = i - 1;
        displayminusLength(i);

    }
    private void displayminusLength(int number) {
        Length=findViewById(R.id.Length);
        Length.setText("" + number);

    }

    private void plusweight() {
        i = i + 1;
        displayplusweight(i);

    }
    private void displayplusweight(int number) {
        weight=findViewById(R.id.weight);
        weight.setText("" + number);

    }
    private void minusWeight() {
        i = i - 1;
        displayminusWeight(i);

    }
    private void displayminusWeight(int number) {
        weight=findViewById(R.id.weight);
        weight.setText("" + number);

    }

       /* t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(AddBMIRecord.this, Add_Food_details.class);
                startActivity(intent);
                finish();
            }
        },5000);*/
}