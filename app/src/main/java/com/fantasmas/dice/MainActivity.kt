package com.fantasmas.dice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val firstDice = Dice(6)
        val secondDice = Dice(6)
        val imageFirstRoll: ImageView = findViewById(R.id.firstDice)
        val imageSecondRoll: ImageView = findViewById(R.id.secondDice)

        fun setDrawable(dice: Dice, image: ImageView){
            when (dice.roll()) {
                1 -> image.setImageResource(R.drawable.dice_1)
                2 -> image.setImageResource(R.drawable.dice_2)
                3 -> image.setImageResource(R.drawable.dice_3)
                4 -> image.setImageResource(R.drawable.dice_4)
                5 -> image.setImageResource(R.drawable.dice_5)
                6 -> image.setImageResource(R.drawable.dice_6)
            }
        }

        setDrawable(firstDice, imageFirstRoll)
        setDrawable(secondDice, imageSecondRoll)
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}