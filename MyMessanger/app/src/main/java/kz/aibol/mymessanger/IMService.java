package kz.aibol.mymessanger;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Binder;
import android.os.IBinder;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Timer;

import kz.aibol.mymessanger.interfaces.IAppManager;
import kz.aibol.mymessanger.interfaces.ISocketOperator;


public class IMService extends Service implements IAppManager {

    private final IBinder mBinder = new IMBinder();
    ISocketOperator socketOperator = new SocketOperator(this);
    public ConnectivityManager conManager = null;
    private Timer timer;

    private NotificationManager mNM;

    public IMService() {
    }

    @Override
    public void onCreate() {
        mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        //localstoragehandler = new LocalStorageHandler(this);
        // Display a notification about us starting.  We put an icon in the status bar.
        //   showNotification();
        conManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        //new LocalStorageHandler(this);

        // Timer is used to take the friendList info every UPDATE_TIME_PERIOD;
        timer = new Timer();

        Thread thread = new Thread()
        {
            @Override
            public void run() {

                //socketOperator.startListening(LISTENING_PORT_NO);
                Random random = new Random();
                int tryCount = 0;
                while (socketOperator.startListening(10000 + random.nextInt(20000))  == 0 )
                {
                    tryCount++;
                    if (tryCount > 10)
                    {
                        // if it can't listen a port after trying 10 times, give up...
                        break;
                    }

                }
            }
        };
        thread.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String sendMessage(String username, String tousername, String message) throws UnsupportedEncodingException {
        return null;
    }

    @Override
    public String authenticateUser(String usernameText, String passwordText) throws UnsupportedEncodingException {
        return null;
    }

    @Override
    public void messageReceived(String username, String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public boolean isUserAuthenticated() {
        return false;
    }

    @Override
    public String getLastRawFriendList() {
        return null;
    }

    @Override
    public void exit() {

    }

    @Override
    public String signUpUser(String usernameText, String passwordText, String email) {
        String params = "username=" + usernameText +
                "&password=" + passwordText +
                "&action=" + "signUpUser" +
                "&email=" + email + "&";

        String result = socketOperator.sendHttpRequest(params);
        return result;
    }

    @Override
    public String addNewFriendRequest(String friendUsername) {
        return null;
    }

    @Override
    public String sendFriendsReqsResponse(String approvedFriendNames, String discardedFriendNames) {
        return null;
    }

    public class IMBinder extends Binder {
        public IAppManager getService() {
            return IMService.this;
        }

    }

}
