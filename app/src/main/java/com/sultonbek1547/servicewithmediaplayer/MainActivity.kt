package com.sultonbek1547.servicewithmediaplayer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.sultonbek1547.servicewithmediaplayer.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, MyService::class.java)
        binding.btnStart.setOnClickListener {
//            startService(intent)

            val worker = PeriodicWorkRequestBuilder<MyServiceWorker>(1, TimeUnit.MINUTES).build()
            WorkManager.getInstance().enqueue(worker)

        }
        binding.btnStop.setOnClickListener {
            stopService(intent)
        }

    }
}