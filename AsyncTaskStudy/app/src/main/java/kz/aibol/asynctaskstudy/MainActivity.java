package kz.aibol.asynctaskstudy;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    ProgressBar progressBar;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        tv = (TextView) findViewById(R.id.progress);

    }

    public void startProgress(View v) {
        MyProgressAsyncTask task = new MyProgressAsyncTask();

        task.execute();

        //new MyProgressAsyncTask().execute();
    }

    private class MyProgressAsyncTask extends AsyncTask<Void, Void, String> {

        private int progressValue = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String answer) {
            Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            progressBar.setProgress(progressValue);
            tv.setText(progressValue + " %");
        }

        @Override
        protected String doInBackground(Void... params) {

            while(progressValue < 100) {
                progressValue++;
                SystemClock.sleep(200);
                publishProgress();
            }



            return "Finished";
        }
    }

}
