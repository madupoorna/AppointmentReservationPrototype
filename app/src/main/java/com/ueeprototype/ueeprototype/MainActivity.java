package com.ueeprototype.ueeprototype;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String array[] = {"lecture", "instructor", "student"};

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(
                Color.parseColor("#CDCDCD"), R.drawable.oie_rdrgeekesigq, R.drawable.oie_transparent)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.lecturer)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.instructor_trans)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.instructor_trans)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(final int index) {

                        Toast.makeText(MainActivity.this, "You selected " + array[index], Toast.LENGTH_SHORT).show();

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                Intent slideactivity;

                                switch (index) {
                                    case 1: slideactivity = new Intent(MainActivity.this, Student_avail.class);
                                        startActivity(slideactivity);
                                        break;
                                    case 2: slideactivity = new Intent(MainActivity.this, LecturerAvailTabActivity.class);
                                        startActivity(slideactivity);
                                        break;
                                    case 3: slideactivity = new Intent(MainActivity.this, MainActivity.class);
                                        startActivity(slideactivity);
                                        break;
                                }
                            }
                        }, 1000);
                    }

                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {
            }

            @Override
            public void onMenuClosed() {
            }

        });
    }
}
