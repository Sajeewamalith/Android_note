package com.sajeewamalith.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   // private Menu menu;

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    Adepter adepter;
    List<Model> notesList;
    DatabaseClass databaseClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycleView);
        floatingActionButton=findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddNoteActivity.class);
                startActivity(intent);

            }

        });

        notesList=new ArrayList<>();

        databaseClass=new DatabaseClass(this);
        fetchAllNotesFromDatabase();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adepter=new Adepter(this,MainActivity.this,notesList);
        recyclerView.setAdapter(adepter);

    }

    void fetchAllNotesFromDatabase(){

        Cursor cursor=databaseClass.readAllDate();

        if (cursor.getCount()==0){
            Toast.makeText(this,"No data show",Toast.LENGTH_SHORT).show();

        }
        else {
            while (cursor.moveToNext()){

                notesList.add(new Model(cursor.getString(0),cursor.getString(1),cursor.getString(2)));

            }
        }

    }



    //search
   // @Override
   // public boolean onCreateOptionsMenu(Menu menu) {
     //  getMenuInflater().inflate(R.menu.option_menu,menu);

    //  MenuItem searchItem=menu.findItem(R.id.searchbar);
    //    SearchView searchView=(SearchView) searchItem.getActionView();
   //   searchView.setQueryHint("Search Notes Here");

     //   SearchView.OnQueryTextListener listener= new SearchView.OnQueryTextListener() {
       //    @Override
         //  public boolean onQueryTextSubmit(String query) {
       //      return false;
      //    }

       //    @Override
        //    public boolean onQueryTextChange(String newText) {
         //      return true;
        //    }
      //  };

     //   searchView.setOnQueryTextListener(listener);




     //  return super.onCreateOptionsMenu(menu);
   // }
}