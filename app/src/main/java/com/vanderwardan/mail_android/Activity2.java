package com.vanderwardan.mail_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by op on 13.03.2017.
 */

public class Activity2 extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button btn = (Button) findViewById(R.id.btnEdit);
        btn.setOnClickListener(this);

        Intent intent = getIntent();

        //set first name
        if (intent.hasExtra("firstName")) {
            ((TextView) findViewById(R.id.showFirstName)).
                    setText(intent.getStringExtra("firstName"));
        }

        //set last name
        if (intent.hasExtra("lastName")) {
            ((TextView) findViewById(R.id.showLastName)).
                    setText(intent.getStringExtra("lastName"));
        }

        //set date
        if (intent.hasExtra("date")) {
            ((TextView) findViewById(R.id.showDate)).
                    setText(intent.getStringExtra("date"));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnEdit) {
            this.finish();
            Intent intent = new Intent(this, Activity1.class);

            //send first name
            TextView tv = (TextView) findViewById(R.id.showFirstName);
            intent.putExtra("firstName", tv.getText().toString());
            //send last name
            tv = (TextView) findViewById(R.id.showLastName);
            intent.putExtra("lastName", tv.getText().toString());
            //send date
            tv = (TextView) findViewById(R.id.showDate);
            intent.putExtra("date", tv.getText().toString());

            startActivity(intent);
        }
    }
}
