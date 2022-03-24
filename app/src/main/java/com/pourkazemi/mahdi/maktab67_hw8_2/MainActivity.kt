package com.pourkazemi.mahdi.maktab67_hw8_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.pourkazemi.mahdi.maktab67_hw8_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    enum class Turn
    {
        NOUGHT,
        CROSS
    }

    private var firstTurn = Turn.CROSS
    private var currentTurn = Turn.CROSS

    private var crossesScore = 0
    private var noughtsScore = 0

    private var boardList = mutableListOf<Button>()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBoard()
    }
    private fun initBoard()
    {
        boardList.addAll(listOf(
            binding.btnA1,
            binding.btnA2,
            binding.btnA3,
            binding.btnB1,
            binding.btnB2,
            binding.btnB3,
            binding.btnC1,
            binding.btnC2,
            binding.btnC3
        ))
    }

    fun buttonClicked(view: View)
    {
        if(view !is Button)
            return
        addToBoard(view)

        if(checkForVictory(NOUGHT))
        {
            noughtsScore++
            result("Noughts Win!")
        }
        else if(checkForVictory(CROSS))
        {
            crossesScore++
            result("Crosses Win!")
        }

        if(fullBoard())
        {
            result("Draw")
        }

    }

    private fun checkForVictory(s: String): Boolean
    {
        //Horizontal Victory
        if(match(binding.btnA1,s) && match(binding.btnA2,s) && match(binding.btnA3,s))
            return true
        if(match(binding.btnB1,s) && match(binding.btnB2,s) && match(binding.btnB3,s))
            return true
        if(match(binding.btnC3,s) && match(binding.btnC2,s) && match(binding.btnC1,s))
            return true

        //Vertical Victory
        if(match(binding.btnA1,s) && match(binding.btnB1,s) && match(binding.btnC1,s))
            return true
        if(match(binding.btnA2,s) && match(binding.btnB2,s) && match(binding.btnC2,s))
            return true
        if(match(binding.btnA3,s) && match(binding.btnB3,s) && match(binding.btnC3,s))
            return true

        //Diagonal Victory
        if(match(binding.btnA1,s) && match(binding.btnB2,s) && match(binding.btnC3,s))
            return true
        if(match(binding.btnA3,s) && match(binding.btnB2,s) && match(binding.btnC1,s))
            return true

        return false
    }

    private fun match(button: Button, symbol : String): Boolean = button.text == symbol

    private fun result(title: String)
    {
        val message = "\nNoughts $noughtsScore\n\nCrosses $crossesScore"
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Reset")
            { _,_ ->
                resetBoard()
            }
            .setCancelable(false)
            .show()
    }

    private fun resetBoard()
    {
        for(button in boardList)
        {
            button.text = ""
        }

        if(firstTurn == Turn.NOUGHT)
            firstTurn = Turn.CROSS
        else if(firstTurn == Turn.CROSS)
            firstTurn = Turn.NOUGHT

        currentTurn = firstTurn
        setTurnLabel()
    }

    private fun fullBoard(): Boolean
    {
        for(button in boardList)
        {
            if(button.text == "")
                return false
        }
        return true
    }

    private fun addToBoard(button: Button)
    {
        if(button.text != "")
            return

        if(currentTurn == Turn.NOUGHT)
        {
            button.text = NOUGHT
            currentTurn = Turn.CROSS
        }
        else if(currentTurn == Turn.CROSS)
        {
            button.text = CROSS
            currentTurn = Turn.NOUGHT
        }
        setTurnLabel()
    }

    private fun setTurnLabel()
    {
        var turnText = ""
        if(currentTurn == Turn.CROSS)
            turnText = "Turn $CROSS"
        else if(currentTurn == Turn.NOUGHT)
            turnText = "Turn $NOUGHT"

        binding.textView.text = turnText
    }

    companion object
    {
        const val NOUGHT = "O"
        const val CROSS = "X"
    }

}