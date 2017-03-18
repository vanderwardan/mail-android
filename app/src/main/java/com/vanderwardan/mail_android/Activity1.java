package com.vanderwardan.mail_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by vanderwardan on 12.03.2017.
 */

public class Activity1 extends AppCompatActivity implements Fragment1.onEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        getFragmentManager().beginTransaction().
                replace(R.id.fragmentContainer, new Fragment1()).commit();

    }

    @Override
    public void event(String s) {
        if (s.equals("save") && checkAllFieldsAreFilled()) {
            this.finish();
            Intent intent = new Intent(this, Activity2.class);
            putInfo(intent);
            startActivity(intent);
        }
    }

    //checker for "Save" button
    boolean checkAllFieldsAreFilled() {
        Fragment1 frg = (Fragment1) getFragmentManager().findFragmentById(R.id.fragmentContainer);

        try {
            if (((TextView) frg.getView().findViewById(R.id.btnFirstName)).getText().toString().equals(""))
                return false;

            if (((TextView) frg.getView().findViewById(R.id.btnLastName)).getText().toString().equals(""))
                return false;

            if (((TextView) frg.getView().findViewById(R.id.btnDate)).getText().toString().equals("Date"))
                return false;
        } catch (NullPointerException exc) {
            throw new Error();
        }
        return true;
    }

    //put info fro Activity2
    public void putInfo(Intent intent) {
        Fragment1 frg = (Fragment1) getFragmentManager().findFragmentById(R.id.fragmentContainer);
        try {
            //send first name
            TextView tv = (TextView) frg.getView().findViewById(R.id.btnFirstName);
            intent.putExtra("firstName", tv.getText().toString());

            //send last name
            tv = (TextView) frg.getView().findViewById(R.id.btnLastName);
            intent.putExtra("lastName", tv.getText().toString());

            //send date
            tv = (TextView) frg.getView().findViewById(R.id.btnDate);
            intent.putExtra("date", tv.getText().toString());
        } catch (NullPointerException exc) {
            throw new Error();
        }
    }

}
