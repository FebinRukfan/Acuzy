package com.febinrukfan.acuzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_Xvalue,edt_Yvalue;
    TextView txt_Value,txt_Developer;
    Button btn_Getvalue;
    CheckBox chk_Optional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intit();
        clickmethodes();
    }

    private void clickmethodes() {

        btn_Getvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edt_Xvalue.getText().toString().isEmpty()){
                  Toast.makeText(getApplicationContext(),"Enter X Value",Toast.LENGTH_SHORT).show();
                }else if(edt_Yvalue.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Y Value",Toast.LENGTH_SHORT).show();

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

    private void calculate() {

        float value = (1-Float.parseFloat(edt_Xvalue.getText().toString()));


        value = (float) Math.pow(value, Float.parseFloat(edt_Yvalue.getText().toString()));

        if(chk_Optional.isChecked()){
            value =2112*value;

        }else {
            value =1542*value;

        }

        txt_Value.setText(""+ value);
    }

    private void intit() {

        edt_Xvalue = (EditText) findViewById(R.id.edt_xvalue);
        edt_Yvalue = (EditText) findViewById(R.id.edt_yvalue);
        txt_Value = (TextView) findViewById(R.id.txt_value);
        txt_Developer = (TextView) findViewById(R.id.txt_developer);
        txt_Developer.setPaintFlags(txt_Developer.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_Getvalue = (Button) findViewById(R.id.btn_getvalue);
        chk_Optional = (CheckBox) findViewById(R.id.chk_optional);

    }
}