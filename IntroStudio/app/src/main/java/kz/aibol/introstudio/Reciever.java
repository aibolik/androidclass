package kz.aibol.introstudio;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class Reciever extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciever);

        Intent intent = getIntent();

        String message = intent.getStringExtra("text");

        TextView tv = (TextView) findViewById(R.id.getText);

        tv.setText(message);

        /*Toast txt = new Toast(this);
        txt.setText("");
        txt.setDuration();
        txt.show();*/
        Toast.makeText(this, "You have a message", Toast.LENGTH_LONG).show();

    }
}
