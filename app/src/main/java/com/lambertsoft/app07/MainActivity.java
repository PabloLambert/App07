package com.lambertsoft.app07;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    PendingIntent pendingIntent;
    Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonClick = (Button) findViewById(R.id.buttonClick);
        myContext = getApplicationContext();

        Intent intent = new Intent();
        intent.setClass(myContext, DetailActivity.class);
        pendingIntent = PendingIntent.getActivity(myContext, 0, intent, 0);

        buttonClick.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voidIntent = new Intent();
                try {
                    pendingIntent.send(myContext, 0, voidIntent);
                } catch (PendingIntent.CanceledException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
