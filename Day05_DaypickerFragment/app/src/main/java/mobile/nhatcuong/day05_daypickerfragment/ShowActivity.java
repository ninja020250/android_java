package mobile.nhatcuong.day05_daypickerfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
//        TextView txtBirhDay =  findViewById(R.id.txtBirthday);
//        TextView txtNationality =  findViewById(R.id.txtNationality);
//
//        Intent intent =  this.getIntent();
//        Bundle bundle = intent.getBundleExtra("info");
//        txtBirhDay.setText(bundle.getString("birthDay"));
//        txtNationality.setText(bundle.getString("nationality"));
    }
}
