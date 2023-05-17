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
import kotlinx.android.synthetic.main.activity_voltage.*
import java.util.*
import kotlin.collections.ArrayList


class Voltage : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "V(Volt)", "mV", "kV", "MV", "EMU(abV)", "ESU(stV)"
    )
    var scale = 0
    var v = 1.0
    var mv = 1000000000000.0
    var kv = 10000000000.0
    var megav = 100000000.0
    var abv = 10000.0
    var stv = 1000000.0

    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voltage)

        val animDrawable = voltage_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes38.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("V(Volt)")
        (list1 as ArrayList<String>).add("mV")
        (list1 as ArrayList<String>).add("kV")
        (list1 as ArrayList<String>).add("MV")
        (list1 as ArrayList<String>).add("EMU(abV)")
        (list1 as ArrayList<String>).add("ESU(stV)")


        (list2 as ArrayList<String>).add("V(Volt)")
        (list2 as ArrayList<String>).add("mV")
        (list2 as ArrayList<String>).add("kV")
        (list2 as ArrayList<String>).add("MV")
        (list2 as ArrayList<String>).add("EMU(abV)")
        (list2 as ArrayList<String>).add("ESU(stV)")


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
                    var1 = v
                }
                if (position == 1) {
                    var1 = mv
                }
                if (position == 2) {
                    var1 = kv
                }
                if (position == 3) {
                    var1 = megav
                }
                if (position == 4) {
                    var1 = abv
                }
                if (position == 5) {
                    var1 = stv
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = v
                }
                if (position == 1) {
                    var2 = mv
                }
                if (position == 2) {
                    var2 = kv
                }
                if (position == 3) {
                    var2 = megav
                }
                if (position == 4) {
                    var2 = abv
                }
                if (position == 5) {
                    var2 = stv
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Voltage, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = v / var1
                output = output * var2
                output = output * no
                if (var2 == v) {
                    scale = 0
                }
                if (var2 == mv) {
                    scale = 1
                }
                if (var2 == kv) {
                    scale = 2
                }
                if (var2 == megav) {
                    scale = 3
                }
                if (var2 == abv) {
                    scale = 4
                }
                if (var2 == stv) {
                    scale = 5
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