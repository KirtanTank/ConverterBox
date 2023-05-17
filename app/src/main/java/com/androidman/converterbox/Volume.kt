package com.androidman.converterbox

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import com.androidman.converterbox.MainActivity.Companion.redirectActivity
import kotlinx.android.synthetic.main.activity_volume.*
import java.util.*


class Volume : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "m³",
            "mm³",
            "cm³",
            "dm³(decimeter) or L(liters)",
            "dm³(decameter)",
            "km³",
            "in³",
            "ft³",
            "yd³",
            "dl(decilitres)",
            "gallon(UK)",
            "gallon(US)",
            "barrels",
            "pint(UK)",
            "pint(US)",
            "fl oz(US)",
            "brass",
            "quart(UK)",
            "quart(US)"
    )
    var scale = 0
    var cbm = 1.0
    var cbmm = 1000000000.0
    var cbcm = 1000000.0
    var cbdeci = 1000.0
    var cbdeca = 0.001
    var cbkm = 0.000000001
    var cbinch = 61023.744
    var cbft = 35.315
    var cbyd = 1.308
    var dl = 10000.0
    var galuk = 219.969249
    var galus = 264.172052
    var barrel = 6.289811
    var ptuk = 1759.75399
    var ptus = 2113.37642
    var flozus = 33814.0227
    var brass = 0.353147
    var quartsuk = 879.877
    var quartsus = 1056.69
    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        val animDrawable = volume_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes39.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("m³")
        (list1 as ArrayList<String>).add("mm³")
        (list1 as ArrayList<String>).add("cm³")
        (list1 as ArrayList<String>).add("dm³(decimeter) or L(liters)")
        (list1 as ArrayList<String>).add("dm³(decameter)")
        (list1 as ArrayList<String>).add("km³")
        (list1 as ArrayList<String>).add("in³")
        (list1 as ArrayList<String>).add("ft³")
        (list1 as ArrayList<String>).add("yd³")
        (list1 as ArrayList<String>).add("dl(decilitres)")
        (list1 as ArrayList<String>).add("gallon(UK)")
        (list1 as ArrayList<String>).add("gallon(US)")
        (list1 as ArrayList<String>).add("barrels")
        (list1 as ArrayList<String>).add("pint(UK)")
        (list1 as ArrayList<String>).add("pint(US)")
        (list1 as ArrayList<String>).add("fl oz(US)")
        (list1 as ArrayList<String>).add("brass")
        (list1 as ArrayList<String>).add("quart(UK)")
        (list1 as ArrayList<String>).add("quart(US)")

        (list2 as ArrayList<String>).add("m³")
        (list2 as ArrayList<String>).add("mm³")
        (list2 as ArrayList<String>).add("cm³")
        (list2 as ArrayList<String>).add("dm³(decimeter) or L(liters)")
        (list2 as ArrayList<String>).add("dm³(decameter)")
        (list2 as ArrayList<String>).add("km³")
        (list2 as ArrayList<String>).add("in³")
        (list2 as ArrayList<String>).add("ft³")
        (list2 as ArrayList<String>).add("yd³")
        (list2 as ArrayList<String>).add("dl(decilitres)")
        (list2 as ArrayList<String>).add("gallon(UK)")
        (list2 as ArrayList<String>).add("gallon(US)")
        (list2 as ArrayList<String>).add("barrels")
        (list2 as ArrayList<String>).add("pint(UK)")
        (list2 as ArrayList<String>).add("pint(US)")
        (list2 as ArrayList<String>).add("fl oz(US)")
        (list2 as ArrayList<String>).add("brass")
        (list2 as ArrayList<String>).add("quart(UK)")
        (list2 as ArrayList<String>).add("quart(US)")

        val adapter1 = ArrayAdapter(
                this, android.R.layout.simple_dropdown_item_1line,
                list1 as ArrayList<String>
        )
        val adapter2 = ArrayAdapter(
                this, android.R.layout.simple_dropdown_item_1line,
                list2 as ArrayList<String>
        )

        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        spinner1!!.adapter = adapter1
        spinner2!!.adapter = adapter2

        spinner1!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View,
                    position: Int,
                    id: Long
            ) {
                spinner1!!.setSelection(position)
                if (position == 0) {
                    var1 = cbm
                }
                if (position == 1) {
                    var1 = cbmm
                }
                if (position == 2) {
                    var1 = cbcm
                }
                if (position == 3) {
                    var1 = cbdeci
                }
                if (position == 4) {
                    var1 = cbdeca
                }
                if (position == 5) {
                    var1 = cbkm
                }
                if (position == 6) {
                    var1 = cbinch
                }
                if (position == 7) {
                    var1 = cbft
                }
                if (position == 8) {
                    var1 = cbyd
                }
                if (position == 9) {
                    var1 = dl
                }
                if (position == 10) {
                    var1 = galuk
                }
                if (position == 11) {
                    var1 = galus
                }
                if (position == 12) {
                    var1 = barrel
                }
                if (position == 13) {
                    var1 = ptuk
                }
                if (position == 14) {
                    var1 = ptus
                }
                if (position == 15) {
                    var1 = flozus
                }
                if (position == 16) {
                    var1 = brass
                }
                if (position == 17) {
                    var1 = quartsuk
                }
                if (position == 18) {
                    var1 = quartsus
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View,
                    position: Int,
                    id: Long
            ) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = cbm
                }
                if (position == 1) {
                    var2 = cbmm
                }
                if (position == 2) {
                    var2 = cbcm
                }
                if (position == 3) {
                    var2 = cbdeci
                }
                if (position == 4) {
                    var2 = cbdeca
                }
                if (position == 5) {
                    var2 = cbkm
                }
                if (position == 6) {
                    var2 = cbinch
                }
                if (position == 7) {
                    var2 = cbft
                }
                if (position == 8) {
                    var2 = cbyd
                }
                if (position == 9) {
                    var2 = dl
                }
                if (position == 10) {
                    var2 = galuk
                }
                if (position == 11) {
                    var2 = galus
                }
                if (position == 12) {
                    var2 = barrel
                }
                if (position == 13) {
                    var2 = ptuk
                }
                if (position == 14) {
                    var2 = ptus
                }
                if (position == 15) {
                    var2 = flozus
                }
                if (position == 16) {
                    var2 = brass
                }
                if (position == 17) {
                    var2 = quartsuk
                }
                if (position == 18) {
                    var2 = quartsus
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Volume, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = cbm / var1
                output = output * var2
                output = output * no
                if (var2 == cbm) {
                    scale = 0
                }
                if (var2 == cbmm) {
                    scale = 1
                }
                if (var2 == cbcm) {
                    scale = 2
                }
                if (var2 == cbdeci) {
                    scale = 3
                }
                if (var2 == cbdeca) {
                    scale = 4
                }
                if (var2 == cbkm) {
                    scale = 5
                }
                if (var2 == cbinch) {
                    scale = 6
                }
                if (var2 == cbft) {
                    scale = 7
                }
                if (var2 == cbyd) {
                    scale = 8
                }
                if (var2 == dl) {
                    scale = 9
                }
                if (var2 == galuk) {
                    scale = 10
                }
                if (var2 == galus) {
                    scale = 11
                }
                if (var2 == barrel) {
                    scale = 12
                }
                if (var2 == ptuk) {
                    scale = 13
                }
                if (var2 == ptus) {
                    scale = 14
                }
                if (var2 == flozus) {
                    scale = 15
                }
                if (var2 == brass) {
                    scale = 16
                }
                if (var2 == quartsuk) {
                    scale = 17
                }
                if (var2 == quartsus) {
                    scale = 18
                }
                show_result!!.text = output.toString() + " " + units[scale]
            }
        })

        imagebutton!!.setOnClickListener(View.OnClickListener {

            redirectActivity(this, MainActivity::class.java)
            finish()

        })
    }
}