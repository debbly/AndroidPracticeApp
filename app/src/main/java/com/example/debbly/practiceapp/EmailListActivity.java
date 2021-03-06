package com.example.debbly.practiceapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class EmailListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ugh, should read from gmail API in order to create cards with each email.. Another note, on a tap, it should reveal as much as the card can show.. will commit more", Snackbar.LENGTH_LONG)
                Snackbar.make(view, "Ugh, should read from gmail API in order to create cards with each email.. Another note, on a tap, it should reveal as much as the card can show.. will commit more", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });
    }
}
