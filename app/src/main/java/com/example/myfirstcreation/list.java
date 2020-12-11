package com.example.myfirstcreation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        this.arrayAdapterListView();
    }

    // This method use an ArrayAdapter to add data in ListView.
    private void arrayAdapterListView()
    {
        setTitle("MY HOBBIES");

        List<String> dataList = new ArrayList<String>();
        dataList.add("Swimming");
        dataList.add(" music");
        dataList.add("reading novels");
        dataList.add("time with friends");
        dataList.add("dancing");

        ListView listView = (ListView)findViewById(R.id.listViewExample);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, dataList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Object clickItemObj = adapterView.getAdapter().getItem(index);
                Toast.makeText(list.this, "You clicked " + clickItemObj.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
