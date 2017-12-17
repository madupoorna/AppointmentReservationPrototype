package com.ueeprototype.ueeprototype;

import android.graphics.Color;
import android.os.Bundle;
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

        final String array[]={"lecture"
                        ,"instructor"
                        ,"student"};

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(
                Color.parseColor("#CDCDCD"), R.drawable.oie_rdrgeekesigq, R.drawable.oie_transparent)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.lecturer)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.instructor_trans)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.instructor_trans)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(int index) {

                        Toast.makeText(MainActivity.this, "You selected"+array[index], Toast.LENGTH_SHORT).show();

                    }

                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {}

            @Override
            public void onMenuClosed() {}

        });
    }
}
