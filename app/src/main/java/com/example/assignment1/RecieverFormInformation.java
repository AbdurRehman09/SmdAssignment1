package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RecieverFormInformation extends AppCompatActivity {

    Button rcvr_next_button;
    EditText rcvr_email_feild;
    EditText rcvr_name_feild;
    EditText rcvr_contact_feild;
    EditText rcvr_country_feild;
    EditText rcvr_address_feild;
    String remail,rname,rcontact,raddress,rcountry;
    String email,name,contact,address,country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reciever_form_information);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        name=getIntent().getStringExtra("sendername");
        country=getIntent().getStringExtra("sendercountry");
        address=getIntent().getStringExtra("senderaddress");
        contact=getIntent().getStringExtra("sendercontact");
        rcvr_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remail=rcvr_email_feild.getText().toString().trim();
                rname=rcvr_name_feild.getText().toString().trim();
                rcontact=rcvr_contact_feild.getText().toString().trim();
                rcountry=rcvr_country_feild.getText().toString().trim();
                raddress=rcvr_address_feild.getText().toString().trim();
                if (remail.isEmpty() || rname.isEmpty() || rcontact.isEmpty() || rcountry.isEmpty() || raddress.isEmpty()) {
                    Toast.makeText(RecieverFormInformation.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return; // Stop execution if fields are empty
                }

                // Optional: Validate email format (simple check)
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(remail).matches()) {
                    Toast.makeText(RecieverFormInformation.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Optional: Validate contact format (simple check)
                if (!rcontact.matches("\\d+")) { // Only digits
                    Toast.makeText(RecieverFormInformation.this, "Please enter a valid contact number", Toast.LENGTH_SHORT).show();
                    return;
                }
               Intent i= new Intent(RecieverFormInformation.this, Review.class);
               i.putExtra("rcvrname",rname);
               i.putExtra("rcvrcountry",rcountry);
               i.putExtra("rcvraddress",raddress);
               i.putExtra("rcvrcontact",rcontact);
                i.putExtra("sendername",name);
                i.putExtra("sendercountry",country);
                i.putExtra("senderaddress",address);
                i.putExtra("sendercontact",contact);
               startActivity(i);
               finish();
            }
        });
    }
    private void init()
    {
        rcvr_next_button=findViewById(R.id.rcvr_next_button);
        rcvr_email_feild=findViewById(R.id.rcvr_email_field);
        rcvr_name_feild=findViewById(R.id.rcvr_name_field);
        rcvr_contact_feild=findViewById(R.id.rcvr_contact_field);
        rcvr_country_feild=findViewById(R.id.rcvr_country_field);
        rcvr_address_feild=findViewById(R.id.rcvr_address_field);

    }
}