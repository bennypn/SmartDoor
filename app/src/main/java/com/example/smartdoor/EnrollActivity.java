package com.example.smartdoor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EnrollActivity extends AppCompatActivity {
    private Button btnSub,btnFp,btnRfid;
    private EditText inName;
    private TextView tvRfid,tvFp;
    private ProgressBar progressBar;
    private static Integer status,fp;
    protected static String name,rfid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        tvFp= findViewById(R.id.fp_tv);
        tvRfid=findViewById(R.id.rfid_tv);
        btnFp = findViewById(R.id.btn_addFP);
        btnRfid = findViewById(R.id.btn_addRFID);
        btnSub = findViewById(R.id.btn_submit);
        inName = findViewById(R.id.regis_name);
        progressBar = findViewById(R.id.progressBar);

        status =0;

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                status = snapshot.child("status").getValue(Integer.class);
                rfid = snapshot.child("enroll").child("enrollRfid").getValue(String.class);
                fp = snapshot.child("enroll").child("enrollFp").getValue(Integer.class);

                if(status==0){
                    progressBar.setVisibility(View.GONE);
                } else if(status==3){
                    tvRfid.setText(rfid);
                    myRef.child("status").setValue(0);
                }

                btnSub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        progressBar.setVisibility(View.VISIBLE);
                        name = inName.getText().toString();
                        myRef.child("user/userFp/"+fp).setValue(fp);
                        myRef.child("user/userFp/"+fp+"/name").setValue(name);

                        myRef.child("user/userRfid/"+rfid).setValue(rfid);
                        myRef.child("user/userRfid/"+rfid+"/name").setValue(name);
                        myRef.child("enroll/enrollRfid").setValue("NULL");
                        myRef.child("transaction/fp/"+fp).setValue(fp);

                        Intent i = new Intent(EnrollActivity.this,HomepageActivity.class);
                        progressBar.setVisibility(View.GONE);
                        fp++;
                        myRef.child("enroll/enrollFp/").setValue(fp);
                        startActivity(i);

                    }
                });

                btnRfid.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myRef.child("status").setValue(1);
                        progressBar.setVisibility(View.VISIBLE);
                    }
                });

                btnFp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tvFp.setText(fp.toString());
                        myRef.child("status").setValue(2);
                        progressBar.setVisibility(View.VISIBLE);
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}