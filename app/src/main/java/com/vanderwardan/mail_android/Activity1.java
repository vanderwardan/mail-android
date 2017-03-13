package com.vanderwardan.mail_android;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity implements Fragment1.onEventListener {

    Fragment1 fragment1 = new Fragment1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

//        Intent intent = getIntent();
//
//        //set first name
//        if(intent.hasExtra("firstName")) {
//            ((EditText) fragment_1.getView().findViewById(R.id.firstName)).
//                    setText(intent.getStringExtra("firstName"));
//        }
//
//        //set last name
//        if(intent.hasExtra("lastName")) {
//            ((EditText) fragment_1.getView().findViewById(R.id.lastName)).
//                    setText(intent.getStringExtra("lastName"));
//        }
//
//        //set date
//        if(intent.hasExtra("date")) {
//            ((TextView) fragment_1.getView().findViewById(R.id.showDate)).
//                    setText(intent.getStringExtra("date"));
//        }

        FragmentTransaction frgmTr = getFragmentManager().beginTransaction();
        frgmTr.add(R.id.fragmentContainer, fragment1);
        frgmTr.commit();

    }

    @Override
    public void event(String s) {
        if (s == "date") {
            FragmentTransaction frgmTr = getFragmentManager().beginTransaction();
//            frgmTr.remove(fragment_1);
//            frgmTr.add(R.id.fragmentContainer, dialogFragment);
//            frgmTr.commit();
        } else if (s == "save") {
            this.finish();
            Intent intent = new Intent(this, Activity2.class);

            Fragment1 frg = (Fragment1) getFragmentManager().findFragmentById(R.id.fragmentContainer);
            //send first name
            TextView tv = (TextView) frg.getView().findViewById(R.id.firstName);
            intent.putExtra("firstName", tv.getText().toString());
            //send last name
            tv = (TextView) frg.getView().findViewById(R.id.lastName);
            intent.putExtra("lastName", tv.getText().toString());
            //send date
            tv = (TextView) frg.getView().findViewById(R.id.date);
            intent.putExtra("date", tv.getText().toString());

            startActivity(intent);
        }
    }
}
