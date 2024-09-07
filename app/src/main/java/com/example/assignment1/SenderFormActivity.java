package com.example.assignment1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SenderFormActivity extends AppCompatActivity {

    Button next_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sender_information);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        init();
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent i=new Intent(SenderFormActivity.this,RecieverFormInformation.class);
              startActivity(i);
              finish();
            }
        });

    }
    private void init(){
        next_button=findViewById(R.id.next_button);
    }
}

