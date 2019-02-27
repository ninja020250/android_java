package day01.nhatcuong.day02_activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        private static final int RQ_CODE = 555;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent  =  this.getIntent();
//        String username =  intent.getStringExtra("username");
//        TextView txtUsername =  findViewById(R.id.txtResult);
//        txtUsername.setText(username);
    }

    public void clickToInput(View view) {
        Intent intent = new Intent(this, InputActivity.class);
//        startActivity(intent);
        startActivityForResult(intent, RQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RQ_CODE){
            if(resultCode == RESULT_OK){
                String name =  data.getStringExtra("username");
                TextView txtUsername =  findViewById(R.id.txtResult);
                txtUsername.setText(name);
            }
        }
    }
}
