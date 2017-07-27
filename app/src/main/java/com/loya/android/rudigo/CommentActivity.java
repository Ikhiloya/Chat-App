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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentActivity extends AppCompatActivity {
    FloatingActionButton send;
    EditText comment;
    TextView userText;
    TextView userIdea;
    TextView effect;
    ListView list;
    ArrayList<Comment> commentArray = new ArrayList<Comment>();


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
                    String currentTime = getCurrentTime();
                    commentArray.add(new Comment(getComment, currentTime));
                    CommentAdapter commentAdapter = new CommentAdapter(CommentActivity.this, commentArray);
                    list.setAdapter(commentAdapter);
                    ((EditText) findViewById(R.id.commentText)).setText("");
                }
            }
        });


    }

    //gets the current time
    private String getCurrentTime() {
        Date now = new Date(); // Instance of the Date class
        long curTime = now.getTime(); // Convert a Date to a long value
        //convert the time in milliseconds into a Date object by calling the Date constructor.
        Date dateObject = new Date(curTime);
        //Then we can initialize a SimpleDateFormat instance
        // and configure it to provide a more readable representation according to the given format.
        SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm a");
        String currentTime = dateFormatter.format(dateObject);
        return currentTime;
    }
}
