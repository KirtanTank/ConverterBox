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
import kotlinx.android.synthetic.main.activity_density.*
import java.util.*
import kotlin.collections.ArrayList


class Density : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "g/cm³",
            "g/m³",
            "g/in³",
            "kg/cm³",
            "kg/m³",
            "kg/in³",
            "lb/cm³",
            "lb/m³",
            "lb/in³",
            "lb/ft³",
            "lb/gallon(UK)",
            "lb/gallon(US)",

    )
    var scale = 0
    var gcm = 1.0
    var gm = 1000000.0
    var gin = 16.387
    var kgcm = 0.001
    var kgm = 1000.0
    var kgin = 0.0164
    var lbcm = 0.0022
    var lbm = 2204.623
    var lbin = 0.036127
    var lbft = 62.427961
    var lbgaluk = 10.022413
    var lbgalus = 8.345404

    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_density)

        val animDrawable = density_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes15.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("g/cm³")
        (list1 as ArrayList<String>).add("g/m³")
        (list1 as ArrayList<String>).add("g/in³")
        (list1 as ArrayList<String>).add("kg/cm³")
        (list1 as ArrayList<String>).add("kg/m³")
        (list1 as ArrayList<String>).add("kg/in³")
        (list1 as ArrayList<String>).add("lb/cm³")
        (list1 as ArrayList<String>).add("lb/m³")
        (list1 as ArrayList<String>).add("lb/in³")
        (list1 as ArrayList<String>).add("lb/ft³")
        (list1 as ArrayList<String>).add("lb/gallon(UK)")
        (list1 as ArrayList<String>).add("lb/gallon(US)")


        (list2 as ArrayList<String>).add("g/cm³")
        (list2 as ArrayList<String>).add("g/m³")
        (list2 as ArrayList<String>).add("g/in³")
        (list2 as ArrayList<String>).add("kg/cm³")
        (list2 as ArrayList<String>).add("kg/m³")
        (list2 as ArrayList<String>).add("kg/in³")
        (list2 as ArrayList<String>).add("lb/cm³")
        (list2 as ArrayList<String>).add("lb/m³")
        (list2 as ArrayList<String>).add("lb/in³")
        (list2 as ArrayList<String>).add("lb/ft³")
        (list2 as ArrayList<String>).add("lb/gallon(UK)")
        (list2 as ArrayList<String>).add("lb/gallon(US)")

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
                    var1 = gcm
                }
                if (position == 1) {
                    var1 = gm
                }
                if (position == 2) {
                    var1 = gin
                }
                if (position == 3) {
                    var1 = kgcm
                }
                if (position == 4) {
                    var1 = kgm
                }
                if (position == 5) {
                    var1 = kgin
                }
                if (position == 6) {
                    var1 = lbcm
                }
                if (position == 7) {
                    var1 = lbm
                }
                if (position == 8) {
                    var1 = lbin
                }
                if (position == 9) {
                    var1 = lbft
                }
                if (position == 10) {
                    var1 = lbgaluk
                }
                if (position == 11) {
                    var1 = lbgalus
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = gcm
                }
                if (position == 1) {
                    var2 = gm
                }
                if (position == 2) {
                    var2 = gin
                }
                if (position == 3) {
                    var2 = kgcm
                }
                if (position == 4) {
                    var2 = kgm
                }
                if (position == 5) {
                    var2 = kgin
                }
                if (position == 6) {
                    var2 = lbcm
                }
                if (position == 7) {
                    var2 = lbm
                }
                if (position == 8) {
                    var2 = lbin
                }
                if (position == 9) {
                    var2 = lbft
                }
                if (position == 10) {
                    var2 = lbgaluk
                }
                if (position == 11) {
                    var2 = lbgalus
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Density, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = gcm / var1
                output = output * var2
                output = output * no
                if (var2 == gcm) {
                    scale = 0
                }
                if (var2 == gm) {
                    scale = 1
                }
                if (var2 == gin) {
                    scale = 2
                }
                if (var2 == kgcm) {
                    scale = 3
                }
                if (var2 == kgm) {
                    scale = 4
                }
                if (var2 == kgin) {
                    scale = 5
                }
                if (var2 == lbcm) {
                    scale = 6
                }
                if (var2 == lbm) {
                    scale = 7
                }
                if (var2 == lbin) {
                    scale = 8
                }
                if (var2 == lbft) {
                    scale = 9
                }
                if (var2 == lbgaluk) {
                    scale = 10
                }
                if (var2 == lbgalus) {
                    scale = 11
                }

                show_result!!.text = output.toString() + " " + units[scale]
            }
        })

        imagebutton!!.setOnClickListener(View.OnClickListener {

            redirectActivity(this, MainActivity3::class.java)
            finish()

        })
    }
}