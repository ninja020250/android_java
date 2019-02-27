package mobile.nhatcuong.day08_notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;
    private int notiID = 4567;
    private int numMeg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickToSend(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("New Message");
        builder.setContentText("Notification demo: message has received");
        builder.setTicker("Message alert");
        builder.setSmallIcon(R.drawable.ad46bb660d1dcd57d009e73a1ec3cea2);
        builder.setNumber(++numMeg);
        Intent intent=  new Intent(this, NotificationActivity.class);
        TaskStackBuilder stack =  TaskStackBuilder.create(this);
        stack.addNextIntent(intent);
        PendingIntent pendingIntent =  stack.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notiID, builder.build());
    }

    public void clickToCancel(View view) {
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(notiID);
    }

    public void clickToSendMul(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("New Message");
        builder.setContentText("Notification demo: message has received");
        builder.setTicker("Message alert");
        builder.setSmallIcon(R.drawable.ad46bb660d1dcd57d009e73a1ec3cea2);
        builder.setNumber(++numMeg);
        NotificationCompat.InboxStyle inbox  =  new NotificationCompat.InboxStyle();
        String[] events = {"cuong1", "Cuong2", "Cuong3"};
        inbox.setBigContentTitle("lv Up");
        for (int i = 0; i < events.length; i++){
            inbox.addLine(events[i]);
        }
        builder.setStyle(inbox);
        Intent intent=  new Intent(this, NotificationActivity.class);
        TaskStackBuilder stack =  TaskStackBuilder.create(this);
        stack.addNextIntent(intent);
        PendingIntent pendingIntent =  stack.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notiID, builder.build());
    }
}
