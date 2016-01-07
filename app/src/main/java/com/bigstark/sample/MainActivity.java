package com.bigstark.sample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bigstark.video.BigstarVideoView;

public class MainActivity extends AppCompatActivity {

    public static final String SAMPLE_URL = "SAMPLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BigstarVideoView videoView = (BigstarVideoView) findViewById(R.id.videoview);
        videoView.setRetainPlayerInstance(true);
        videoView.setVideoURI(Uri.parse(SAMPLE_URL), true);
    }
}
