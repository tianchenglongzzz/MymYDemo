package com.example.xiangmu.myapplication.activity.server;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * @packge: com.example.xiangmu.myapplication.activity.server
 * @filename:ImageService
 * @date :${DATA} 18:09
 */
public class ImageService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public ImageService(String name) {
        super("");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
