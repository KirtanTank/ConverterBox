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
import kotlinx.android.synthetic.main.activity_concentration.*
import java.util.*
import kotlin.collections.ArrayList


class Concentration : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "g/L", "μg/L(ppb)", "mg/L", "%", "ppm"
    )
    var scale = 0
    var gl = 1.0
    var μgl = 1000000.0
    var mgl = 1000.0
    var perc = 0.1
    var ppm = 1000.000002

    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concentration)

        val animDrawable = concentration_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes10.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("g/L")
        (list1 as ArrayList<String>).add("μg/L(ppb)")
        (list1 as ArrayList<String>).add("mg/L")
        (list1 as ArrayList<String>).add("%")
        (list1 as ArrayList<String>).add("ppm")

        (list2 as ArrayList<String>).add("g/L")
        (list2 as ArrayList<String>).add("μg/L(ppb)")
        (list2 as ArrayList<String>).add("mg/L")
        (list2 as ArrayList<String>).add("%")
        (list2 as ArrayList<String>).add("ppm")


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
                    var1 = gl
                }
                if (position == 1) {
                    var1 = μgl
                }
                if (position == 2) {
                    var1 = mgl
                }
                if (position == 3) {
                    var1 = perc
                }
                if (position == 4) {
                    var1 = ppm
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = gl
                }
                if (position == 1) {
                    var2 = μgl
                }
                if (position == 2) {
                    var2 = mgl
                }
                if (position == 3) {
                    var2 = perc
                }
                if (position == 4) {
                    var2 = ppm
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Concentration, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = gl / var1
                output = output * var2
                output = output * no
                if (var2 == gl) {
                    scale = 0
                }
                if (var2 == μgl) {
                    scale = 1
                }
                if (var2 == mgl) {
                    scale = 2
                }
                if (var2 == perc) {
                    scale = 3
                }
                if (var2 == ppm) {
                    scale = 4
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