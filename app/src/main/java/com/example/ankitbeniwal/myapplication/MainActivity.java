package com.example.ankitbeniwal.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> batches;
    ArrayAdapter<String> batchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.mainListView);
        batches = new ArrayList<>();
        batches.add("Java 1");
        batches.add("Java 2");
        batches.add("C++ 1");
        batches.add("C++ 2");
        batches.add("Android 1");
//        for(int i = 1; i <= 20; i++){
//            batches.add("C++ 1");
//
//        }
        batchAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                batches);

        listView.setAdapter(batchAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adapter =(ArrayAdapter) parent.getAdapter();
                Toast.makeText(getApplicationContext(),adapter.getItem(position)+"Clicked",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuAdd){
            batches.add("Android");
            batchAdapter.notifyDataSetChanged();

        }
        else if(id == R.id.menuRemove){
            batches.remove(batches.size() - 1);
            batchAdapter.notifyDataSetChanged();
        }
        return true;
    }
}
