package me.beracira.uwgymschedule;

import android.util.Log;

import ai.api.AIListener;
import ai.api.model.AIError;
import ai.api.model.AIResponse;

/**
 * Created by hunternan on 30/12/16.
 */

public class MyAIListener implements AIListener {
    @Override
    public void onResult(AIResponse result) {

        // process response object
    }

    @Override
    public void onError(AIError error) {

    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {
        Log.d("tag", "tag");
    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }
}
