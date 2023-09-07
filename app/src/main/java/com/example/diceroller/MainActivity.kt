package com.example.diceroller

import android.media.Image
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

        // Create reference and set action when Roll button pressed
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Roll the dice when the app start
        rollDice()
    }

    private fun rollDice() {
        // Create new Dice object
        val dice = Dice(6)
        // Call roll function in Dice Class that return the random side
        val diceRoll = dice.roll()

        // Update screen with diceRoll
        val diceImage: ImageView = findViewById(R.id.imageView)
        val imageResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView according to diceRoll number
        diceImage.setImageResource(imageResource)

        // Update the image content desc
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val sides: Int) {

    fun roll(): Int {
        return (1..sides).random()
    }
}