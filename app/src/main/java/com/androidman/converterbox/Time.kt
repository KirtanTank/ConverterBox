package com.androidman.converterbox

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_time.*
import java.util.*


class Time : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "Second", "MiliSecond", "Minute", "Hour", "Day", "Week", "Month", "Year"
    )
    var scale = 0
    var Second = 1.0
    var Milisecond = 1000.0
    var Minute = 0.0166666667
    var Hour = 0.0002777778
    var Day = 0.0000115741
    var Week = 0.0000016534
    var Month = 0.0000003805
    var Year = 0.000000031709
    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        val animDrawable = time_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes34.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)

        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("Second")
        (list1 as ArrayList<String>).add("Milisecond")
        (list1 as ArrayList<String>).add("Minute")
        (list1 as ArrayList<String>).add("Hour")
        (list1 as ArrayList<String>).add("Day")
        (list1 as ArrayList<String>).add("Week")
        (list1 as ArrayList<String>).add("Month")
        (list1 as ArrayList<String>).add("Year")
        (list2 as ArrayList<String>).add("Second")
        (list2 as ArrayList<String>).add("Milisecond")
        (list2 as ArrayList<String>).add("Minute")
        (list2 as ArrayList<String>).add("Hour")
        (list2 as ArrayList<String>).add("Day")
        (list2 as ArrayList<String>).add("Week")
        (list2 as ArrayList<String>).add("Month")
        (list2 as ArrayList<String>).add("Year")
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,
                list1 as ArrayList<String>)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,
                list2 as ArrayList<String>)
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner1!!.adapter = adapter1
        spinner2!!.adapter = adapter2
        spinner1!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View,
                    position: Int,
                    id: Long,
            ) {
                spinner1!!.setSelection(position)
                if (position == 0) {
                    var1 = Second
                }
                if (position == 1) {
                    var1 = Milisecond
                }
                if (position == 2) {
                    var1 = Minute
                }
                if (position == 3) {
                    var1 = Hour
                }
                if (position == 4) {
                    var1 = Day
                }
                if (position == 5) {
                    var1 = Week
                }
                if (position == 6) {
                    var1 = Month
                }
                if (position == 7) {
                    var1 = Year
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View,
                    position: Int,
                    id: Long,
            ) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = Second
                }
                if (position == 1) {
                    var2 = Milisecond
                }
                if (position == 2) {
                    var2 = Minute
                }
                if (position == 3) {
                    var2 = Hour
                }
                if (position == 4) {
                    var2 = Day
                }
                if (position == 5) {
                    var2 = Week
                }
                if (position == 6) {
                    var2 = Month
                }
                if (position == 7) {
                    var2 = Year
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Time, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                    val value = input_number!!.text.toString()
                    val no = value.toDouble()
                    output = Second / var1
                    output = output * var2
                    output = output * no
                    if (var2 == Second) {
                        scale = 0
                    }
                    if (var2 == Milisecond) {
                        scale = 1
                    }
                    if (var2 == Minute) {
                        scale = 2
                    }
                    if (var2 == Hour) {
                        scale = 3
                    }
                    if (var2 == Day) {
                        scale = 4
                    }
                    if (var2 == Week) {
                        scale = 5
                    }
                    if (var2 == Month) {
                        scale = 6
                    }
                    if (var2 == Year) {
                        scale = 7
                    }
                    show_result!!.text = output.toString() + " " + units[scale]
            }
        })

        imagebutton!!.setOnClickListener(View.OnClickListener {

            MainActivity.redirectActivity(this, MainActivity2::class.java)
            finish()

        })

    }
}

