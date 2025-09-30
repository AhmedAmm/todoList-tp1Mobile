package com.example.myapplication;

import android.content.Intent; // ✅ Needed for navigation
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Patterns;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editEmail, editPassword;
    private Button btnLogin;
    private CheckBox check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération des champs et du bouton
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        check = findViewById(R.id.editcheckbox); // ✅ Initialize your checkbox

        // Action du bouton
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString();
                boolean flag = check.isChecked();

                // Vérifier format email, longueur du mot de passe et état de la checkbox
                if (Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length() >= 6 && flag) {
                    Toast.makeText(MainActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();

                    // 🔹 Navigate to ToDoList activity
                    Intent intent = new Intent(MainActivity.this, ToDoList.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Email ou mot de passe incorrect ou case non cochée", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
