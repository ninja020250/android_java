package mobile.nhatcuong.day07_tabfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {


    public TabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.activity_main, container, false);
       Bundle bundle = this.getArguments();
       TextView txtTitle = view.findViewById(R.id.txttitle);
       int index = bundle.getInt("index") + 1;
       txtTitle.setText(index + "");
       return view;
    }

}
