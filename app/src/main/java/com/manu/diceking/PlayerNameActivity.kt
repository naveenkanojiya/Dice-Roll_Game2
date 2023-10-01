package com.manu.diceking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.manu.diceking.databinding.ActivityPlayerNameBinding

class PlayerNameActivity : AppCompatActivity() {
    private val binding: ActivityPlayerNameBinding by lazy {
        ActivityPlayerNameBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val bundle = intent.getStringExtra("plr")!!.toInt()

        binding.btHome.setOnClickListener {
            val intent = Intent(this@PlayerNameActivity, MainActivity::class.java)
            startActivity(intent)
        }

        when(bundle) {
            2 -> {
                binding.p1Name.visibility = View.VISIBLE
                binding.p2Name.visibility = View.VISIBLE
            }
            4 -> {
                binding.p1Name.visibility = View.VISIBLE
                binding.p2Name.visibility = View.VISIBLE
                binding.p3Name.visibility = View.VISIBLE
                binding.p4Name.visibility = View.VISIBLE
            }
            6 -> {
                binding.p1Name.visibility = View.VISIBLE
                binding.p2Name.visibility = View.VISIBLE
                binding.p3Name.visibility = View.VISIBLE
                binding.p4Name.visibility = View.VISIBLE
                binding.p5Name.visibility = View.VISIBLE
                binding.p6Name.visibility = View.VISIBLE

            }
        }

        binding.btSkip.setOnClickListener {
            when(bundle) {
                2 -> {
                    val intent = Intent(this@PlayerNameActivity, DiceGameActivity::class.java)
                    intent.putExtra("p1", "Player 1")
                    intent.putExtra("p2", "Player 2")
                    intent.putExtra("plr",bundle.toString())
                    startActivity(intent)
                }
                4 -> {
                    val intent = Intent(this@PlayerNameActivity, DiceGameActivity::class.java)
                    intent.putExtra("p1", "Player 1")
                    intent.putExtra("p2", "Player 2")
                    intent.putExtra("p3", "Player 3")
                    intent.putExtra("p4", "Player 4")
                    intent.putExtra("plr",bundle.toString())
                    startActivity(intent)
                }
                6 -> {
                    val intent = Intent(this@PlayerNameActivity, DiceGameActivity::class.java)
                    intent.putExtra("p1", "Player 1")
                    intent.putExtra("p2", "Player 2")
                    intent.putExtra("p3", "Player 3")
                    intent.putExtra("p4", "Player 4")
                    intent.putExtra("p5", "Player 5")
                    intent.putExtra("p6", "Player 6")
                    intent.putExtra("plr",bundle.toString())
                    startActivity(intent)
                }
            }
        }

        binding.button.setOnClickListener {
            nameNext(bundle)
        }

    }

    private fun nameNext(bundle: Int) {
        when(bundle) {
            2 -> {
                val intent = Intent(this@PlayerNameActivity, DiceGameActivity::class.java)
                intent.putExtra("p1", binding.p1Name.text.toString())
                intent.putExtra("p2", binding.p2Name.text.toString())
                intent.putExtra("plr",bundle.toString())
                startActivity(intent)
            }
            4 -> {
                val intent = Intent(this@PlayerNameActivity, DiceGameActivity::class.java)
                intent.putExtra("p1", binding.p1Name.text.toString())
                intent.putExtra("p2", binding.p2Name.text.toString())
                intent.putExtra("p3", binding.p3Name.text.toString())
                intent.putExtra("p4", binding.p4Name.text.toString())
                intent.putExtra("plr",bundle.toString())
                startActivity(intent)
            }
            6 -> {
                val intent = Intent(this@PlayerNameActivity, DiceGameActivity::class.java)
                intent.putExtra("p1", binding.p1Name.text.toString())
                intent.putExtra("p2", binding.p2Name.text.toString())
                intent.putExtra("p3", binding.p3Name.text.toString())
                intent.putExtra("p4", binding.p4Name.text.toString())
                intent.putExtra("p5", binding.p5Name.text.toString())
                intent.putExtra("p6", binding.p6Name.text.toString())
                intent.putExtra("plr",bundle.toString())
                startActivity(intent)
            }
        }
    }
}