package com.sajeewamalith.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    EditText title,description;
    Button addNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        title= findViewById(R.id.title);
        description= findViewById(R.id.description);
        addNote= findViewById(R.id.addNote);

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(title.getText().toString()) && !TextUtils.isEmpty(description.getText().toString())){

                    DatabaseClass db=new DatabaseClass(AddNoteActivity.this);
                    db.addNotes(title.getText().toString(),description.getText().toString());

                    Intent intent=new Intent(AddNoteActivity.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();


                }
                else {
                    Toast.makeText(AddNoteActivity.this,"Both files required",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}