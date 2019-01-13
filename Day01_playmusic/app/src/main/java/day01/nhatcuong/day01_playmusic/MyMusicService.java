package day01.nhatcuong.day01_playmusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyMusicService extends Service {
    MediaPlayer mp_object;
    public MyMusicService() {

    }

    @Override
    public void onCreate() {
        mp_object =  MediaPlayer.create(getApplicationContext(), R.raw.daumua2);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp_object.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mp_object.release();
    }
}
