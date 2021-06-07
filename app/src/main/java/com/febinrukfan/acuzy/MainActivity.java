package com.febinrukfan.acuzy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_Cpwdrate,edt_Depriciation,edt_Age,edt_Area;
    TextView txt_Rate,txt_Value,txt_Developer;
    Button btn_Getvalue;
    CheckBox chk_1542,chk_1812,chk_2116,chk_2482;

    Double cpwRate=0.0,dep,age,area;
    boolean any,onefive,oneeight,twoone,twofour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intit();


        clickmethodes();
    }

    private void clickmethodes() {


        edt_Cpwdrate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!edt_Cpwdrate.getText().toString().isEmpty()){
                    any=true;
                    onefive = false;
                    oneeight = false;
                    twoone = false;
                    twofour = false;
                }else {
                    any=false;
                }
                set_cpwdrate();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        chk_1542.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(chk_1542.isChecked()){
                    any=false;
                    onefive = true;
                    oneeight = false;
                    twoone = false;
                    twofour = false;
                }else {
                    onefive=false;
                }
                set_cpwdrate();
            }
        });

       chk_1812.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(chk_1812.isChecked()){
                    any=false;
                    onefive = false;
                    oneeight = true;
                    twoone = false;
                    twofour = false;

                }else {
                    oneeight=false;
                }
                set_cpwdrate();
            }
        });

       chk_2116.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(chk_2116.isChecked()){
                    any=false;
                    onefive = false;
                    oneeight = false;
                    twoone = true;
                    twofour = false;
                }else {
                    twoone=false;
                }
                set_cpwdrate();
            }
        });

       chk_2482.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(chk_2482.isChecked()){
                    any=false;
                    onefive = false;
                    oneeight = false;
                    twoone = false;
                    twofour = true;
                }else {
                    twofour=false;
                }
                set_cpwdrate();
            }
        });



        btn_Getvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cpwRate==0.0){
                  Toast.makeText(getApplicationContext(),"Enter CPWD Rate",Toast.LENGTH_SHORT).show();
                }else if(edt_Depriciation.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Depreciation",Toast.LENGTH_SHORT).show();

                }else if(Integer.parseInt(edt_Depriciation.getText().toString()) > 15){
                    Toast.makeText(getApplicationContext(),"Depreciation must be between 1 & 15",Toast.LENGTH_SHORT).show();

                }else if(edt_Age.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Age of building",Toast.LENGTH_SHORT).show();

                }else if(Integer.parseInt(edt_Age.getText().toString()) > 60){
                    Toast.makeText(getApplicationContext(),"Age must be between 0 & 60",Toast.LENGTH_SHORT).show();

                }else if(edt_Area.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Area",Toast.LENGTH_SHORT).show();

                }else {
                    calculate();

                }

            }
        });

        txt_Developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browser= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/febinrukfan/"));
                startActivity(browser);
            }
        });


    }


    private  void set_cpwdrate(){



        if (any){

            Log.v("any",any+"");
            onefive=false;
            oneeight=false;
            twoone=false;
            twofour=false;


            chk_1542.setChecked(false);
            chk_1812.setChecked(false);
            chk_2116.setChecked(false);
            chk_2482.setChecked(false);

            cpwRate = Double.valueOf(edt_Cpwdrate.getText().toString());


        }else if(onefive)
        {
            any=false;
            oneeight=false;
            twoone=false;
            twofour=false;

            edt_Cpwdrate.getText().clear();

            chk_1812.setChecked(false);
            chk_2116.setChecked(false);
            chk_2482.setChecked(false);

            cpwRate = 1542d;

         }else if(oneeight)
        {
            any=false;
            onefive=false;
            twoone=false;
            twofour=false;

            edt_Cpwdrate.getText().clear();

            chk_1542.setChecked(false);
            chk_2116.setChecked(false);
            chk_2482.setChecked(false);

            cpwRate = 1812d;

         }else if(twoone)
        {

            any=false;
            onefive=false;
            oneeight=false;
            twofour=false;

            edt_Cpwdrate.getText().clear();

            chk_1542.setChecked(false);
            chk_1812.setChecked(false);
            chk_2482.setChecked(false);

            cpwRate = 2116d;

        }else if(twofour){


            any=false;
            onefive=false;
            oneeight=false;
            twoone=false;

            edt_Cpwdrate.getText().clear();

            chk_1542.setChecked(false);
            chk_1812.setChecked(false);
            chk_2116.setChecked(false);

            cpwRate = 2482d;

        }else{

            cpwRate = 0.0;
        }


    }

    @SuppressLint("SetTextI18n")
    private void calculate() {

        dep = Double.valueOf(edt_Depriciation.getText().toString());
        age = Double.valueOf(edt_Age.getText().toString());
        area = Double.valueOf(edt_Area.getText().toString());


        Double rate,build_value;

        rate = 100-dep;
        rate= rate/100;

        rate = (double) Math.pow(rate, age);

        rate = cpwRate*rate;

        rate = (double) Math.round(rate);

        txt_Rate.setText(""+(int) Math.round(rate));

        build_value = area*rate;

        txt_Value.setText(""+(int) Math.round(build_value));


    }

    private void intit() {

        edt_Cpwdrate = (EditText) findViewById(R.id.edt_cpwdrate);
        edt_Depriciation = (EditText) findViewById(R.id.edt_depriciation);
        edt_Age = (EditText) findViewById(R.id.edt_age);
        edt_Area = (EditText) findViewById(R.id.edt_area);
        txt_Rate = (TextView) findViewById(R.id.txt_rate);
        txt_Value = (TextView) findViewById(R.id.txt_value);
        txt_Developer = (TextView) findViewById(R.id.txt_developer);
        txt_Developer.setPaintFlags(txt_Developer.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_Getvalue = (Button) findViewById(R.id.btn_getvalue);
        chk_1542 = (CheckBox) findViewById(R.id.chk_1542);
        chk_1812 = (CheckBox) findViewById(R.id.chk_1812);
        chk_2116 = (CheckBox) findViewById(R.id.chk_2116);
        chk_2482 = (CheckBox) findViewById(R.id.chk_2482);

    }
}