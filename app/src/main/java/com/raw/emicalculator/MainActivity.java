package com.raw.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    float  amount=0,interest=0,year=0,m,ans,r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edamount,edint,edyear;
        TextView tvint,tvpri,tvtotal,tvemi;
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

                m = year*12;
                r = interest/12;

                ans = (amount*r)/100;

                tvint.setText(""+ans);
                tvpri.setText(""+amount);

                DecimalFormat d = new DecimalFormat("0.##");

                tvtotal.setText(""+amount+" + "+ans+" = "+(amount+ans)+"\nMonth Payment = "+((amount+ans)/m));
            }
        });
        breset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount=0;
                interest=0;
                year=0;
                m=0;
                ans=0;
                r=0;

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