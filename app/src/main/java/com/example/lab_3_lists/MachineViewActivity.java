package com.example.lab_3_lists;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MachineViewActivity extends AppCompatActivity {

    // Showing information of the selected list item
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine);

        TextView brand = findViewById(R.id.brand);
        TextView model = findViewById(R.id.model);
        TextView year = findViewById(R.id.year);
        TextView description = findViewById(R.id.description);

        String[] data = new String[4];
        data[0] = getIntent().getStringExtra("brand");
        data[1] = getIntent().getStringExtra("model");
        data[2] = getIntent().getStringExtra("year");
        data[3] = getIntent().getStringExtra("description");

        brand.setText(data[0]);
        model.setText(data[1]);
        year.setText(data[2]);
        description.setText(data[3]);

        findViewById(R.id.backButton).setOnClickListener(v -> {
            finish();
        });
    }
}


