package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnlogin, btndaf;
    EditText edmail, edpass;
    String Name, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = findViewById(R.id.Signin);
        btndaf = findViewById(R.id.signup);
        edmail = findViewById(R.id.email);
        edpass = findViewById(R.id.password);

        btndaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), registrasi.class);
                startActivity(i);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name = edmail.getText().toString();
                password = edpass.getText().toString();

                String email = "admin@mail.com";
                String pass = "123";

                if (Name.isEmpty() || password.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password Harus Diisi!!!", Toast.LENGTH_LONG);
                    edmail.setError("Email dan Password Harus Diisi!!!");
                    edpass.setError("Email dan Password Harus Diisi!!!");
                    t.show();
                } else {
                    if (Name.equals(email) && password.equals(pass)) {

                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Anda Sukses",
                                Toast.LENGTH_LONG);

                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a", Name.trim());

                        b.putString("b", password.trim());

                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);

                        i.putExtras(b);

                        startActivity(i);


                    } else {

                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Anda Gagal", Toast.LENGTH_LONG);

                        t.show();


                    }     }
            }
        });
    }
}