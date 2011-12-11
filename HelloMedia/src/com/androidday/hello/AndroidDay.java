package com.androidday.hello;

import android.app.Activity;
import android.os.Bundle;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;

public class AndroidDay extends Activity implements
		OnBufferingUpdateListener, OnCompletionListener,
		MediaPlayer.OnPreparedListener {
	
    private MediaPlayer mMediaPlayer;
    private SurfaceView mPreview;
    private SurfaceHolder holder;
    
    private String path;
    private int mVideoWidth;
    private int mVideoHeight;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        mPreview = (SurfaceView) findViewById(R.id.surface);
        holder = mPreview.getHolder();
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }
    
    private void playVideo() {
    	try {
            // Create a new media player and set the listeners
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDataSource(path);
            mMediaPlayer.setDisplay(holder);
            mMediaPlayer.prepare();
            mMediaPlayer.setOnBufferingUpdateListener(this);
            mMediaPlayer.setOnCompletionListener(this);
            mMediaPlayer.setOnPreparedListener(this);
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    	} catch (Exception e) {
        }
    }
    
    public void onPrepared(MediaPlayer mediaplayer) {
        mVideoWidth = mMediaPlayer.getVideoWidth();
        mVideoHeight = mMediaPlayer.getVideoHeight();
        if (mVideoWidth != 0 && mVideoHeight != 0) {
            holder.setFixedSize(mVideoWidth, mVideoHeight);
            mMediaPlayer.start();
        }
    }
    
    public void onBufferingUpdate(MediaPlayer arg0, int percent) {
    }
    
    public void onCompletion(MediaPlayer arg0) {
    }
    
    public void surfaceCreated(SurfaceHolder holder) {
    	path = "/cache/xmen-origins-wolverine2.mp4";
        playVideo();
    }
}