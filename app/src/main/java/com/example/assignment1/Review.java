package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Review extends AppCompatActivity {
    ImageButton fab;
    TextView remail,rname,rcontact,raddress,rcountry;
    TextView email,name,contact,address,country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_review);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        name.setText(getIntent().getStringExtra("sendername"));
        country.setText(getIntent().getStringExtra("sendercountry"));
        address.setText(getIntent().getStringExtra("senderaddress"));
        contact.setText(getIntent().getStringExtra("sendercontact"));
        rname.setText(getIntent().getStringExtra("rcvrname"));
        rcountry.setText(getIntent().getStringExtra("rcvrcountry"));
        raddress.setText(getIntent().getStringExtra("rcvraddress"));
        rcontact.setText(getIntent().getStringExtra("rcvrcontact"));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Review.this, SenderFormActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void init()
    {
        fab=findViewById(R.id.fab);
        name=findViewById(R.id.sender_name_data);
        country=findViewById(R.id.sender_country_data);
        address=findViewById(R.id.sender_address_data);
        contact=findViewById(R.id.sender_contact_data);
        rname=findViewById(R.id.receiver_name_data);
        rcountry=findViewById(R.id.receiver_country_data);
        raddress=findViewById(R.id.receiver_address_data);
        rcontact=findViewById(R.id.receiver_contact_data);

    }
}