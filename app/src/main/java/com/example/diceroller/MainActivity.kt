package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    lateinit var diceImage1:ImageView
    lateinit var gamblingModeSwitch:SwitchMaterial
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener {
            rollDice()
        }

        gamblingModeSwitch = findViewById(R.id.gamblingMode)
        diceImage = findViewById(R.id.diceImage)
        diceImage1 = findViewById(R.id.diceImage1)

        gamblingModeSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Toast.makeText(this,"You have 2 dice now!",Toast.LENGTH_SHORT).show()
                diceImage1.visibility = View.VISIBLE
            }else {
                diceImage1.visibility = View.GONE
            }
        }
    }

    private fun rollDice() {

        val randomFirstDice = Random.nextInt(6) + 1
        val randomSecDice = Random.nextInt(6) + 1
        val drawableResource = when(randomFirstDice) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        val drawableSecResource = when(randomSecDice){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        diceImage.setImageResource(drawableResource)
        diceImage1.setImageResource(drawableSecResource)


    }
}