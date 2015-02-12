package kz.aibol.mymessanger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


public class SignUpActivity extends ActionBarActivity implements View.OnClickListener {

    private EditText username, password, password2, email;
    private Button signUp, cancel;
    public static final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"; //a@a.a

    /*private IAppManager imService;
    private Handler handler = new Handler();

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            imService = ((IMService.IMBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            imService = null;
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        password2 = (EditText) findViewById(R.id.passwordRepeat);
        email = (EditText) findViewById(R.id.email);

        signUp = (Button) findViewById(R.id.btnSignup);
        cancel = (Button) findViewById(R.id.cancel);

        signUp.setOnClickListener(this);
        cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int vid = v.getId();
        switch (vid) {
            case R.id.btnSignup:
                final String user = username.getText().toString();
                final String pass = password.getText().toString();
                String pass2 = password2.getText().toString();
                final String e_mail = email.getText().toString().trim();
                if (!pass.equals(pass2)) {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else if (user.length() < 5 || pass.length() < 5) {
                    Toast.makeText(getApplicationContext(), "Username and password must be at least 5 symbols", Toast.LENGTH_SHORT).show();
                } else if (!e_mail.matches(emailPattern)) {
                    Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                } else {
                    new SignUpTask().execute();

                    //Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    /*Thread thread = new Thread() {
                        String result = null;

                        @Override
                        public void run() {
                            result = imService.signUpUser(user, pass, e_mail);

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if(result.equals("1")) {
                                        Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "FAILED", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    };
                    thread.start();*/
                }
                break;
            case R.id.cancel:
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
    }

    private class SignUpTask extends AsyncTask<Void, Void, Void> {

        String result;

        @Override
        protected Void doInBackground(Void... params) {
            String address = "http://android-im.orisale.ru/index.php";

            List<NameValuePair> param = new ArrayList<>();

            param.add(new BasicNameValuePair("username", username.getText().toString()));
            param.add(new BasicNameValuePair("password", password.getText().toString()));
            param.add(new BasicNameValuePair("action", "signUpUser"));
            param.add(new BasicNameValuePair("email", email.getText().toString()));

            JSONParser jParser = new JSONParser();


            result = jParser.makeHttpRequest(address, "POST", param);
            //JSONObject json = jParser.makeHttpRequest(address, "POST", param);

            /*if(json != null) {
                result = json.toString();
            }*/

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }



}
