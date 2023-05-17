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
import kotlinx.android.synthetic.main.activity_torque.*
import java.util.*
import kotlin.collections.ArrayList


class Torque : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "Nm", "daN﹒m", "dN﹒m", "kN﹒m", "cN﹒m", "N﹒mm", "kgf﹒m", "kgf﹒cm",  "ozf﹒in", "lbf﹒in", "lbf﹒ft",
            "gf﹒cm", "gf﹒m", "tfm", "tfcm"
    )
    var scale = 0
    var nm = 1.0
    var danm = 0.1
    var dnm = 10.0
    var knm = 0.001
    var cnm = 100.0
    var nmm = 1000.0
    var kgfm = 0.1019716
    var kgfcm = 10.19716
    var ozfin = 141.6119
    var lbfin = 8.850748
    var lbfft = 0.7375621
    var gfcm = 10197.0
    var gfm = 102.0
    var tfm = 0.000102
    var tfcm = 0.0102
    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_torque)

        val animDrawable = torque_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes36.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("Nm")
        (list1 as ArrayList<String>).add("daN﹒m")
        (list1 as ArrayList<String>).add("dN﹒m")
        (list1 as ArrayList<String>).add("kN﹒m")
        (list1 as ArrayList<String>).add("cN﹒m")
        (list1 as ArrayList<String>).add("N﹒mm")
        (list1 as ArrayList<String>).add("kgf﹒m")
        (list1 as ArrayList<String>).add("kgf﹒cm")
        (list1 as ArrayList<String>).add("ozf﹒in")
        (list1 as ArrayList<String>).add("lbf﹒in")
        (list1 as ArrayList<String>).add("lbf﹒ft")
        (list1 as ArrayList<String>).add("gf﹒cm")
        (list1 as ArrayList<String>).add("gf﹒m")
        (list1 as ArrayList<String>).add("tfm")
        (list1 as ArrayList<String>).add("tfcm")

        (list2 as ArrayList<String>).add("Nm")
        (list2 as ArrayList<String>).add("daN﹒m")
        (list2 as ArrayList<String>).add("dN﹒m")
        (list2 as ArrayList<String>).add("kN﹒m")
        (list2 as ArrayList<String>).add("cN﹒m")
        (list2 as ArrayList<String>).add("N﹒mm")
        (list2 as ArrayList<String>).add("kgf﹒m")
        (list2 as ArrayList<String>).add("kgf﹒cm")
        (list2 as ArrayList<String>).add("ozf﹒in")
        (list2 as ArrayList<String>).add("lbf﹒in")
        (list2 as ArrayList<String>).add("lbf﹒ft")
        (list2 as ArrayList<String>).add("gf﹒cm")
        (list2 as ArrayList<String>).add("gf﹒m")
        (list2 as ArrayList<String>).add("tfm")
        (list2 as ArrayList<String>).add("tfcm")

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
                    var1 = nm
                }
                if (position == 1) {
                    var1 = danm
                }
                if (position == 2) {
                    var1 = dnm
                }
                if (position == 3) {
                    var1 = knm
                }
                if (position == 4) {
                    var1 = cnm
                }
                if (position == 5) {
                    var1 = nmm
                }
                if (position == 6) {
                    var1 = kgfm
                }
                if (position == 7) {
                    var1 = kgfcm
                }
                if (position == 8) {
                    var1 = ozfin
                }
                if (position == 9) {
                    var1 = lbfin
                }
                if (position == 10) {
                    var1 = lbfft
                }
                if (position == 11) {
                    var1 = gfcm
                }
                if (position == 12) {
                    var1 = gfm
                }
                if (position == 13) {
                    var1 = tfm
                }
                if (position == 14) {
                    var1 = tfcm
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = nm
                }
                if (position == 1) {
                    var2 = danm
                }
                if (position == 2) {
                    var2 = dnm
                }
                if (position == 3) {
                    var2 = knm
                }
                if (position == 4) {
                    var2 = cnm
                }
                if (position == 5) {
                    var2 = nmm
                }
                if (position == 6) {
                    var2 = kgfm
                }
                if (position == 7) {
                    var2 = kgfcm
                }
                if (position == 8) {
                    var2 = ozfin
                }
                if (position == 9) {
                    var2 = lbfin
                }
                if (position == 10) {
                    var2 = lbfft
                }
                if (position == 11) {
                    var2 = gfcm
                }
                if (position == 12) {
                    var2 = gfm
                }
                if (position == 13) {
                    var2 = tfm
                }
                if (position == 14) {
                    var2 = tfcm
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Torque, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = nm / var1
                output = output * var2
                output = output * no
                if (var2 == nm) {
                    scale = 0
                }
                if (var2 == danm) {
                    scale = 1
                }
                if (var2 == dnm) {
                    scale = 2
                }
                if (var2 == knm) {
                    scale = 3
                }
                if (var2 == cnm) {
                    scale = 4
                }
                if (var2 == nmm) {
                    scale = 5
                }
                if (var2 == kgfm) {
                    scale = 6
                }
                if (var2 == kgfcm) {
                    scale = 7
                }
                if (var2 == ozfin) {
                    scale = 8
                }
                if (var2 == lbfin) {
                    scale = 9
                }
                if (var2 == lbfft) {
                    scale = 10
                }
                if (var2 == gfcm) {
                    scale = 11
                }
                if (var2 == gfm) {
                    scale = 12
                }
                if (var2 == tfm) {
                    scale = 13
                }
                if (var2 == tfcm) {
                    scale = 14
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