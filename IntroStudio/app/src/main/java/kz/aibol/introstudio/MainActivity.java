package kz.aibol.introstudio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity /* implements View.OnClickListener*/ {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button btnCancel = (Button) findViewById(R.id.btnCancel);
        //Button btnOk = (Button) findViewById(R.id.okText);

        //btnOk.setOnClickListener(this);
        //btnCancel.setOnClickListener(this);

        tv = (TextView) findViewById(R.id.tv);

    }

    public void changeText(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.okText:
                tv.setText("OK");
                break;
            case R.id.btnCancel:
                tv.setText("Cancel");
                break;
        }
    }

    /*
    @Override
    public void onClick(View v) {
            int viewId = v.getId();
            switch (viewId) {
                case R.id.okText:
                    tv.setText("OK");
                    break;
                case R.id.btnCancel:
                    tv.setText("Cancel");
                    break;
            }
    }*/
}
