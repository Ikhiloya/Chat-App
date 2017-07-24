package com.loya.android.rudigo;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfileActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    ImageView imageView;
    ImageButton imageButton;
    public static Uri imageUri;
    public static Drawable drawable;
    private TextView textView;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        textView = (TextView) findViewById(R.id.save_textView);
        editText1 = (EditText) findViewById(R.id.first_name);
        editText2 = (EditText) findViewById(R.id.last_name);
        editText3 = (EditText) findViewById(R.id.preferedUser__name);
        editText4 = (EditText) findViewById(R.id.job_desc);
        editText5 = (EditText) findViewById(R.id.phone_num);

        imageView = (ImageView) findViewById(R.id.profile_pic);
        imageButton = (ImageButton) findViewById(R.id.camera_btn);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(editText1.getText().toString().equals("")) && !(editText2.getText().toString().equals(""))
                        && !(editText3.getText().toString().equals(""))
                        && !(editText4.getText().toString().equals("")) && !(editText5.getText().toString().equals(""))) {
                    Toast.makeText(UserProfileActivity.this, "profile saved", Toast.LENGTH_SHORT).show();

                } else
                    Toast.makeText(UserProfileActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
