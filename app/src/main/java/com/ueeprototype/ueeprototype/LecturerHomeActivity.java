package com.ueeprototype.ueeprototype;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class LecturerHomeActivity extends AppCompatActivity {

    public static int indexNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_home);

        final String array[] = {"lecture", "instructor", "student","mail"};

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(
                Color.parseColor("#CDCDCD"), R.drawable.oie_rdrgeekesigq, R.drawable.oie_transparent)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.lecturer)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.instructor_trans)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.correct)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.imageedit_3_4315567158)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {

                        indexNo=index;
                        Toast.makeText(LecturerHomeActivity.this, "You selected " + array[index], Toast.LENGTH_SHORT).show();

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                switch (indexNo) {
                                    case 0:
                                        Intent slideactivity1 = new Intent(LecturerHomeActivity.this, LecturerInfoActivity.class);
                                        startActivity(slideactivity1);
                                        break;
                                    case 1:
                                        Intent slideactivity2 = new Intent(LecturerHomeActivity.this, OthersAvailabilityTabActivity.class);
                                        startActivity(slideactivity2);
                                        break;
                                    case 2:
                                        Intent slideactivity3 = new Intent(LecturerHomeActivity.this, StduentInfoActivity.class);
                                        startActivity(slideactivity3);
                                        break;
                                    case 3:
                                        Intent slideactivity4 = new Intent(LecturerHomeActivity.this, EmailActivity.class);
                                        startActivity(slideactivity4);
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
