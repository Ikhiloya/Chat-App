package com.loya.android.rudigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;



public class NewThreadActivity extends AppCompatActivity {
    private EditText ideaEditText;
    private EditText rationalEditText;
    private EditText effectEditText;
    private Button btnSubmit;
    private ArrayList<String> idea;
    private ArrayList<String> rational;
    private ArrayList<String> effect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_thread);

        ideaEditText = (EditText) findViewById(R.id.idea_editText);
        rationalEditText = (EditText) findViewById(R.id.rational_editText);
        effectEditText = (EditText) findViewById(R.id.effect_editText);
        btnSubmit = (Button) findViewById(R.id.submit_button);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewThreadActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}
