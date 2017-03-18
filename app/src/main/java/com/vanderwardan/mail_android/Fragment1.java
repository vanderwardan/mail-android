package com.vanderwardan.mail_android;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by vanderwardan on 12.03.2017.
 */

public class Fragment1 extends Fragment {

    public interface onEventListener {
        void event(String s);
    }

    onEventListener eventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            eventListener = (onEventListener) activity;
        } catch (ClassCastException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_1, container, false);

        Intent intent = getActivity().getIntent();
        setInfo(intent, v);

        TextView tv = (TextView) v.findViewById(R.id.btnDate);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dfr = new SimpleDialogFragment();
                dfr.show(((AppCompatActivity) getActivity()).getSupportFragmentManager(), "datapicker");
            }
        });

        Button btn = (Button) v.findViewById(R.id.btnSave);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventListener.event("save");
            }
        });

        return v;
    }

    //set info from Activity2
    public void setInfo(Intent intent, View v) {

        //set first name
        if (intent.hasExtra("firstName")) {
            ((EditText) v.findViewById(R.id.btnFirstName)).
                    setText(intent.getStringExtra("firstName"));
        }

        //set last name
        if (intent.hasExtra("lastName")) {
            ((EditText) v.findViewById(R.id.btnLastName)).
                    setText(intent.getStringExtra("lastName"));
        }

        //set date
        if (intent.hasExtra("date")) {
            ((TextView) v.findViewById(R.id.btnDate)).
                    setText(intent.getStringExtra("date"));
        }
    }
}
