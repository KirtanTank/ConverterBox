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
import kotlinx.android.synthetic.main.activity_flow.*
import java.util.*
import kotlin.collections.ArrayList


class Flow : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "l/sec", "m³/sec", "ft³/sec", "l/min", "m³/min", "ft³/min(CFM)", "l/hr", "m³/hr", "ft³/hr", "m³/day",
            "gal(UK)/min", "gal(US)/min"
    )
    var scale = 0
    var ls = 1.0
    var ms = 0.001
    var fts = 0.035315
    var lmin = 60.0
    var mmin = 0.06
    var cfm = 2.11888
    var lhr = 3600.0
    var mhr = 3.6
    var fthr = 127.1328
    var mday = 86.4
    var galukmin = 13.198155
    var galusmin = 15.850323

    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)

        val animDrawable = flow_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes16.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()

        (list1 as ArrayList<String>).add("l/sec")
        (list1 as ArrayList<String>).add("m³/sec")
        (list1 as ArrayList<String>).add("ft³/sec")
        (list1 as ArrayList<String>).add("l/min")
        (list1 as ArrayList<String>).add("m³/min")
        (list1 as ArrayList<String>).add("ft³/min(CFM)")
        (list1 as ArrayList<String>).add("l/hr")
        (list1 as ArrayList<String>).add("m³/hr")
        (list1 as ArrayList<String>).add("ft³/hr")
        (list1 as ArrayList<String>).add("m³/day")
        (list1 as ArrayList<String>).add("gallon(UK)/min")
        (list1 as ArrayList<String>).add("gallon(US)/min")


        (list2 as ArrayList<String>).add("l/sec")
        (list2 as ArrayList<String>).add("m³/sec")
        (list2 as ArrayList<String>).add("ft³/sec")
        (list2 as ArrayList<String>).add("l/min")
        (list2 as ArrayList<String>).add("m³/min")
        (list2 as ArrayList<String>).add("ft³/min(CFM)")
        (list2 as ArrayList<String>).add("l/hr")
        (list2 as ArrayList<String>).add("m³/hr")
        (list2 as ArrayList<String>).add("ft³/hr")
        (list2 as ArrayList<String>).add("m³/day")
        (list2 as ArrayList<String>).add("gallon(UK)/min")
        (list2 as ArrayList<String>).add("gallon(US)/min")

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
                    var1 = ls
                }
                if (position == 1) {
                    var1 = ms
                }
                if (position == 2) {
                    var1 = fts
                }
                if (position == 3) {
                    var1 = lmin
                }
                if (position == 4) {
                    var1 = mmin
                }
                if (position == 5) {
                    var1 = cfm
                }
                if (position == 6) {
                    var1 = lhr
                }
                if (position == 7) {
                    var1 = mhr
                }
                if (position == 8) {
                    var1 = fthr
                }
                if (position == 9) {
                    var1 = mday
                }
                if (position == 10) {
                    var1 = galukmin
                }
                if (position == 11) {
                    var1 = galusmin
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = ls
                }
                if (position == 1) {
                    var2 = ms
                }
                if (position == 2) {
                    var2 = fts
                }
                if (position == 3) {
                    var2 = lmin
                }
                if (position == 4) {
                    var2 = mmin
                }
                if (position == 5) {
                    var2 = cfm
                }
                if (position == 6) {
                    var2 = lhr
                }
                if (position == 7) {
                    var2 = mhr
                }
                if (position == 8) {
                    var2 = fthr
                }
                if (position == 9) {
                    var2 = mday
                }
                if (position == 10) {
                    var2 = galukmin
                }
                if (position == 11) {
                    var2 = galusmin
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Flow, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = ls / var1
                output = output * var2
                output = output * no
                if (var2 == ls) {
                    scale = 0
                }
                if (var2 == ms) {
                    scale = 1
                }
                if (var2 == fts) {
                    scale = 2
                }
                if (var2 == lmin) {
                    scale = 3
                }
                if (var2 == mmin) {
                    scale = 4
                }
                if (var2 == cfm) {
                    scale = 5
                }
                if (var2 == lhr) {
                    scale = 6
                }
                if (var2 == mhr) {
                    scale = 7
                }
                if (var2 == fthr) {
                    scale = 8
                }
                if (var2 == mday) {
                    scale = 9
                }
                if (var2 == galukmin) {
                    scale = 10
                }
                if (var2 == galusmin) {
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