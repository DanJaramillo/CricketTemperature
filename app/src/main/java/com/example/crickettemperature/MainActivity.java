package com.example.crickettemperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    EditText etChirps;
    Button btnCalcTemp;
    TextView tvOutputTemp;

    DecimalFormat df = new DecimalFormat("##0.#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirps = findViewById(R.id.etChirps);
        btnCalcTemp = findViewById(R.id.btnCalcTemp);
        tvOutputTemp = findViewById(R.id.tvOutputTemp);

        tvOutputTemp.setVisibility(View.GONE);

        btnCalcTemp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String cricketChirps = etChirps.getText().toString().trim();

                int chirps = Integer.parseInt(cricketChirps);

                double tempC = (double)chirps/3 + 4;
                double tempF = tempC * 9 / 5 + 32;

                String outputTempStr = getString(R.string.temperature_is) + "\n" + df.format(tempC) +
                        " C\n" + df.format(tempF) + " F";

                tvOutputTemp.setText(outputTempStr);

                tvOutputTemp.setVisibility(View.VISIBLE);
            }

        });
    }
}
