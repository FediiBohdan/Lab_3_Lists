package com.example.lab_3_lists;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        // Getting data from the ListViewActivity
        String[][] data = null;
        Object[] objectArray = (Object[]) Objects.requireNonNull(getIntent().getExtras()).getSerializable("data");
        if (objectArray != null){
            data = new String[objectArray.length][];
            for (int i = 0; i < objectArray.length; i++)
                data[i]=(String[]) objectArray[i];
        }

        RecyclerView rv = findViewById(R.id.recycler);
        rv.setHasFixedSize(true);

        // Configuring RecyclerView with the layout manager and passing an adapter object to a list widget
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);
        rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL));
        rv.setAdapter(new MyAdapter(this, data));

        // Switching to ListView list
        findViewById(R.id.switchButton).setOnClickListener(v -> {
            Intent intent = new Intent(RecyclerViewActivity.this, ListViewActivity.class);
            startActivity(intent);
            finish();
        });
    }

    static class MyAdapter extends RecyclerView.Adapter<MyAdapter.MachineViewHolder> {
        String[][] data;

        MyAdapter(Context context, String[][] data) {
            this.data = data;
        }

        // Specifying and filling out the layout for each RecyclerView element
        @NonNull
        @Override
        public MachineViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_item, viewGroup, false);
            return new MachineViewHolder(v);
        }

        // Defining the contents of each item from a RecyclerView
        @Override
        public void onBindViewHolder(@NonNull MachineViewHolder MachineViewHolder, int i) {
            MachineViewHolder.brand.setText(data[i][0]);
            MachineViewHolder.model.setText(data[i][1]);
            MachineViewHolder.year.setText(data[i][2]);
            MachineViewHolder.description.setText(data[i][3]);
        }

        @Override
        public int getItemCount() {
            return data.length;
        }

        static class MachineViewHolder extends RecyclerView.ViewHolder {
            TextView brand, model, year, description;

            MachineViewHolder(@NonNull final View itemView) {
                super(itemView);
                brand = itemView.findViewById(R.id.brand);
                model = itemView.findViewById(R.id.model);
                year = itemView.findViewById(R.id.year);
                description = itemView.findViewById(R.id.description);

                // List item selection
                itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(v.getContext(), MachineViewActivity.class);
                    intent.putExtra("brand", brand.getText().toString());
                    intent.putExtra("model", model.getText().toString());
                    intent.putExtra("year", year.getText().toString());
                    intent.putExtra("description", description.getText().toString());
                    v.getContext().startActivity(intent);
                });
            }
        }
    }
}


