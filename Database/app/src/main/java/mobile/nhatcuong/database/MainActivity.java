package mobile.nhatcuong.database;

import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToPreference(View view) {
        Intent intent = new Intent(this, PreferenceMineActivity.class);
        startActivity(intent);
    }

    public void clickToFile(View view) {
        Intent intent = new Intent(this, MyFileActivity.class);
        startActivity(intent);
    }
}
