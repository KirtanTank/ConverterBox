package com.androidman.converterbox

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_temperature.*
import java.util.*


class Temperature : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "Celcius", "Kelvin", "Fahrenheit", "Rankine Scale", "Rèaumur"
    )
    var scale = 0
    var celsius = 1.0
    var kelvin = 274.15
    var fahrenheit = 33.8
    var rankinescale = 493.47
    var rèaumur = 0.8
    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)

        val animDrawable = temperature_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes33.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)

        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("Celsius")
        (list1 as ArrayList<String>).add("Kelvin")
        (list1 as ArrayList<String>).add("Fahrenheit")
        (list1 as ArrayList<String>).add("Rankine Scale")
        (list1 as ArrayList<String>).add("Rèaumur")
        (list2 as ArrayList<String>).add("Celsius")
        (list2 as ArrayList<String>).add("Kelvin")
        (list2 as ArrayList<String>).add("Fahrenheit")
        (list2 as ArrayList<String>).add("Rankine")
        (list2 as ArrayList<String>).add("Rèaumur")
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
                    var1 = celsius
                }
                if (position == 1) {
                    var1 = kelvin
                }
                if (position == 2) {
                    var1 = fahrenheit
                }
                if (position == 3) {
                    var1 = rankinescale
                }
                if (position == 4) {
                    var1 = rèaumur
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
                    var2 = celsius
                }
                if (position == 1) {
                    var2 = kelvin
                }
                if (position == 2) {
                    var2 = fahrenheit
                }
                if (position == 3) {
                    var2 = rankinescale
                }
                if (position == 4) {
                    var2 = rèaumur
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Temperature, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                    val value = input_number!!.text.toString()
                    val no = value.toDouble()
                    output = celsius / var1
                    output = output * var2
                    output = output * no
                    if (var2 == celsius) {
                        scale = 0
                    }
                    if (var2 == kelvin) {
                        scale = 1
                    }
                    if (var2 == fahrenheit) {
                        scale = 2
                    }
                    if (var2 == rankinescale) {
                        scale = 3
                    }
                    if (var2 == rèaumur) {
                        scale = 4
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