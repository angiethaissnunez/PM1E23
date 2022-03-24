package com.example.pm1e23;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MostrarActivityImagenes extends AppCompatActivity {

    DatabaseHandler objectDatabaseHandler;
    RecyclerView objectRecycleView;
    RVAdapter objectRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_imagenes);
        try {
  objectRecycleView=findViewById(R.id.imagesRV);
  objectDatabaseHandler=new DatabaseHandler(this);

        } catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void getData(View view)
    {
        try {
   objectRvAdapter=new RVAdapter(objectDatabaseHandler.getAllImagesData());
   objectRecycleView.setHasFixedSize(true);

   objectRecycleView.setLayoutManager(new LinearLayoutManager(this));
   objectRecycleView.setAdapter(objectRvAdapter);
        }
        catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}