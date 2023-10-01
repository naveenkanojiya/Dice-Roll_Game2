package com.manu.diceking

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.manu.diceking.databinding.ActivityDiceGameBinding
import kotlin.random.Random

class DiceGameActivity : AppCompatActivity() {
    private val binding: ActivityDiceGameBinding by lazy {
        ActivityDiceGameBinding.inflate(layoutInflater)
    }

    private var currentPlayer = 1
    private var p1Score = 0
    private var p2Score = 0
    private var p3Score = 0
    private var p4Score = 0
    private var p5Score = 0
    private var p6Score = 0
    private var targetScore = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val bundle = intent.getStringExtra("plr")!!.toInt()
        playerManger(bundle)
        playerName(bundle)


        //Dice roll btn action------------------------------------------------------
        binding.btStartRoll.setOnClickListener {
            if (targetScore != 0) {
                winner(targetScore)
                randomNumGen()
                val num = randomNumGen()
                diceImg(num)
                scoreManager(num, bundle)
                winner(targetScore)
            } else {
                Toast.makeText(this@DiceGameActivity, "Please Set Target Score", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        //reset the score and target
        binding.btnReset.setOnClickListener {
            currentPlayer = 1
            p1Score = 0
            p2Score = 0
            p3Score = 0
            p4Score = 0
            p5Score = 0
            p6Score = 0
            targetScore = 0
            binding.p1Score.text = "00"
            binding.p2Score.text = "00"
            binding.p3Score.text = "00"
            binding.p4Score.text = "00"
            binding.p5Score.text = "00"
            binding.p6Score.text = "00"
            binding.targetText.text = "00"
        }

        binding.targetPlus.setOnClickListener {
            if (targetScore >= 0) {
                targetScore += 10
                binding.targetText.text = targetScore.toString()
            }
        }

        binding.targetMinus.setOnClickListener {
            if (targetScore > 0) targetScore -= 10
            binding.targetText.text = targetScore.toString()
        }
    }

    //check winner
    private fun winner(targetScore: Int) {
        if (p1Score >= targetScore) {
            val pName = intent.getStringExtra("p1")
            val intent = Intent(this@DiceGameActivity, WinnerActivity::class.java)
            intent.putExtra("winner", pName.toString())
            startActivity(intent)
        } else if (p2Score >= targetScore) {
            val pName = intent.getStringExtra("p2")
            val intent = Intent(this@DiceGameActivity, WinnerActivity::class.java)
            intent.putExtra("winner", pName.toString())
            startActivity(intent)
        } else if (p3Score >= targetScore) {
            val pName = intent.getStringExtra("p3")
            val intent = Intent(this@DiceGameActivity, WinnerActivity::class.java)
            intent.putExtra("winner", pName.toString())
            startActivity(intent)
        } else if (p4Score >= targetScore) {
            val pName = intent.getStringExtra("p4")
            val intent = Intent(this@DiceGameActivity, WinnerActivity::class.java)
            intent.putExtra("winner", pName.toString())
            startActivity(intent)
        } else if (p5Score >= targetScore) {
            val pName = intent.getStringExtra("p5")
            val intent = Intent(this@DiceGameActivity, WinnerActivity::class.java)
            intent.putExtra("winner", pName.toString())
            startActivity(intent)
        } else if (p6Score >= targetScore) {
            val pName = intent.getStringExtra("p6")
            val intent = Intent(this@DiceGameActivity, WinnerActivity::class.java)
            intent.putExtra("winner", pName.toString())
            startActivity(intent)
        }
    }
//getting players name
    private fun playerName(bundle: Int) {
        val p1Name = intent.getStringExtra("p1")
        val p2Name = intent.getStringExtra("p2")
        val p3Name = intent.getStringExtra("p3")
        val p4Name = intent.getStringExtra("p4")
        val p5Name = intent.getStringExtra("p5")
        val p6Name = intent.getStringExtra("p6")
        when (bundle) {
            2 -> {
                binding.p1Text.text = p1Name.toString()
                binding.p2Text.text = p2Name.toString()
            }

            4 -> {
                binding.p1Text.text = p1Name.toString()
                binding.p2Text.text = p2Name.toString()
                binding.p3Text.text = p3Name.toString()
                binding.p4Text.text = p4Name.toString()
            }

            6 -> {
                binding.p1Text.text = p1Name.toString()
                binding.p2Text.text = p2Name.toString()
                binding.p3Text.text = p3Name.toString()
                binding.p4Text.text = p4Name.toString()
                binding.p5Text.text = p5Name.toString()
                binding.p6Text.text = p6Name.toString()
            }
        }
    }

//manage dice indicator for each player
    private fun showIndicator(players: Int) {
        when (players) {
            1 -> {
                binding.p1Indicator.visibility = View.VISIBLE
                binding.p2Indicator.visibility = View.INVISIBLE
                binding.p3Indicator.visibility = View.INVISIBLE
                binding.p4Indicator.visibility = View.INVISIBLE
                binding.p5Indicator.visibility = View.INVISIBLE
                binding.p6Indicator.visibility = View.INVISIBLE

            }

            2 -> {
                binding.p1Indicator.visibility = View.INVISIBLE
                binding.p2Indicator.visibility = View.VISIBLE
                binding.p3Indicator.visibility = View.INVISIBLE
                binding.p4Indicator.visibility = View.INVISIBLE
                binding.p5Indicator.visibility = View.INVISIBLE
                binding.p6Indicator.visibility = View.INVISIBLE

            }

            3 -> {
                binding.p1Indicator.visibility = View.INVISIBLE
                binding.p2Indicator.visibility = View.INVISIBLE
                binding.p3Indicator.visibility = View.VISIBLE
                binding.p4Indicator.visibility = View.INVISIBLE
                binding.p5Indicator.visibility = View.INVISIBLE
                binding.p6Indicator.visibility = View.INVISIBLE

            }

            4 -> {
                binding.p1Indicator.visibility = View.INVISIBLE
                binding.p2Indicator.visibility = View.INVISIBLE
                binding.p3Indicator.visibility = View.INVISIBLE
                binding.p4Indicator.visibility = View.VISIBLE
                binding.p5Indicator.visibility = View.INVISIBLE
                binding.p6Indicator.visibility = View.INVISIBLE

            }

            5 -> {
                binding.p1Indicator.visibility = View.INVISIBLE
                binding.p2Indicator.visibility = View.INVISIBLE
                binding.p3Indicator.visibility = View.INVISIBLE
                binding.p4Indicator.visibility = View.INVISIBLE
                binding.p5Indicator.visibility = View.VISIBLE
                binding.p6Indicator.visibility = View.INVISIBLE

            }

            6 -> {
                binding.p1Indicator.visibility = View.INVISIBLE
                binding.p2Indicator.visibility = View.INVISIBLE
                binding.p3Indicator.visibility = View.INVISIBLE
                binding.p4Indicator.visibility = View.INVISIBLE
                binding.p5Indicator.visibility = View.INVISIBLE
                binding.p6Indicator.visibility = View.VISIBLE

            }
        }
    }

//managing score
    private fun scoreManager(num: Int, playerCount: Int) {
        when (playerCount) {
            2 -> {
                showIndicator(currentPlayer)
                when (currentPlayer) {
                    1 -> {
                        p1Score += num
                        binding.p1Score.text = p1Score.toString()
                        currentPlayer = 2


                    }

                    2 -> {
                        p2Score += num
                        binding.p2Score.text = p2Score.toString()
                        currentPlayer = 1

                    }
                }
            }

            4 -> {
                showIndicator(currentPlayer)
                when (currentPlayer) {
                    1 -> {
                        p1Score += num
                        binding.p1Score.text = p1Score.toString()
                        currentPlayer = 2

                    }

                    2 -> {
                        p2Score += num
                        binding.p2Score.text = p2Score.toString()
                        currentPlayer = 3
                    }

                    3 -> {
                        p3Score += num
                        binding.p3Score.text = p3Score.toString()
                        currentPlayer = 4
                    }

                    4 -> {
                        p4Score += num
                        binding.p4Score.text = p4Score.toString()
                        currentPlayer = 1
                    }
                }
            }

            6 -> {
                showIndicator(currentPlayer)
                when (currentPlayer) {
                    1 -> {
                        p1Score += num
                        binding.p1Score.text = p1Score.toString()
                        currentPlayer = 2
                    }

                    2 -> {
                        p2Score += num
                        binding.p2Score.text = p2Score.toString()
                        currentPlayer = 3
                    }

                    3 -> {
                        p3Score += num
                        binding.p3Score.text = p3Score.toString()
                        currentPlayer = 4
                    }

                    4 -> {
                        p4Score += num
                        binding.p4Score.text = p4Score.toString()
                        currentPlayer = 5
                    }

                    5 -> {
                        p5Score += num
                        binding.p5Score.text = p5Score.toString()
                        currentPlayer = 6
                    }

                    6 -> {
                        p6Score += num
                        binding.p6Score.text = p6Score.toString()
                        currentPlayer = 1
                    }

                }
            }
        }
    }
//generating num frm 1-6
    private fun randomNumGen(): Int {
        return Random.nextInt(1, 7)
    }

    //player layout
    private fun playerManger(players: Int) {
        when (players) {
            2 -> binding.twoLay.visibility = View.VISIBLE
            4 -> binding.fourLay.visibility = View.VISIBLE
            6 -> {
                binding.sixlay.visibility = View.VISIBLE
                binding.fourLay.visibility = View.VISIBLE
            }
        }
    }

    //setting dice img
    private fun diceImg(randomNum: Int) {
        val img = when (randomNum) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            else -> R.drawable.six
        }
        binding.diceImg.setImageResource(img)
    }
}