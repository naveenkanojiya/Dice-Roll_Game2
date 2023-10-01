package com.manu.diceking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.manu.diceking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var multiPlayerLayVisibility =  false
        setContentView(binding.root)



        binding.btRobo.setOnClickListener {
            val intent = Intent(this@MainActivity, PlayerNameActivity::class.java)
            intent.putExtra("plr", "2")
            startActivity(intent)
        }

        binding.btMultiPlr.setOnClickListener {
            multiPlayerLayVisibility = !multiPlayerLayVisibility
            if(multiPlayerLayVisibility) {
                binding.layMultiplayer.visibility = View.VISIBLE
            } else {
                binding.layMultiplayer.visibility = View.INVISIBLE
            }
        }
        binding.playerCount2.setOnClickListener {
            val intent = Intent(this@MainActivity, PlayerNameActivity::class.java)
            intent.putExtra("plr", "2")
            startActivity(intent)
        }

        binding.playerCount4.setOnClickListener {
            val intent = Intent(this@MainActivity, PlayerNameActivity::class.java)
            intent.putExtra("plr", "4")
            startActivity(intent)
        }
        binding.playerCount6.setOnClickListener {
            val intent = Intent(this@MainActivity, PlayerNameActivity::class.java)
            intent.putExtra("plr", "6")
            startActivity(intent)
        }

    }
}