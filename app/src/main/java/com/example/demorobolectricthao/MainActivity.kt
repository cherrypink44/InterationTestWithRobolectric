package com.example.demorobolectricthao

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnOk?.setOnClickListener {
            if (edtNumber1?.text.toString().isEmpty() || edtNumber2?.text.toString().isEmpty()) {
                imgAvatar.setImageResource(R.drawable.ic_cat)

            } else {
                val val1 = Integer.parseInt(edtNumber1?.text.toString())
                val val2 = Integer.parseInt(edtNumber2?.text.toString())
                val answer = val1 + val2
                tvResult?.text = answer.toString()
            }
        }

        btnStartNewActivity?.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}


