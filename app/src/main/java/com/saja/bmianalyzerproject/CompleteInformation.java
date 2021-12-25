package com.saja.bmianalyzerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class CompleteInformation extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    Timer t;
    EditText editWeight,length,editDataBirth;
    ImageView minusWeight,PlusWeight,MinusLength,PluseLength;
    Button Save;
    int Year ,Month,Day,Hour, Minute;
    int UserYear, UserMonth,UserDay, UserHour, UserMinute;
    RadioGroup gender;
    RadioButton RadioButton;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_information);
        //addListenerOnButton();

        PluseLength=findViewById(R.id.PluseLength);
        MinusLength=findViewById(R.id.MinusLength);
        PlusWeight=findViewById(R.id.plus_weight);
        minusWeight=findViewById(R.id.minus_weight);
        editDataBirth=findViewById(R.id.editDataBirth);
        gender=findViewById(R.id.gender);
       // RadioButton=findViewById(R.id.Male);
        //Female=findViewById(R.id.Female);
        Save=findViewById(R.id.Save);
        gender=findViewById(R.id.gender);

        PlusWeight.setOnClickListener(view ->{plusweight();});
        minusWeight.setOnClickListener(view ->{ minusWeight(); });
        PluseLength.setOnClickListener(view ->{plusLength();});
        MinusLength.setOnClickListener(view ->{minusLength(); });

        Calendar calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DAY_OF_MONTH);
        editDataBirth.setOnClickListener(v -> {
            DatePickerDialog date = new DatePickerDialog(CompleteInformation.this, CompleteInformation.this, Year, Month, Day);date.show(); });
        /*gender.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            int radioId = gender.getCheckedRadioButtonId();

                            RadioButton = findViewById(radioId);

                        }
                    });*/

        Save.setOnClickListener(view -> { startActivity(new Intent(CompleteInformation.this,Home.class));});

        /*t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(CompleteInformation.this, Home.class);
                startActivity(intent);
                finish();
            }
        },5000);*/
    }
    /*
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Male:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.Female:

        }
    }*/
    /*
    public void addListenerOnButton() {
        radioSexGroup = (LinearLayout) findViewById(R.id.radioSex);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
// get selected radio button from radioGroup
                int selectedId = radioSexGroup.getChecked();
// find the radiobutton by returned id
                radioSexButton = (LinearLayout) findViewById(selectedId);

                Toast.makeText(CompleteInformation.this, radioSexButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });}*/

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        UserYear = year;
        UserMonth = month;
        UserDay = day;
        String UserDate = UserYear+"-"+UserMonth+"-"+UserDay;
        editDataBirth.setText( UserDate );
    }

    private void plusLength() {
        i = i + 1;
        displayplusLength(i);

    }
    private void displayplusLength(int number) {
        length=findViewById(R.id.Length);
        length.setText("" + number);

    }
    private void minusLength() {
        i = i - 1;
        displayminusLength(i);

    }
    private void displayminusLength(int number) {
        length=findViewById(R.id.Length);
        length.setText("" + number);

    }

    private void plusweight() {
        i = i + 1;
        displayplusweight(i);

    }
    private void displayplusweight(int number) {
        editWeight=findViewById(R.id.weight);
        editWeight.setText("" + number);

    }
    private void minusWeight() {
        i = i - 1;
        displayminusWeight(i);

    }
    private void displayminusWeight(int number) {
        editWeight=findViewById(R.id.weight);
        editWeight.setText("" + number);

    }
}