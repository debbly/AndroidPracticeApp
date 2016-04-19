package com.example.debbly.practiceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.GridLayout.LayoutParams;

public class DisplayMessageActivity extends AppCompatActivity {
    final int TOP_ID = 3;
    final int BOTTOM_ID = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                //I want this to go back to the original screen
                Intent intent = new Intent(view.getContext(), MyActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);
        String subject = intent.getStringExtra(MyActivity.EXTRA_SUBJECT);

        TextView topBar = new TextView(this);
        topBar.setId(TOP_ID);

        TextView textView = new TextView(this);
        textView.setId(BOTTOM_ID);
        textView.setTextSize(40);
        textView.setText("Message: " + message);

        topBar.setTextSize(25);
        topBar.setText("Subject: " + subject);

        //RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        //layout.addView(textView);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.content);
        linearLayout.addView(topBar);
        linearLayout.addView(textView);
    }

}
