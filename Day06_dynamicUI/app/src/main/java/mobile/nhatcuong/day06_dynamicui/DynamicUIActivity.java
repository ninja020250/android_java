package mobile.nhatcuong.day06_dynamicui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DynamicUIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView txtTitle = new TextView(this);
        txtTitle.setText("Dynamic UI");
        txtTitle.setLayoutParams(params);

        TextView txtLabelUsername = new TextView(this);
        txtLabelUsername.setText("Username: ");
        txtLabelUsername.setLayoutParams(params);

        EditText edtUsername = new EditText(this);
        edtUsername.setLayoutParams(params);
        edtUsername.setId(R.id.txtUsername);

        TextView txtLabelFullname = new TextView(this);
        txtLabelFullname.setText("Fullname: ");
        txtLabelFullname.setLayoutParams(params);

        EditText edtFullname = new EditText(this);
        edtFullname.setLayoutParams(params);
        edtFullname.setId(R.id.txtFullname);

        Button btnInput =  new Button(this);
        btnInput.setLayoutParams(params);
        btnInput.setText("Input Data");

        linearLayout.addView(txtTitle);
        linearLayout.addView(txtLabelUsername);
        linearLayout.addView(edtUsername);
        linearLayout.addView(txtLabelFullname);
        linearLayout.addView(edtFullname);
        linearLayout.addView(btnInput);
        this.addContentView(linearLayout, params);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtUsername =  findViewById(R.id.txtUsername);
                TextView txtFullname =  findViewById(R.id.txtFullname);
                Intent intent = new Intent(DynamicUIActivity.this,Result2Activity.class);
                intent.putExtra("username", txtUsername.getText().toString());
                intent.putExtra("fullname", txtFullname.getText().toString());
                startActivity(intent);

            }
        });

    }

}
