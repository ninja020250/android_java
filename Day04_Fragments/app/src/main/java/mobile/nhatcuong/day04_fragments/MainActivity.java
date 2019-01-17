package mobile.nhatcuong.day04_fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToAdd(View view) {
        EditText editnum1 = findViewById(R.id.edtNumber1);
        EditText editnum2 =  findViewById(R.id.editNumber2);
        TextView txtResult = findViewById(R.id.txtResult);
        int result =  Integer.parseInt(editnum1.getText().toString()) +Integer.parseInt(editnum2.getText().toString());
        txtResult.setText("Result  = "+ result
        );
    }

    public void clickToMul(View view) {
        EditText editnum1 = findViewById(R.id.edtNumber1);
        EditText editnum2 =  findViewById(R.id.editNumber2);
        TextView txtResult = findViewById(R.id.txtResult);
        int result =  Integer.parseInt(editnum1.getText().toString()) *Integer.parseInt(editnum2.getText().toString());
        txtResult.setText("Result  = "+ result
        );
    }
}
