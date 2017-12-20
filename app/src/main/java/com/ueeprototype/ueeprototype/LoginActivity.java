package com.ueeprototype.ueeprototype;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signIn = (Button) findViewById(R.id.signinBtn);

        checkAndRequestPermissions();

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent slideactivity = new Intent(v.getContext(), MainActivity.class);

                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(
                        getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();

                startActivity(slideactivity, bndlanimation);
                finish();
            }
        });
    }

    private  boolean checkAndRequestPermissions() {

        int CALL_PHONE = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (CALL_PHONE != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.CALL_PHONE);
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this,listPermissionsNeeded.toArray
                    (new String[listPermissionsNeeded.size()]),REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }

        return true;

    }

}
