package kz.aibol.introstudio;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class IntentPractice extends ActionBarActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_practice);

        Button btn = (Button) findViewById(R.id.intentButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentPractice.this, Reciever.class);
                String message = "Hello guys, how are you?";
                intent.putExtra("text", message);
                startActivity(intent);
            }
        });

    }
}
