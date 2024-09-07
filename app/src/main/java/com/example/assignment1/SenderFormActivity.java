package com.example.assignment1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SenderFormActivity extends AppCompatActivity {

    Button next_button;
    EditText email_feild;
    EditText name_feild;
    EditText contact_feild;
    EditText country_feild;
    EditText address_feild;
    String email,name,contact,address,country;



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
                email=email_feild.getText().toString().trim();
                name=name_feild.getText().toString().trim();
                contact=contact_feild.getText().toString().trim();
                country=country_feild.getText().toString().trim();
                address=address_feild.getText().toString().trim();
                if (email.isEmpty() || name.isEmpty() || contact.isEmpty() || country.isEmpty() || address.isEmpty()) {
                    Toast.makeText(SenderFormActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return; // Stop execution if fields are empty
                }

                // Optional: Validate email format (simple check)
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(SenderFormActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Optional: Validate contact format (simple check)
                if (!contact.matches("\\d+")) { // Only digits
                    Toast.makeText(SenderFormActivity.this, "Please enter a valid contact number", Toast.LENGTH_SHORT).show();
                    return;
                }
              Intent i=new Intent(SenderFormActivity.this,RecieverFormInformation.class);
              i.putExtra("sendername",name);
              i.putExtra("sendercountry",country);
              i.putExtra("senderaddress",address);
              i.putExtra("sendercontact",contact);
              startActivity(i);
              finish();
            }
        });

    }
    private void init(){
        next_button=findViewById(R.id.next_button);
        email_feild=findViewById(R.id.email_field);
        name_feild=findViewById(R.id.name_field);
        contact_feild=findViewById(R.id.contact_field);
        country_feild=findViewById(R.id.country_field);
        address_feild=findViewById(R.id.address_field);

    }
}

