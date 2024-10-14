package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductsDisplay extends AppCompatActivity {

    private ListView listViewProducts;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_display);

        listViewProducts = findViewById(R.id.list_view_products);
        Button buttoncard = findViewById(R.id.btn_Card);
        databaseHelper = new DatabaseHelper(this);

        displayProducts();

        buttoncard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the Update button click
                handlecard();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the displayed products
        displayProducts();
    }
    private void displayProducts() {
        Cursor cursor = databaseHelper.getAllProducts();
        ProductAdapter adapter = new ProductAdapter(this, cursor, 0);
        listViewProducts.setAdapter(adapter);
    }

    private void handlecard()
    {
        Intent intent = new Intent(ProductsDisplay.this, CardActivity.class); // Assuming HomeActivity is the activity after login
        startActivity(intent);
    }

}