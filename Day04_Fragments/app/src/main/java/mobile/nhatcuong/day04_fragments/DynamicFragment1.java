package mobile.nhatcuong.day04_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DynamicFragment1 extends Fragment {

    @Override
    public void onStart() {
        super.onStart();
        Button btnSub  =  getActivity().findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtResult =  getActivity().findViewById(R.id.txtResult);
                EditText editnumber1 = getActivity().findViewById(R.id.edtNumber1);
                EditText editnumber2 = getActivity().findViewById(R.id.editNumber2);
                int result =  Integer.parseInt(editnumber1.getText().toString()
                ) - Integer.parseInt(editnumber2.getText().toString());
                txtResult.setText("result = "+ result);
            }
        });
    }

    public DynamicFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dynamic_fragment1, container, false);
    }


}
