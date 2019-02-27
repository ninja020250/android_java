package mobile.nhatcuong.database;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MyFileActivity extends AppCompatActivity {
    private int READ_BLOCK_SITE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_file);
        EditText edtName = findViewById(R.id.edtName);
        InputStream is = null;
        BufferedReader br = null;
        InputStreamReader isr = null;
        String str = null;
        try {
            is = this.getResources().openRawResource(R.raw.data);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            while ((str = br.readLine()) != null) {
                edtName.setText(str);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickToSaveInternal(View view) {
        EditText edtName = findViewById(R.id.edtName);
        String str = edtName.getText().toString();
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            fos = openFileOutput("myfile.txt", MODE_WORLD_WRITEABLE);
            osw = new OutputStreamWriter(fos);
            osw.write(str);
            osw.flush();
            Toast.makeText(this, "Save success", Toast.LENGTH_SHORT).show();
            edtName.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                osw.close();
                fos.close();
            } catch (Exception e) {

            }
        }
    }

    public void clickToloadInternal(View view) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            fis = openFileInput("myfile.txt");
            isr = new InputStreamReader(fis);
            char[] buffer = new char[READ_BLOCK_SITE];
            String result = "value: ";
            int charRead;
            while ((charRead = isr.read(buffer)) > 0) {
                String reading = String.copyValueOf(buffer, 0, charRead);
                result += reading;
                buffer = new char[READ_BLOCK_SITE];
            }
            EditText edtName = findViewById(R.id.edtName);
            edtName.setText(result);
            Toast.makeText(this, "Load Success", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

        } finally {
            try {
                isr.close();
                fis.close();
            } catch (Exception ex) {

            }
        }
    }

    public void clickToSaveExternal(View view) {
        EditText edtName = findViewById(R.id.edtName);
        String str = edtName.getText().toString();
        File sdCard = Environment.getExternalStorageDirectory();
        String realPath = sdCard.getAbsolutePath();
        File directory = new File(realPath + "/myFiles");
        directory.mkdir();
        File file = new File(directory, "myfile.txt");
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos);
            osw.write(str);
            osw.flush();
            Toast.makeText(this, "Save success", Toast.LENGTH_SHORT).show();
            edtName.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                osw.close();
                fos.close();
            } catch (Exception e) {

            }
        }

    }
}
