package com.vanderwardan.mail_android;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

/**
 * Created by op on 12.03.2017.
 */

public class DialogFragment extends Fragment {

    public interface onEventListener {
        void event(int year, int month, int dayOfMonth);
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
        View v = inflater.inflate(R.layout.fragment_dialog, container, false);
        final DatePicker dp = (DatePicker) v.findViewById(R.id.datePicker);
        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventListener.event(dp.getYear(), dp.getMonth(), dp.getDayOfMonth());
            }
        });
        return v;
    }
}
