package com.sultonbek1547.servicewithmediaplayer

import android.content.Context
import android.media.RingtoneManager
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters

private const val TAG = "MyServiceWorker"

class MyServiceWorker(private val context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        Log.d(TAG, "doWork: ")
        val ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        val ringtone = RingtoneManager.getRingtone(context, ringtoneUri)

        // Create a handler that runs on the main thread
        val handler = Handler(context.mainLooper)

        handler.post {
            // Play the ringtone on the main thread
            ringtone.play()
            Toast.makeText(context, "started", Toast.LENGTH_SHORT).show()
        }

        return Result.success()
    }


}