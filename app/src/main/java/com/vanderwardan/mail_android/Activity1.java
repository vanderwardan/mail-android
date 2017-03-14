package com.vanderwardan.mail_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity implements Fragment1.onEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        getFragmentManager().beginTransaction().
                add(R.id.fragmentContainer, new Fragment1()).commit();

        //it doesn't work, but don't now why. Correctly it falls
        //cause frg1 in setInfo() is null
        //Intent intent = getIntent();
        //setInfo(intent);
    }

    @Override
    public void event(String s) {
        if (s == "save" && checkAllFieldsAreFilled()) {
            this.finish();
            Intent intent = new Intent(this, Activity2.class);
            putInfo(intent);
            startActivity(intent);
        }
    }

    //checker for "Save" button
    boolean checkAllFieldsAreFilled() {
        Fragment1 frg = (Fragment1) getFragmentManager().findFragmentById(R.id.fragmentContainer);

        if (((TextView) frg.getView().findViewById(R.id.btnFirstName)).getText().toString().equals(""))
            return false;
        if (((TextView) frg.getView().findViewById(R.id.btnLastName)).getText().toString().equals(""))
            return false;
        if (((TextView) frg.getView().findViewById(R.id.btnDate)).getText().toString().equals("Date"))
            return false;

        return true;
    }

    //put info fro Activity2
    public void putInfo(Intent intent) {
        Fragment1 frg = (Fragment1) getFragmentManager().findFragmentById(R.id.fragmentContainer);
        //send first name
        TextView tv = (TextView) frg.getView().findViewById(R.id.btnFirstName);
        intent.putExtra("firstName", tv.getText().toString());
        //send last name
        tv = (TextView) frg.getView().findViewById(R.id.btnLastName);
        intent.putExtra("lastName", tv.getText().toString());
        //send date
        tv = (TextView) frg.getView().findViewById(R.id.btnDate);
        intent.putExtra("date", tv.getText().toString());
    }

    //set info from Activity2
    public void setInfo(Intent intent) {

        Fragment1 frg1 = (Fragment1) getFragmentManager().findFragmentById(R.id.fragmentContainer);
        //set first name
        if (intent.hasExtra("firstName")) {
            ((EditText) frg1.getView().findViewById(R.id.btnFirstName)).
                    setText(intent.getStringExtra("firstName"));
        }

        //set last name
        if (intent.hasExtra("lastName")) {
            ((EditText) frg1.getView().findViewById(R.id.btnLastName)).
                    setText(intent.getStringExtra("lastName"));
        }

        //set date
        if (intent.hasExtra("date")) {
            ((TextView) frg1.getView().findViewById(R.id.btnDate)).
                    setText(intent.getStringExtra("date"));
        }
    }
}
