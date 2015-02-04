package kz.aibol.fragmentstudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Aibol on 2/4/2015.
 */
public class OneFragment extends Fragment {

    public static final String TAG = "OneFragment"; // tag чтобы определять какой фрагмент подключен

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }
}
