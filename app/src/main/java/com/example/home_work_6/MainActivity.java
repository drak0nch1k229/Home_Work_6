package com.example.home_work_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email, password;
    private Button sing_in;
    private LinearLayout container_12;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        sing_in = findViewById(R.id.sing_in);
        container_12 = findViewById(R.id.container_12);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (email.getText().toString().isEmpty()) {
                    sing_in.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
                } else {
                    sing_in.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (password.getText().toString().isEmpty()) {
                    sing_in.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
                } else {
                    sing_in.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        sing_in.setOnClickListener(view -> {
            if (email.getText().toString().equals("admin")&& password.getText().toString().equals("admin")){
                container_12.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,"Вы успешно зарегитрировались", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(MainActivity.this,"Неверно введен логин или пароль", Toast.LENGTH_LONG).show();
            }
        });
    }
}