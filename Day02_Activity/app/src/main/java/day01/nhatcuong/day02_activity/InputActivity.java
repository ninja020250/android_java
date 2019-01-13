package day01.nhatcuong.day02_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    public void clickToDone(View view) {
        EditText edtUsername = findViewById(R.id.editUsername);
        // Intent intent =  new Intent(this, MainActivity.class);
        Intent intent = this.getIntent();
        intent.putExtra("username", edtUsername.getText().toString());
        this.setResult(RESULT_OK, intent);
        finish();
//        startActivity(intent);
    }
}
