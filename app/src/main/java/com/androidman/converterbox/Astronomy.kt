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
import kotlinx.android.synthetic.main.activity_astronomy.*
import java.util.*
import kotlin.collections.ArrayList


class Astronomy : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "km", "miles", "light-second", "light-day", "light-month", "light-year", "au(Astronomical unit)", "parsec"
    )
    var scale = 0
    var km = 1.0
    var mile = 0.62132
    var ls = 0.000003336
    var ld = 0.00000000003861
    var lm = 0.0000000000012869
    var ly = 0.0000000000001057
    var au = 0.0000000066845
    var parsec = 0.00000000000003241

    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronomy)


        val animDrawable = astronomy_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes5.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()

        (list1 as ArrayList<String>).add("km")
        (list1 as ArrayList<String>).add("miles")
        (list1 as ArrayList<String>).add("light-second")
        (list1 as ArrayList<String>).add("light-day")
        (list1 as ArrayList<String>).add("light-month")
        (list1 as ArrayList<String>).add("light-year")
        (list1 as ArrayList<String>).add("au(Astronomical unit)")
        (list1 as ArrayList<String>).add("parsec")

        (list2 as ArrayList<String>).add("km")
        (list2 as ArrayList<String>).add("miles")
        (list2 as ArrayList<String>).add("light-second")
        (list2 as ArrayList<String>).add("light-day")
        (list2 as ArrayList<String>).add("light-month")
        (list2 as ArrayList<String>).add("light-year")
        (list2 as ArrayList<String>).add("au(Astronomical unit)")
        (list2 as ArrayList<String>).add("parsec")

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
                    var1 = km
                }
                if (position == 1) {
                    var1 = mile
                }
                if (position == 2) {
                    var1 = ls
                }
                if (position == 3) {
                    var1 = ld
                }
                if (position == 4) {
                    var1 = lm
                }
                if (position == 5) {
                    var1 = ly
                }
                if (position == 6) {
                    var1 = au
                }
                if (position == 7) {
                    var1 = parsec
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = km
                }
                if (position == 1) {
                    var2 = mile
                }
                if (position == 2) {
                    var2 = ls
                }
                if (position == 3) {
                    var2 = ld
                }
                if (position == 4) {
                    var2 = lm
                }
                if (position == 5) {
                    var2 = ly
                }
                if (position == 6) {
                    var2 = au
                }
                if (position == 7) {
                    var2 = parsec
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Astronomy, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = km / var1
                output = output * var2
                output = output * no
                if (var2 == km) {
                    scale = 0
                }
                if (var2 == mile) {
                    scale = 1
                }
                if (var2 == ls) {
                    scale = 2
                }
                if (var2 == ld) {
                    scale = 3
                }
                if (var2 == lm) {
                    scale = 4
                }
                if (var2 == ly) {
                    scale = 5
                }
                if (var2 == au) {
                    scale = 6
                }
                if (var2 == parsec) {
                    scale = 7
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