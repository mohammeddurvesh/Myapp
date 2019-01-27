package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
   private EditText te;
    private Button bu;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        te=(EditText)findViewById(R.id.te);
        bu=(Button)findViewById(R.id.bu);
        databaseReference= FirebaseDatabase.getInstance().getReference("users");

        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adddata();
            }
        });

    }
    public void adddata()
    {
        String Te=te.getText().toString().trim();
        String Bu=bu.getText().toString().trim();

        savedata sv=new savedata(Te,Bu);
        databaseReference.setValue(sv);




    }
}
