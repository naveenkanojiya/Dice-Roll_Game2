package com.manu.diceking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.manu.diceking.databinding.ActivityWinnerBinding

class WinnerActivity : AppCompatActivity() {
    private val binding: ActivityWinnerBinding by lazy {
        ActivityWinnerBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val winner = intent.getStringExtra("winner")
        binding.winnerText.text = winner.toString()

        binding.btnBack.setOnClickListener {
            val intent = Intent(this@WinnerActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}