package com.vanderwardan.mail_android;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by op on 12.03.2017.
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
        View v = inflater.inflate(R.layout.fragment1, container, false);
        TextView tv = (TextView) v.findViewById(R.id.date);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventListener.event("date");
            }
        });

        return v;
    }
}
