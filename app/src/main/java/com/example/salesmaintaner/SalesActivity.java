package com.example.salesmaintaner;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SalesActivity extends AppCompatActivity {

    EditText companyName,ceo,email,revenue;
    Button post;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        companyName = findViewById(R.id.companyname);
        ceo = findViewById(R.id.ceo);
        email = findViewById(R.id.email);
        revenue = findViewById(R.id.revenue);
        post = findViewById(R.id.submit);
        progressBar = findViewById(R.id.progressBar);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getReference("clients");

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String company = companyName.getText().toString().trim();
                String ceoName = ceo.getText().toString().trim();
                String emailString = email.getText().toString().trim();
                String rev = revenue.getText().toString().trim();

                if(TextUtils.isEmpty(company)||TextUtils.isEmpty(ceoName)||TextUtils.isEmpty(emailString)||TextUtils.isEmpty(rev)){
                    Toast.makeText(getApplicationContext(),"One of the fields is empty",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }
                String uid = ref.push().getKey();
                Clients client = new Clients(ceoName,company,emailString,Float.valueOf(rev));
                ref.child(uid).setValue(client);
                Toast.makeText(getApplicationContext(),"Update Succesful",Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                companyName.setText("");
                ceo.setText("");
                email.setText("");
                revenue.setText("");
            }
        });




    }
}
