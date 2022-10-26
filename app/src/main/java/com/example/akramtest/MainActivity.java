package com.example.akramtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseUser firebaseUser;
    private TextView textName;
    private Button btnLogout, btnListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = findViewById(R.id.name);
        btnLogout = findViewById(R.id.btn_logout);
        btnListView = findViewById(R.id.btn_listview);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser != null) {
            textName.setText(firebaseUser.getDisplayName());
        } else {
            textName.setText("Login Gagal!");
        }
        btnLogout.setOnClickListener(v -> {
           FirebaseAuth.getInstance().signOut();
           startActivity(new Intent(getApplicationContext(), LoginActivity.class));
           finish();
        });
        btnListView.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), ListViewActivity.class));
            finish();
        });

    }
}