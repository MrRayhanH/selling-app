package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_card);

        Button Payment = findViewById(R.id.btn_payment);
        TextView Price, TotalProduct;

        Price = findViewById(R.id.tv_total_price);
        TotalProduct = findViewById(R.id.tv_total_product);


        Payment.setOnClickListener(v -> {
            Toast.makeText(CardActivity.this, " Payment Done"+Price+"/n"+TotalProduct+"/n",Toast.LENGTH_SHORT).show();
        });

    }
}