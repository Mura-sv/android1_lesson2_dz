package com.example.android1_lesson2_dz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangeNumberActivity extends AppCompatActivity {

    Button changeNumber;
    EditText number_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_number);

        changeNumber = findViewById(R.id.btn_changeNumber);
        number_value = findViewById(R.id.et_number);

        changeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key", number_value.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}