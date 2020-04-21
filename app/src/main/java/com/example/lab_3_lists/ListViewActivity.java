package com.example.lab_3_lists;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Data generation
        String[][] data = new String[21][4];
        data[0][0] = "Mitsubishi"; data[0][1] = "Lancer X"; data[0][2] = "2011"; data[0][3] = "Надежный и экономичный автомобиль, произведен в Японии";
        data[1][0] = "Hummer"; data[1][1] = "H1"; data[1][2] = "2000"; data[1][3] = "Автомобиль с повышенным уровнем проходимости, произведен в США";
        data[2][0] = "Kia"; data[2][1] = "Cerato"; data[2][2] = "2008"; data[2][3] = "Надежный и экономичный автомобиль, произведен в Южной Кореи";
        data[3][0] = "Chevrolet"; data[3][1] = "Aveo"; data[3][2] = "2007"; data[3][3] = "Надежный и экономичный автомобиль, произведен в США";
        data[4][0] = "VW"; data[4][1] = "Passat B7"; data[4][2] = "2011"; data[4][3] = "Комфортабельный автомобиль по небольшой цене, произведен в Германии";
        data[5][0] = "Skoda"; data[5][1] = "Octavia"; data[5][2] = "2008"; data[5][3] = "Комфортабельный автомобиль по небольшой цене, произведен в Чехии";
        data[6][0] = "Toyota"; data[6][1] = "Camry"; data[6][2] = "2006"; data[6][3] = "Надежный и экономичный автомобиль, произведен в Японии";
        data[7][0] = "VW"; data[7][1] = "Polo Sedan"; data[7][2] = "2012"; data[7][3] = "Бюджетный автомобиль с небольшим расходом, произведен в Германии";
        data[8][0] = "Chevrolet"; data[8][1] = "Lacetti"; data[8][2] = "2005"; data[8][3] = "Комфортабельный автомобиль по небольшой цене, произведен в США";
        data[9][0] = "Land Rover"; data[9][1] = "Discovery 4"; data[9][2] = "2016"; data[9][3] = "Автомобиль с повышенным уровнем проходимости, произведен в Британии";
        data[10][0] = "Tesla"; data[10][1] = "Model S"; data[10][2] = "2018"; data[10][3] = "Современный электроавтомобиль, произведен в США";
        data[11][0] = "Nissan"; data[11][1] = "Almera N16"; data[11][2] = "1998"; data[11][3] = "Надежный и экономичный автомобиль, произведен в Японии";
        data[12][0] = "Ford"; data[12][1] = "Focus RS"; data[12][2] = "2018"; data[12][3] = "Бюджетный автомобиль с небольшим расходом, произведен в США";
        data[13][0] = "Audi"; data[13][1] = "100"; data[13][2] = "1994"; data[13][3] = "Бюджетный автомобиль с небольшим расходом, произведен в Германии";
        data[14][0] = "BMW"; data[14][1] = "M3"; data[14][2] = "2019"; data[14][3] = "Надежный и экономичный автомобиль, произведен в Германии";
        data[15][0] = "Renault"; data[15][1] = "Logan"; data[15][2] = "2011"; data[15][3] = "Бюджетный автомобиль с небольшим расходом, произведен во Франции";
        data[16][0] = "Mercedes"; data[16][1] = "GLC"; data[16][2] = "2017"; data[16][3] = "Автомобиль с повышенным уровнем проходимости, произведен в Германии";
        data[17][0] = "Jeep"; data[17][1] = "Grand Cherokee"; data[17][2] = "2019"; data[17][3] = "Автомобиль с повышенным уровнем проходимости, произведен в США";
        data[18][0] = "Honda"; data[18][1] = "Civiс"; data[18][2] = "2016"; data[18][3] = "Комфортабельный автомобиль по небольшой цене, произведен в Японии";
        data[19][0] = "Hyundai"; data[19][1] = "Sonata"; data[19][2] = "2015"; data[19][3] = "Бюджетный автомобиль с небольшим расходом, произведен в Южной Кореи";
        data[20][0] = "Citroen"; data[20][1] = "C5"; data[20][2] = "2013"; data[20][3] = "Надежный и экономичный автомобиль, произведен во Франции";

        // Creating an adapter object
        MyAdapter adapter = new MyAdapter(this, data);

        ListView list = findViewById(R.id.list);

        // Passing an adapter object to a list widget
        list.setAdapter(adapter);

        // List item selection
        list.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(ListViewActivity.this, MachineViewActivity.class);
            intent.putExtra("brand", data[position][0]);
            intent.putExtra("model", data[position][1]);
            intent.putExtra("year", data[position][2]);
            intent.putExtra("description", data[position][3]);
            startActivity(intent);
        });

        // Switching to RecyclerView list
        findViewById(R.id.switchButton).setOnClickListener(v -> {
            Intent intent = new Intent(ListViewActivity.this, RecyclerViewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("data",  data);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        });
    }

    public static class MyAdapter extends BaseAdapter {
        private String[][] data;
        private LayoutInflater inflater;

        MyAdapter(Context context, String[][] data) {
            this.data = data;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = inflater.inflate(R.layout.activity_item, parent, false); // Converting layout to object tree

            // Getting access to the object tree widgets
            TextView brand = convertView.findViewById(R.id.brand);
            TextView model = convertView.findViewById(R.id.model);
            TextView year = convertView.findViewById(R.id.year);
            TextView description = convertView.findViewById(R.id.description);

            // Changing the contents of widgets
            brand.setText(data[position][0]);
            model.setText(data[position][1]);
            year.setText(data[position][2]);
            description.setText(data[position][3]);

            // Returning of the modified tree of objects
            return convertView;
        }
    }
}


