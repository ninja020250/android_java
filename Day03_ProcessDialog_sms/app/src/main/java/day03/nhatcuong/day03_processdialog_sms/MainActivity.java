package day03.nhatcuong.day03_processdialog_sms;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    ProgressDialog my_progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button my_button = findViewById(R.id.btnProgress);
        my_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_progressbar  =  new ProgressDialog(MainActivity.this);
                my_progressbar.setMessage("loading...");
                my_progressbar.setTitle("please wait");
                my_progressbar.setProgressStyle(my_progressbar.STYLE_HORIZONTAL);
                my_progressbar.setProgress(0);
                my_progressbar.setMax(100);
                my_progressbar.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while(my_progressbar.getProgress() < my_progressbar.getMax()){
                                Thread.sleep(1000);
                                handler.sendMessage(handler.obtainMessage());
                            }
                            if(my_progressbar.getProgress() == my_progressbar.getMax()){
                                my_progressbar.dismiss();
                            }
                        }catch (Exception e){

                        }
                    }
                }).start();
            }
                Handler handler =  new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        my_progressbar.incrementProgressBy(2);
                    }
                };
        });
    }

    public void sendSMS(View view) {
        Intent intent  =  new Intent(this, sendSMSActivity.class);
        startActivity(intent);
    }
}
