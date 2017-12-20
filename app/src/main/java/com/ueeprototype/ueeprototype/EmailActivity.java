package com.ueeprototype.ueeprototype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class EmailActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        mRecyclerView = (RecyclerView) findViewById(R.id.email_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new emailRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

    }

    private ArrayList<EmailDataObject> getDataSet() {
        ArrayList results = new ArrayList<EmailDataObject>();
        results.add(0,new EmailDataObject("shamal.s@sliit.lk","2017-12-13"));
        results.add(1,new EmailDataObject("ashenas@gmail.com","2017-12-12"));
        results.add(2,new EmailDataObject("Kasun.s@sliit.lk","2017-12-11"));

        return results;
    }
}
