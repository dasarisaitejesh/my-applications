package com.internshala.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    lateinit var btn0: Button
    lateinit var btn00: Button
    lateinit var btnClear: Button
    lateinit var btnPercent: Button
    lateinit var btnBack: Button
    lateinit var btnMultiplication: Button
    lateinit var btnSubtraction: Button
    lateinit var btnAddition: Button
    lateinit var btnDivision: Button
    lateinit var btnAns: Button
    lateinit var btnDecimal: Button
    lateinit var etInput: EditText
    lateinit var etOutput: EditText
    var check = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)
        btn00 = findViewById(R.id.btn00)
        btnClear = findViewById(R.id.btnClear)
        btnPercent = findViewById(R.id.btnPercent)
        btnBack = findViewById(R.id.btnBack)
        btnMultiplication = findViewById(R.id.btnMultiplication)
        btnSubtraction = findViewById(R.id.btnSubtraction)
        btnAddition = findViewById(R.id.btnAddition)
        btnDivision = findViewById(R.id.btnDivision)
        btnAns = findViewById(R.id.btnAns)
        btnDecimal = findViewById(R.id.btnDecimal)
        etInput = findViewById(R.id.etInput)
        etOutput = findViewById(R.id.etOuput)
        etInput.movementMethod = ScrollingMovementMethod()
        etInput.isActivated = true
        etInput.isPressed = true
        
        var text: String
        
        btn1.setOnClickListener { 
            text = etInput.text.toString()+"1"
            etInput.setText(text)
            result(text)
        }
        btn2.setOnClickListener {
            text = etInput.text.toString()+"2"
            etInput.setText(text)
            result(text)
        }
        btn3.setOnClickListener {
            text = etInput.text.toString()+"3"
            etInput.setText(text)
            result(text)
        }
        btn4.setOnClickListener {
            text = etInput.text.toString()+"4"
            etInput.setText(text)
            result(text)
        }
        btn5.setOnClickListener {
            text = etInput.text.toString()+"5"
            etInput.setText(text)
            result(text)
        }
        btn6.setOnClickListener {
            text = etInput.text.toString()+"6"
            etInput.setText(text)
            result(text)
        }
        btn7.setOnClickListener {
            text = etInput.text.toString()+"7"
            etInput.setText(text)
            result(text)
        }
        btn8.setOnClickListener {
            text = etInput.text.toString()+"8"
            etInput.setText(text)
            result(text)
        }
        btn9.setOnClickListener {
            text = etInput.text.toString()+"9"
            etInput.setText(text)
            result(text)
        }
        btn0.setOnClickListener {
            text = etInput.text.toString()+"0"
            etInput.setText(text)
            result(text)
        }
        btn00.setOnClickListener {
            text = etInput.text.toString()+"00"
            etInput.setText(text)
            result(text)
        }
        btnDecimal.setOnClickListener {
            text = etInput.text.toString()+"."
            etInput.setText(text)
            result(text)
        }

        btnAddition.setOnClickListener {
            text = etInput.text.toString()+"+"
            etInput.setText(text)
            check = check + 1
        }

        btnSubtraction.setOnClickListener {
            text = etInput.text.toString()+"-"
            etInput.setText(text)
            check = check + 1
        }

        btnMultiplication.setOnClickListener {
            text = etInput.text.toString()+"*"
            etInput.setText(text)
            check = check + 1
        }

        btnDivision.setOnClickListener {
            text = etInput.text.toString()+"/"
            etInput.setText(text)
            check = check + 1
        }
        btnPercent.setOnClickListener {
            text = etInput.text.toString()+"%"
            etInput.setText(text)
            check = check + 1
        }

        btnAns.setOnClickListener {
            text = etOutput.text.toString()
            etInput.setText(text)
            etOutput.setText(null)
        }

        btnClear.setOnClickListener {
            etInput.setText(null)
            etOutput.setText(null)
        }

        btnBack.setOnClickListener {
            var backSpace: String?=null

            if(etInput.text.length == 1){
                etInput.setText(null)
            }

            if(etInput.text.length>1){
                val stringBuilder: StringBuilder = StringBuilder(etInput.text)
                val find= etInput.text.toString()
                val find2 = find.last()

                if(find2.equals('+') || find2.equals('-') || find2.equals('*') || find2.equals('/') || find2.equals('%')){
                    check = check - 1
                }

                stringBuilder.deleteCharAt(etInput.text.length-1)
                backSpace= stringBuilder.toString()
                etInput.setText(backSpace)
                result(backSpace)
            }
        }

    }

    private fun result(text: String) {

        val engine: ScriptEngine =ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any=engine.eval(text)
            var mainr=result.toString()
            if(check == 0){
                etOutput.setText(null)
            }
            else {
                etOutput.setText(mainr)
            }
        }
        catch(e: ScriptException){
            Log.d("TAG", "ERROR")
        }

    }
}