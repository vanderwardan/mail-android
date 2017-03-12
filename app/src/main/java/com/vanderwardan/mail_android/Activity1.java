package com.vanderwardan.mail_android;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;

public class Activity1 extends Activity implements Fragment1.onEventListener, DialogFragment.onEventListener {

    Fragment1 fragment1 = new Fragment1();
    DialogFragment dialogFragment = new DialogFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        FragmentTransaction frgmTr = getFragmentManager().beginTransaction();
        frgmTr.add(R.id.fragmentContainer, fragment1);
        frgmTr.commit();
    }

    @Override
    public void event(String s) {
        if (s == "date") {
            FragmentTransaction frgmTr = getFragmentManager().beginTransaction();
            frgmTr.remove(fragment1);
            frgmTr.add(R.id.fragmentContainer, dialogFragment);
            frgmTr.commit();
        } else if (s == "save") {

        }
    }

    @Override
    public void event(int year, int month, int dayOfMonth) {
        FragmentTransaction frgmTr = getFragmentManager().beginTransaction();
        frgmTr.remove(dialogFragment);
        frgmTr.add(R.id.fragmentContainer, fragment1);
        Fragment1 frg = (Fragment1) getFragmentManager().findFragmentById(R.id.fragmentContainer);
        ((TextView) frg.getView().findViewById(R.id.date)).setText("" + dayOfMonth + "/" + month + "/" + year);
        frgmTr.commit();
    }
}
