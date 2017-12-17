package com.ueeprototype.ueeprototype;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signIn = (Button) findViewById(R.id.signinBtn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent slideactivity = new Intent(v.getContext(), MainActivity.class);

                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(
                        getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();

                startActivity(slideactivity, bndlanimation);
            }
        });
    }

}
