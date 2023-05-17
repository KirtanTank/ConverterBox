package com.androidman.converterbox

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import com.androidman.converterbox.MainActivity3.Companion.redirectActivity
import kotlinx.android.synthetic.main.activity_fuel.*
import java.util.*


class Fuel : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var scale = 0
    var units = arrayOf("km/l", "miles/l", "km/gallons(US)", "miles/gallons(US)", "km/gallons(UK)", "miles/gallons(UK)", "l/100km", "l/100miles", "gallons(US)/100km", "gallons(US)/100miles", "gallons(UK)/100km", "gallons(UK)/100miles" )

    var kml = 1.0
    var mil = 0.621371
    var kmgalus = 3.785412
    var migalus = 2.352146
    var kmgaluk = 4.55
    var migaluk = 2.824811
    var lkm = 100.0
    var lmil = 161.0
    var galuskm = 26.4
    var galusmil = 42.5
    var galukkm = 22.0
    var galukmil = 35.4
    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fuel)

        val animDrawable = fuel_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes18.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("km/l")
        (list1 as ArrayList<String>).add("miles/l")
        (list1 as ArrayList<String>).add("km/gallons(US)")
        (list1 as ArrayList<String>).add("miles/gallons(US)")
        (list1 as ArrayList<String>).add("km/gallons(UK)")
        (list1 as ArrayList<String>).add("miles/gallons(UK)")
        (list1 as ArrayList<String>).add("l/100km")
        (list1 as ArrayList<String>).add("l/100mils")
        (list1 as ArrayList<String>).add("gallons(US)/100km")
        (list1 as ArrayList<String>).add("gallons(US)/100miles")
        (list1 as ArrayList<String>).add("gallons(UK)/100km")
        (list1 as ArrayList<String>).add("gallons(UK)/100miles")

        (list2 as ArrayList<String>).add("km/l")
        (list2 as ArrayList<String>).add("miles/l")
        (list2 as ArrayList<String>).add("km/gallons(US)")
        (list2 as ArrayList<String>).add("miles/gallons(US)")
        (list2 as ArrayList<String>).add("km/gallons(UK)")
        (list2 as ArrayList<String>).add("miles/gallons(UK)")
        (list2 as ArrayList<String>).add("l/100km")
        (list2 as ArrayList<String>).add("l/100mils")
        (list2 as ArrayList<String>).add("gallons(US)/100km")
        (list2 as ArrayList<String>).add("gallons(US)/100miles")
        (list2 as ArrayList<String>).add("gallons(UK)/100km")
        (list2 as ArrayList<String>).add("gallons(UK)/100miles")

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,
                list1 as ArrayList<String>)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,
                list2 as ArrayList<String>)

        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        spinner1!!.adapter = adapter1
        spinner2!!.adapter = adapter2

        spinner1!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner1!!.setSelection(position)
                if (position == 0) {
                    var1 = kml
                }
                if (position == 1) {
                    var1 = mil
                }
                if (position == 2) {
                    var1 = kmgalus
                }
                if (position == 3) {
                    var1 = migalus
                }
                if (position == 4) {
                    var1 = kmgaluk
                }
                if (position == 5) {
                    var1 = migaluk
                }
                if (position == 6) {
                    var1 = lkm
                }
                if (position == 7) {
                    var1 = lmil
                }
                if (position == 8) {
                    var1 = galuskm
                }
                if (position == 9) {
                    var1 = galusmil
                }
                if (position == 10) {
                    var1 = galukkm
                }
                if (position == 11){
                    var1 = galukmil
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = kml
                }
                if (position == 1) {
                    var2 = mil
                }
                if (position == 2) {
                    var2 = kmgalus
                }
                if (position == 3) {
                    var2 = migalus
                }
                if (position == 4) {
                    var2 = kmgaluk
                }
                if (position == 5) {
                    var2 = migaluk
                }
                if (position == 6) {
                    var2 = lkm
                }
                if (position == 7) {
                    var2 = lmil
                }
                if (position == 8) {
                    var2 = galuskm
                }
                if (position == 9) {
                    var2 = galusmil
                }
                if (position == 10) {
                    var2 = galukkm
                }
                if (position == 11){
                    var2 = galukmil
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Fuel, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {

                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = kml / var1
                output = output * var2
                output = output * no

                if (var2 == kml) {
                    scale = 0
                }
                if (var2 == mil) {
                    scale = 1
                }
                if (var2 == kmgalus) {
                    scale = 2
                }
                if (var2 == migalus) {
                    scale = 3
                }
                if (var2 == kmgaluk) {
                    scale = 4
                }
                if (var2 == migaluk) {
                    scale = 5
                }
                if (var2 == lkm) {
                    scale = 6
                }
                if (var2 == lmil) {
                    scale = 7
                }
                if (var2 == galuskm) {
                    scale = 8
                }
                if (var2 == galusmil){
                    scale = 9
                }
                if (var2 == galukkm){
                    scale = 10
                }
                if (var2 == galukmil){
                    scale = 11
                }

                show_result!!.text = output.toString() + " " + units[scale]
            }
        })

        imagebutton!!.setOnClickListener(View.OnClickListener {
            redirectActivity(this, MainActivity4::class.java)
            finish()

        })
    }
}