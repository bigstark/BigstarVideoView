package com.bigstark.video;

/**
 * Created by bigstark on 16. 1. 6..
 */
public interface OnPlaybackEventListener {

    /**
     * Called when playback starts.
     */
    void onPlaying();


    /**
     * Called when playback pauses.
     */
    void onPaused();


    /**
     * Called when palyback stops.
     */
    void onStopped();


    /**
     * Called when position changed. Interval is 128ms.
     *
     * @param position : position of video.
     */
    void onPositionChanged(int position);


    /**
     * Called when buffering updated.
     *
     * @param buffering : 0 to 100
     */
    void onBufferingUpdate(int buffering);


    /**
     * Called when playback completes seek.
     */
    void onSeekComplete();

}