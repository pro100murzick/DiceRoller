package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll)
        rollButton.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_dice_rolled), Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val drawbleResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawbleResource)
        diceImage.contentDescription = diceRoll.toString()
/*        val diceImage: ImageView = findViewById(R.id.dice_image)
when(diceRoll) {
    1 -> diceImage.setImageResource(R.drawable.dice_1)
    2 -> diceImage.setImageResource(R.drawable.dice_2)
    3 -> diceImage.setImageResource(R.drawable.dice_3)
    4 -> diceImage.setImageResource(R.drawable.dice_4)
    5 -> diceImage.setImageResource(R.drawable.dice_5)
    6 -> diceImage.setImageResource(R.drawable.dice_6)
    }*/

/*        val textView: TextView = findViewById(R.id.roll_number)
textView.text = diceRoll.toString()
}*/

    }

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}