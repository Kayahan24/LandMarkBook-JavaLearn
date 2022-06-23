package com.kayasanli.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.kayasanli.landmarkbook.databinding.ActivityDetailsBinding;
import com.kayasanli.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ArrayList<landMark> landMarkArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landMarkArrayList = new ArrayList<>();
        landMark pisa = new landMark("Pisa","Italy",R.drawable.pisa);
        landMark eiffel = new landMark("Eiffel","France",R.drawable.eiffel);
        landMark lbridge = new landMark("London Bridge","Italy",R.drawable.londonbridge);
        landMark  collesium= new landMark("Collesium","UK",R.drawable.collesium);

        landMarkArrayList.add(pisa);
        landMarkArrayList.add(eiffel);
        landMarkArrayList.add(lbridge);
        landMarkArrayList.add(collesium);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        landmarkAdaptor landmarkAdaptor = new landmarkAdaptor(landMarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdaptor);
        /*
        //listView Kodları
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,landMarkArrayList.stream().map(landMark -> landMark.name).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this,landMarkArrayList.get(i).name,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark",landMarkArrayList.get(i));
                startActivity(intent);

            }
        });
        */



    }
}