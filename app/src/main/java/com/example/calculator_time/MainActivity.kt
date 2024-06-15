package com.example.calculator_time

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbarMain: androidx.appcompat.widget.Toolbar

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText

    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button

    private lateinit var resultTV: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        init()
    }

    fun init(){
        setContentView(R.layout.activity_main)

        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Калькулятор времени"
        toolbarMain.subtitle = "версия 1.1"
        toolbarMain.setLogo(R.drawable.calck_time)

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)

        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonDifBTN = findViewById(R.id.buttonDifBTN)

        resultTV = findViewById(R.id.resultTV)

        buttonSumBTN.setOnClickListener(this)
        buttonDifBTN.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.resetMenuMain -> {
                firstOperandET.text.clear()
                secondOperandET.text.clear()
                resultTV.text = ""
                Toast.makeText(
                    applicationContext,
                    "Данные очищены",
                    Toast.LENGTH_LONG
                ).show()
            }

            R.id.exitMenuMain -> {
                Toast.makeText(
                    applicationContext,
                    "Приложение закрыто",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View) {

        if(firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) return

        val first = firstOperandET.text.toString()
        val second = secondOperandET.text.toString()
        var result = ""
        when(v.id){
            R.id.buttonSumBTN -> {
                result = Operation(first, second).sum()
                Toast.makeText(
                    applicationContext,
                    "Результат: ${Operation(first, second).sum()}",
                    Toast.LENGTH_LONG
                ).show()
            }

            R.id.buttonDifBTN -> {
                result = Operation(first, second).dif()
                Toast.makeText(
                    applicationContext,
                    "Результат: ${Operation(first, second).dif()}",
                    Toast.LENGTH_LONG
                ).show()
            }

            else -> "Error"
        }

        resultTV.text = result
    }
}