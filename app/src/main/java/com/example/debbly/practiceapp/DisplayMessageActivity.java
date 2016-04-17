package com.example.debbly.practiceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

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

        // create two layouts to hold buttons
        RelativeLayout top = new RelativeLayout(this);
        RelativeLayout bottom = new RelativeLayout(this);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);
        String subject = intent.getStringExtra(MyActivity.EXTRA_SUBJECT);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText("To: " + "\n" + subject + ": " + message);

        //RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        //layout.addView(textView);

        RelativeLayout root = (RelativeLayout) findViewById(R.id.content);

        // add generated layouts to root layout view
        // LinearLayout root = (LinearLayout)this.findViewById(R.id.root_layout);

        root.addView(textView);
        root.addView(textView);
    }

}
