package com.example.debbly.practiceapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;
import java.util.logging.Level;

public class MyActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.debbly.practiceapp.MESSAGE";
    public final static String EXTRA_SUBJECT = "com.example.debbly.practiceapp.SUBJECT";

    private static final Level LOGGING_LEVEL = Level.OFF;

    private static final String PREF_ACCOUNT_NAME = "accountName";

    static final String TAG = "TasksSample";

    static final int REQUEST_GOOGLE_PLAY_SERVICES = 0;

    static final int REQUEST_AUTHORIZATION = 1;

    static final int REQUEST_ACCOUNT_PICKER = 2;


    List<String> tasksList;

    ArrayAdapter<String> adapter;

    int numAsyncTasks;

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DisplayMessageActivity.class);
                EditText editText = (EditText) findViewById(R.id.edit_message);
                EditText editSubject = (EditText) findViewById(R.id.edit_subject);
                String subject = editSubject.getText().toString();
                String message = editText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                intent.putExtra(EXTRA_SUBJECT, subject);
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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
