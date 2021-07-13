package udemy.android1.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MusicStoppedListener{
    ImageView ivPlayStop;
    String audioLink="https://dl.dropbox.com/s/5ey5xwb7a5ylqps/games_of_thrones.mp3?dl=0";

    boolean musicPlaying=false;
    Intent serviceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivPlayStop=(ImageView)findViewById(R.id.ivPlayStop);
        ivPlayStop.setImageResource(R.drawable.play);
        serviceIntent=new Intent(this,MyPlayService.class);
        ApplicationClass.context=(Context) MainActivity.this;
        ivPlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!musicPlaying){
                    playAudio();
                    ivPlayStop.setImageResource(R.drawable.stop);
                    musicPlaying=true;
                }
                else{
                    stopPlayService();
                    ivPlayStop.setImageResource(R.drawable.play);
                    musicPlaying=false;
                }
            }
        });
    }

    private void stopPlayService() {
        try{
            stopService(serviceIntent);
        }catch(SecurityException e){
            Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void playAudio() {
        serviceIntent.putExtra("AudioLink",audioLink);
        try{
            startService(serviceIntent);
        }
        catch(SecurityException e){
            Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMusicStopped() {
        ivPlayStop.setImageResource(R.drawable.play);
        musicPlaying=false;
    }
}