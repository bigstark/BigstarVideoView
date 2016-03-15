package com.bigstark.sample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bigstark.video.BigstarVideoView;
import com.bigstark.video.ErrorReason;
import com.bigstark.video.OnPlayStateChangedListener;
import com.bigstark.video.OnPlaybackEventListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "BigstarVideoView";

    public static final String SAMPLE_URL = "https://walterebert.com/playground/video/hls/sintel-trailer.m3u8";

    private BigstarVideoView videoView;
    private Button btnPlay;
    private Button btnPause;
    private Button btnSeekTo10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btn_play);
        btnPause = (Button) findViewById(R.id.btn_pause);
        btnSeekTo10 = (Button) findViewById(R.id.btn_seekto);


        videoView = (BigstarVideoView) findViewById(R.id.videoview);
        videoView.setRetainPlayerInstance(true);
        videoView.setVideoURI(Uri.parse(SAMPLE_URL), true);

        videoView.setOnPlaybackEventListener(new OnPlaybackEventListener() {
            @Override
            public void onPlaying() {
                Log.v(TAG, "onPlaying");
            }

            @Override
            public void onPaused() {
                Log.v(TAG, "onPaused");
            }

            @Override
            public void onStopped() {
                Log.v(TAG, "onStopped");
            }

            @Override
            public void onPositionChanged(int position) {
                Log.v(TAG, "onPositionChanged to " + position);
            }

            @Override
            public void onBufferingUpdate(int buffering) {
                Log.v(TAG, "onBufferingUpdate to " + buffering);
            }

            @Override
            public void onSeekComplete() {
                Log.v(TAG, "onSeekComplete");
            }
        });

        videoView.setOnPlayStateChangedListener(new OnPlayStateChangedListener() {
            @Override
            public void onPrepared() {
                Log.v(TAG, "onPrepared");
            }

            @Override
            public void onError(ErrorReason reason) {
                Log.v(TAG, "onError");
            }

            @Override
            public void onCompletion() {
                Log.v(TAG, "onCompletion");
            }

            @Override
            public void onReleased() {
                Log.v(TAG, "onReleased");
            }
        });


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.start();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.pause();
            }
        });

        btnSeekTo10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.seekTo(10000);
            }
        });
    }
}
