package kz.aibol.fragmentstudy;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class FragmentChanging extends FragmentActivity {

    private FragmentManager manager; //manager для управления фрагментами
    private FragmentTransaction ft; //транзакции с фрагментами

    private OneFragment oneFragment;
    private TwoFragment twoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_changing);

        oneFragment = new OneFragment(); //инициализация фрагмента
        twoFragment = new TwoFragment(); //инициализация фрагмента
    }



    public void fragmentInteraction(View v) {
        int vid = v.getId();

        manager = getSupportFragmentManager();
        ft = manager.beginTransaction();

        switch (vid) {
            case R.id.btnAdd:
                if(manager.findFragmentByTag(OneFragment.TAG) == null) { //проверка, если уже подключен фрагмент(чтобы не вылетал)
                    ft.add(R.id.container, oneFragment, OneFragment.TAG); //при добавлении указываем TAG
                 } else {
                    Toast.makeText(getApplicationContext(), "Вы уже добавили OneFragment", Toast.LENGTH_SHORT).show(); //говорит что fragment уже есть
                }
                break;
            case R.id.btnRemove:
                if(manager.findFragmentByTag(OneFragment.TAG) != null) { //проверка, что фрагмент, который мы хотим убрать - существует(чтобы не вылетал)
                    ft.remove(oneFragment);
                } else {
                    Toast.makeText(getApplicationContext(), "Нечего удалять", Toast.LENGTH_SHORT).show(); //говорит что нечего удалять
                }
                break;
        }

        ft.commit();
    }

}
