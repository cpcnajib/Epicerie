package com.example.epicerie;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.epicerie.database.AppDatabase;
import com.example.epicerie.database.AppExecutors;
import com.example.epicerie.database.ClientModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    View add_client, consulterCredit, modifierCredit;
    TextView client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_client = findViewById(R.id.add_client);
        consulterCredit = findViewById(R.id.conuslter_credit);
        modifierCredit = findViewById(R.id.modifier_credit);
        client = findViewById(R.id.lbl_consulter_client);

        add_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Ajouter client",
                        Toast.LENGTH_LONG).show();
                addClient();
            }
        });
        consulterCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "consulter credit",
                        Toast.LENGTH_LONG).show();
                consulterCredit();
            }
        });
        modifierCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "modifier credit",
                        Toast.LENGTH_LONG).show();
                modifierCredit();
            }
        });


    }


    private void modifierCredit() {
    }

    private void consulterCredit() {


    }

    private void addClient() {
        Intent intent = new Intent(this, AjouterClient.class);
        startActivity(intent);
    }
}
