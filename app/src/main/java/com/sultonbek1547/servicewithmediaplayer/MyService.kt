package com.sultonbek1547.servicewithmediaplayer

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.os.IBinder
import android.util.Log
import android.widget.Toast


private const val TAG = "MyService"

class MyService : Service() {

    private lateinit var mediaPlayer: MediaPlayer
    override fun onBind(intent: Intent): IBinder? {
        Log.d(TAG, "onBind: ")


        mediaPlayer.start()
        Toast.makeText(this, "Service started MediaPlayer", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onBind: Service started MediaPlayer")

        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand: ")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind: ")
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        Log.d(TAG, "onRebind: ")
        super.onRebind(intent)
    }

    override fun onCreate() {
        val defaultRingtoneUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALL)
        mediaPlayer = MediaPlayer()
        mediaPlayer.setDataSource(this, defaultRingtoneUri)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
        Log.d(TAG, "onCreate: ")
        super.onCreate()
    }

    override fun onDestroy() {
        mediaPlayer.pause()
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }

}