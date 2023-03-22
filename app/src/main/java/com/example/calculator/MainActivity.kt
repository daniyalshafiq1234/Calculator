package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var nNumberDisplay: TextView? = null
    private var nExpression: SimpleExpression? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nNumberDisplay = findViewById<View>(R.id.textView1) as TextView
        nExpression = SimpleExpression()
    }

    private fun saveOperand1(){
        try {
            val value = nNumberDisplay!!.text as String
            nExpression!!.operand1 = value.toInt()
        } catch (e: NumberFormatException){
            nExpression!!.operand1 = 0
        }
    }

    private fun saveOperand2(){
        try {
            val value = nNumberDisplay!!.text as String
            nExpression!!.operand2 = value.toInt()
        } catch (e: NumberFormatException){
            nExpression!!.operand2 = 0
        }
    }

    fun goAc(view: View?)
    {
        nExpression!!.clearOperands()
        nNumberDisplay!!.text = "0"
    }

    fun goOperand(view: View){
        val value = nNumberDisplay!!.text as String
        val digit = view.contentDescription as String

        if (value[0] == '0')
            nNumberDisplay!!.text = digit
        else
            nNumberDisplay!!.text = (nNumberDisplay!!.text as String + digit[0])
    }

    fun goOperator(view: View){
        val operator = view.contentDescription as String
        saveOperand1()
        nNumberDisplay!!.text = "0"
        nExpression!!.operator = operator
    }

    fun goCompute(view: View?){
        saveOperand2()
        nNumberDisplay!!.text = nExpression!!.value.toString()
    }
}