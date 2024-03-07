package com.hamdiiii.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var btnPlus: Button
    lateinit var btnSubtract:Button
    lateinit var btnMultiplacation:Button
    lateinit var btnDivide:Button
    lateinit var btnResult:Button
    lateinit var txtResult:TextView
    lateinit var btnClear:Button
    var lastNumber =0.0
    var currentOperation :Operation?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initValues()
        addCallBack()

    }

    private fun addCallBack() {
        btnClear.setOnClickListener {
            clearInput()
        }
        btnPlus.setOnClickListener {
            prepareOperation(Operation.Plus)

        }
        btnSubtract.setOnClickListener {
            prepareOperation(Operation.Sub)


        }
        btnMultiplacation.setOnClickListener {
            prepareOperation(Operation.Mul)

        }
        btnDivide.setOnClickListener {
            prepareOperation(Operation.Div)
        }
        btnResult.setOnClickListener {
            val result =doCurrentOperation()
            txtResult.text=result.toString()
        }
    }

    private fun doCurrentOperation():Double {
        val secondNumber = txtResult.text.toString().toDouble()
           return when(currentOperation){
            Operation.Plus -> lastNumber + secondNumber
            Operation.Sub -> lastNumber - secondNumber
            Operation.Mul -> lastNumber * secondNumber
            Operation.Div -> lastNumber / secondNumber
            null -> 0.0
        }
    }

    private fun prepareOperation(operation: Operation) {
        lastNumber=txtResult.text.toString().toDouble()
        clearInput()
         currentOperation= operation
    }

    private fun clearInput() {
        txtResult.text=""
    }

    private fun initValues() {
        btnPlus=findViewById(R.id.txt_sum)
        btnSubtract=findViewById(R.id.btn_subtract)
        btnMultiplacation=findViewById(R.id.btn_multiply)
        btnDivide=findViewById(R.id.btn_divide)
        btnResult=findViewById(R.id.btn_result)
        txtResult=findViewById(R.id.txt_result)
        btnClear=findViewById(R.id.button_digit_clear)
    }

    fun onClickNumber(view: View) {
        val newDigit =(view as Button).text.toString()
        val oldDigit = txtResult.text.toString()
        val newText = oldDigit + newDigit
        txtResult.text = newText
    }

}