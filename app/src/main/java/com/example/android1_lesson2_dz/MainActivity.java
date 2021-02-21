package com.example.android1_lesson2_dz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_camera;
    ImageButton btn_contacts;
    ImageButton btn_google;
    Button changeNumberActivity;
    TextView number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_camera = findViewById(R.id.btn_photo);
        btn_google = findViewById(R.id.btn_google);
        btn_contacts = findViewById(R.id.btn_group);
        changeNumberActivity = findViewById(R.id.btn_to_activity_change_number);
        number = findViewById(R.id.tv_number);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openingCamera = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(openingCamera);
            }
        });

        btn_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myNumber = "0707000777";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: " + myNumber));
                startActivity(intent);
            }
        });

        btn_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.google.com/https://www.google.com/search?q=the+colosseum&oq=the+colosseum&aqs=chrome..69i57j0l9.1924j0j7&sourceid=chrome&ie=UTF-8");
                Intent openingGoogle = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(openingGoogle);
            }
        });


        changeNumberActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChangeNumberActivity.class);
                startActivityForResult(intent, 100);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            if (requestCode == 100) {
                String info = data.getStringExtra("key");
                number.setText(info);
            }
        }
    }
}