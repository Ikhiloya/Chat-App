package com.loya.android.rudigo;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {
    FloatingActionButton send;
    EditText comment;
    TextView userText;
    TextView userIdea;
    TextView effect;
    ListView list;
    ArrayList<String> commentArray = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        send = (FloatingActionButton) findViewById(R.id.fab_comment);
        comment = (EditText) findViewById(R.id.commentText);
        list = (ListView) findViewById(R.id.listView);
        userText = (TextView) findViewById(R.id.usertextView);
        userIdea = (TextView) findViewById(R.id.ideatextView);
        effect = (TextView) findViewById(R.id.effect);

        String intentName = getIntent().getStringExtra("intentName");
        String intentIdea = getIntent().getStringExtra("intentIdea");
        String intentEffect = getIntent().getStringExtra("intentEffect");

        userText.setText(intentName);
        userIdea.setText(intentIdea);
        effect.setText(intentEffect);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getComment = comment.getText().toString();
                if (getComment == null || getComment.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Input field is empty", Toast.LENGTH_SHORT).show();
                } else {
                    commentArray.add(getComment);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>
                            (CommentActivity.this, android.R.layout.simple_list_item_1, commentArray);
                    list.setAdapter(adapter);
                    ((EditText) findViewById(R.id.commentText)).setText("");
                }
            }
        });


    }
}
