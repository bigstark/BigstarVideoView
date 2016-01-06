package com.bigstark.video;

/**
 * Created by bigstark on 16. 1. 6..
 */
public interface OnPlayStateChangedListener {

    /**
     * Called when video play state is prepared.
     */
    void onPrepared();


    /**
     * Called when video is not loaded by error.
     *
     * @param reason
     */
    void onError(ErrorReason reason);


    /**
     * Called when video is ended.
     */
    void onCompletion();


    /**
     * Called when video is released.
     */
    void onReleased();
}
