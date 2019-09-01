package com.example.epicerie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.epicerie.database.AppDatabase;
import com.example.epicerie.database.AppExecutors;
import com.example.epicerie.database.ClientModel;
import com.google.android.material.textfield.TextInputEditText;

public class AjouterClient extends AppCompatActivity {
    TextInputEditText clientName, clientPhoneNumber, clientPassword;
    Button btn_save;
    private AppDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_client);
        mDatabase = AppDatabase.getInstance(this);
        init();
    }

    private void init() {
        clientName = findViewById(R.id.lbl_name);
        clientPhoneNumber = findViewById(R.id.lbl_phone);
        clientPassword = findViewById(R.id.lbl_password);
        btn_save = findViewById(R.id.btn_save);

        if (clientName.getText().toString().isEmpty()) {
            clientName.setError("il faut entrer un nom ");
        }
        if (clientPassword.getText().toString().isEmpty()) {
            clientPassword.setError("il faut entrer password ");
        }
        if (clientPhoneNumber.getText().toString().isEmpty()) {
            clientPhoneNumber.setError("il faut entrer un numero de téléphone  ");
        }
        final ClientModel clientModel = new ClientModel(clientName.getText().toString()
                , clientPhoneNumber.getText().toString()
                , clientPassword.getText().toString()
        );

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    saveClient(clientModel);

            }
        });

    }

    public void saveClient(final ClientModel clientModel) {

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDatabase.clientDAO().insertClient(clientModel);

            }
        });
        startHomeActvity();

    }

    private void startHomeActvity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
