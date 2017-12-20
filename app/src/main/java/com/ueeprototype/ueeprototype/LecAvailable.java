package com.ueeprototype.ueeprototype;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class LecAvailable extends Fragment {

    Context superContext;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public LecAvailable() {
    }

    public void setContext(Context context) {
        this.superContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_available, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AvailableRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AvailableRecyclerViewAdapter) mAdapter).setOnItemClickListener(new AvailableRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(final int position, View v) {

                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.custom_popup);
                dialog.setTitle("Contact");
                // set the custom dialog components - text, image and button
                TextView nameText = (TextView) dialog.findViewById(R.id.nameTextView);
                TextView emailText = (TextView) dialog.findViewById(R.id.EmailTextView);
                TextView Mobiletext = (TextView) dialog.findViewById(R.id.mobileNoTxtView);

                nameText.setText("Name : "+getDataSet().get(position).getName());
                emailText.setText("Email: "+getDataSet().get(position).getEmail());
                Mobiletext.setText("Tel  : "+getDataSet().get(position).getMobileNo());

                Button emailBtn= (Button) dialog.findViewById(R.id.emailFab);
                Button callBtn= (Button) dialog.findViewById(R.id.callFab);

                emailBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {
                            Intent emailIntent = new Intent(Intent.ACTION_SEND);
                            emailIntent.setType("text/plain");
                            startActivity(emailIntent);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });

                callBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:"+getDataSet().get(position).getMobileNo()));
                        startActivity(callIntent);
                    }
                });

                dialog.show();
            }
        });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        results.add(0,new DataObject("Mr. Saman perera","714589657","perera.s@sliit.lk"));
        results.add(1,new DataObject("Mr. Ajith athawudha","778452365","athawudha.a@sliit.lk"));
        results.add(2,new DataObject("Ms. Kamani Silva","768545785","silva.k@sliit.lk"));

        return results;
    }

}
