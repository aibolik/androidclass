package kz.aibol.introstudio;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterPractice extends ActionBarActivity  {

    ListView lv;

    ArrayList<Phone> phones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_practice);

        lv = (ListView) findViewById(R.id.listView);

        phones = new ArrayList<Phone>();

        phones.add(new Phone("Samsung", 100000));
        phones.add(new Phone("HTC", 200000));
        phones.add(new Phone("iPhone", 500000));
        phones.add(new Phone("Nokia", 500000));


        lv.setAdapter(new MyAdapter(this));
        //lv.setOnClickListener();

    }

    public class MyAdapter extends BaseAdapter {

        Context context;

        public MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return phones.size();
        }

        @Override
        public Object getItem(int position) {
            return phones.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView != null) {
                return convertView;
            }

            else {

                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View v = inflater.inflate(R.layout.phone_item, parent, false);

                TextView model = (TextView) v.findViewById(R.id.model);
                TextView prize = (TextView) v.findViewById(R.id.prize);

                model.setText(phones.get(position).name);
                prize.setText(Integer.toString(phones.get(position).prize));

                return v;
            }
        }
    }

}
