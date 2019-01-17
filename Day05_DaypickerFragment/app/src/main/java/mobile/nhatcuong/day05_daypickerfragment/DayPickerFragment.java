package mobile.nhatcuong.day05_daypickerfragment;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;



public class DayPickerFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR) - 18;
        int month =  cal.get(Calendar.MONTH) + 1;
        int day =  cal.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), (MainActivity)getActivity(),year, month, day);
    }


}
