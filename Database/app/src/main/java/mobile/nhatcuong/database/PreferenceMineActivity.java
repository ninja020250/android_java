package mobile.nhatcuong.database;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PreferenceMineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_mine);
    }

    public void clickToLoad(View view) {
        Intent intent =  new Intent(this, MyPreferenceActivity.class);
        startActivity(intent);
    }

    public void clickToDisplay(View view) {
        SharedPreferences sharedPreferences =  getSharedPreferences("mobile.nhatcuong.database_preferences", MODE_PRIVATE);
        String data =  sharedPreferences.getString("edtPreference", "");
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    public void clickToModify(View view) {
        SharedPreferences sharedPreferences =  getSharedPreferences("mobile.nhatcuong.database_preferences", MODE_PRIVATE);
        EditText edtValue =  findViewById(R.id.edtValue);
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        editor.putString("edtPreference", edtValue.getText().toString());
        editor.commit();
    }
}
