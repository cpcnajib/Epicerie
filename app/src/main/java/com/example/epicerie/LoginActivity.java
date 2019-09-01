package com.example.epicerie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 101;
    Button btn_signIn;
    TextView signOut;
    private FirebaseAuth auth;
    private static final int RC_SIGN_IN = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseApp.initializeApp(this);

        init();
    }

    private void init() {
        signOut();
        btn_signIn = findViewById(R.id.btn_signIn);
        signOut = findViewById(R.id.btn_signOut);

        FirebaseUser currentUser =
                auth.getInstance().getCurrentUser();


        if (currentUser == null) {
            startActivity(new Intent(this, FirebaseUIActivity.class));
            finish();
            return;
        }
        signOut.setText(currentUser.getDisplayName());


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IdpResponse response = IdpResponse.fromResultIntent(data);

        if (requestCode == REQUEST_CODE) {

            if (resultCode == RESULT_OK) {
                startActivity(new Intent(this, MainActivity.class));
                return;
            }
        } else {
            if (response == null) {
                // User cancelled Sign-in
                return;
            }

            if (response.getError().equals(ErrorCodes.NO_NETWORK)) {
                // Device has no network connection
                return;
            }

            if (response.getError().equals(ErrorCodes.UNKNOWN_ERROR)) {
                // Unknown error occurred
                return;
            }
        }
    }

    public void signOut() {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(
                                    LoginActivity.this,
                                    FirebaseUIActivity.class));
                            finish();
                        } else {
                            // Report error to user
                        }
                    }
                });
    }
}
