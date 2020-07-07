package com.learn.kotlin.startactivityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val FIRST_ACTIVITY_REQUEST_CODE = 1
        private const val SECOND_ACTIVITY_REQUEST_CODE = 2

        const val NAME = "name"
        const val EMAIL = "email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Activity with Static value
        firstActivityButton.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            //start activity for first intent
            startActivityForResult(intent, FIRST_ACTIVITY_REQUEST_CODE)
        }

        //Activity with Dynamic value
        secondActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            //start activity for first intent
            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            if(requestCode== FIRST_ACTIVITY_REQUEST_CODE){
                firstActivityResultTextView.text = "First Activity Result Success"
            } else if(requestCode== SECOND_ACTIVITY_REQUEST_CODE){
                secondActivityResultTextView.text = "${data?.getStringExtra(NAME)} => ${data?.getStringExtra(EMAIL)}"
            }
        } else if(resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this@MainActivity, "Result cancelled", Toast.LENGTH_SHORT).show()
        }
    }
}