package com.raw.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    float  amount,interest,year,ans,final_r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edamount,edint,edyear;
        TextView tvint,tvpri,tvtotal;
        Button breset,bcal;

        edamount = findViewById(R.id.edamount);
        edint = findViewById(R.id.edint);
        edyear = findViewById(R.id.edyear);

        tvint = findViewById(R.id.tvint);
        tvpri = findViewById(R.id.tvpri);
        tvtotal = findViewById(R.id.tvtotal);

        breset = findViewById(R.id.breset);
        bcal = findViewById(R.id.bcal);

        bcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                amount = Float.parseFloat(edamount.getText().toString());
                interest = Float.parseFloat(edint.getText().toString());
                year = Float.parseFloat(edyear.getText().toString());

                interest = interest/(12*100);

                final_r = 1.0f;
                for (int i = 0; i < year*12; i++) {
                    final_r = final_r*(1+interest);
                }

                ans = amount*interest*(final_r/(final_r-1));

                DecimalFormat d = new DecimalFormat("0.##");

                tvint.setText(""+ans);
                tvpri.setText(""+(amount+ans));
                tvtotal.setText("Monthly Payment :"+(amount+ans)/(year*12));

            }
        });
        breset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvint.setText("");
                tvpri.setText("");
                tvtotal.setText("");
                edamount.setText("");
                edint.setText("");
                edyear.setText("");
            }
        });
    }
}