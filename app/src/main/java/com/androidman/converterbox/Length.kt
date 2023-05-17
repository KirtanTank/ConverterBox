package com.androidman.converterbox

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_length.*
import java.util.*


class Length : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf("Meter", "Micrometer", "Decimeter", "Decameter", "Centimeter", "Milimeter", "Kilometer",
            "Mile", "Yard", "Foot", "Inch", "Nautcal Mile", "Fathom", "Link", "Chain", "Furlong", "Mil"
    )
    var scale = 0
    var meter = 1.0
    var decimeter = 10.0
    var decameter = 0.1
    var micrometer = 1000000.0
    var centimeter = 100.0
    var millimeter = 1000.0
    var kilometer = 0.001
    var mile = 0.000621371
    var yard = 1.09361
    var foot = 3.28084
    var inch = 39.3701
    var nauticalmile = 0.000539957
    var fathom = 0.546807
    var link = 4.97097
    var chain = 0.04971
    var furlong = 0.004971
    var mil = 39370.079
    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_length)

        val animDrawable = length_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes22.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)

        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("Meter")
        (list1 as ArrayList<String>).add("Micrometer")
        (list1 as ArrayList<String>).add("Decimeter")
        (list1 as ArrayList<String>).add("Decameter")
        (list1 as ArrayList<String>).add("Centimeter")
        (list1 as ArrayList<String>).add("Millimeter")
        (list1 as ArrayList<String>).add("Kilometer")
        (list1 as ArrayList<String>).add("Mile")
        (list1 as ArrayList<String>).add("Yard")
        (list1 as ArrayList<String>).add("Foot")
        (list1 as ArrayList<String>).add("Inch")
        (list1 as ArrayList<String>).add("Nauticalmile")
        (list1 as ArrayList<String>).add("Fathom")
        (list1 as ArrayList<String>).add("Link")
        (list1 as ArrayList<String>).add("Chain")
        (list1 as ArrayList<String>).add("Furlong")
        (list1 as ArrayList<String>).add("Mil")
        (list2 as ArrayList<String>).add("Meter")
        (list2 as ArrayList<String>).add("Micrometer")
        (list2 as ArrayList<String>).add("Decimeter")
        (list2 as ArrayList<String>).add("Decameter")
        (list2 as ArrayList<String>).add("Centimeter")
        (list2 as ArrayList<String>).add("Millimeter")
        (list2 as ArrayList<String>).add("Kilometer")
        (list2 as ArrayList<String>).add("Mile")
        (list2 as ArrayList<String>).add("Yard")
        (list2 as ArrayList<String>).add("Foot")
        (list2 as ArrayList<String>).add("Inch")
        (list2 as ArrayList<String>).add("Nauticalmile")
        (list2 as ArrayList<String>).add("Fathom")
        (list2 as ArrayList<String>).add("Link")
        (list2 as ArrayList<String>).add("Chain")
        (list2 as ArrayList<String>).add("Furlong")
        (list2 as ArrayList<String>).add("Mil")
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
                    var1 = meter
                }
                if (position == 1) {
                    var1 = micrometer
                }
                if (position == 2) {
                    var1 = decimeter
                }
                if (position == 3) {
                    var1 = decameter
                }
                if (position == 4) {
                    var1 = centimeter
                }
                if (position == 5) {
                    var1 = millimeter
                }
                if (position == 6) {
                    var1 = kilometer
                }
                if (position == 7) {
                    var1 = mile
                }
                if (position == 8) {
                    var1 = yard
                }
                if (position == 9) {
                    var1 = foot
                }
                if (position == 10) {
                    var1 = inch
                }
                if (position == 11) {
                    var1 = nauticalmile
                }
                if (position == 12) {
                    var1 = fathom
                }
                if (position == 13) {
                    var1 = link
                }
                if (position == 14) {
                    var1 = chain
                }
                if (position == 15) {
                    var1 = furlong
                }
                if (position == 16) {
                    var1 = mil
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
                    var2 = meter
                }
                if (position == 1) {
                    var2 = micrometer
                }
                if (position == 2) {
                    var2 = decimeter
                }
                if (position == 3) {
                    var2 = decameter
                }
                if (position == 4) {
                    var2 = centimeter
                }
                if (position == 5) {
                    var2 = millimeter
                }
                if (position == 6) {
                    var2 = kilometer
                }
                if (position == 7) {
                    var2 = mile
                }
                if (position == 8) {
                    var2 = yard
                }
                if (position == 9) {
                    var2 = foot
                }
                if (position == 10) {
                    var2 = inch
                }
                if (position == 11) {
                    var2 = nauticalmile
                }
                if (position == 12) {
                    var2 = fathom
                }
                if (position == 13) {
                    var2 = link
                }
                if (position == 14) {
                    var2 = chain
                }
                if (position == 15) {
                    var2 = furlong
                }
                if (position == 16) {
                    var2 = mil
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        btn!!.setOnClickListener{
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Length, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = meter / var1
                output = output * var2
                output = output * no
                if (var2 == meter) {
                    scale = 0
                }
                if (var2 == micrometer) {
                    scale = 1
                }
                if (var2 == decimeter) {
                    scale = 2
                }
                if (var2 == decameter) {
                    scale = 3
                }
                if (var2 == centimeter) {
                    scale = 4
                }
                if (var2 == millimeter) {
                    scale = 5
                }
                if (var2 == kilometer) {
                    scale = 6
                }
                if (var2 == mile) {
                    scale = 7
                }
                if (var2 == yard) {
                    scale = 8
                }
                if (var2 == foot) {
                    scale = 9
                }
                if (var2 == inch) {
                    scale = 10
                }
                if (var2 == nauticalmile) {
                    scale = 11
                }
                if (var2 == fathom) {
                    scale = 12
                }
                if (var2 == link) {
                    scale = 13
                }
                if (var2 == chain) {
                    scale = 14
                }
                if (var2 == furlong) {
                    scale = 15
                }
                if (var2 == mil) {
                    scale = 16
                }
                show_result!!.text = output.toString() + " " + units[scale]
            }
        }
        imagebutton!!.setOnClickListener(View.OnClickListener {

            MainActivity.redirectActivity(this, MainActivity::class.java)
            finish()

        })

    }
}
