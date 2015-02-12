package kz.aibol.mymessanger.interfaces;

/**
 * Created by Aibol on 2/8/2015.
 */
public interface ISocketOperator {
    public String sendHttpRequest(String params);

    public int startListening(int port);

    public void stopListening();

    public void exit();

    public int getListeningPort();

}
