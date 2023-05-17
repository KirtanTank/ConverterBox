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
import kotlinx.android.synthetic.main.activity_power.*
import java.util.*
import kotlin.collections.ArrayList


class Power : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "W", "mW", "kW", "MW", "cal/h", "kcla/s", "kcal/h", "HP(Horsepower)", "PS(Metric Horsepower)", "BTU/h", "BTU/s",
            "TR(Tone of refrigeration)", "BHP(Boiler Horsepower)", "dBm", "ehp(Electrical Horsepower)"
    )
    var scale = 0
    var W = 1.0
    var mw = 1000.0
    var kW = 0.001
    var megaw = 0.000001
    var calh = 859.85
    var kcals = 0.000239
    var kcalh = 0.860421
    var hp = 0.00134102
    var ps = 0.0013596216173039
    var btuh = 3.412142
    var btus = 0.00094782
    var tr = 0.000285
    var bhp = 0.00010194
    var dbm = 30.0
    var ehp = 0.00134048

    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_power)

        val animDrawable = power_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes24.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("W")
        (list1 as ArrayList<String>).add("mW")
        (list1 as ArrayList<String>).add("kW")
        (list1 as ArrayList<String>).add("MW")
        (list1 as ArrayList<String>).add("cal/h")
        (list1 as ArrayList<String>).add("kcal/s")
        (list1 as ArrayList<String>).add("kcal/h")
        (list1 as ArrayList<String>).add("HP(HorsePower)")
        (list1 as ArrayList<String>).add("PS(Metric Horsepower)")
        (list1 as ArrayList<String>).add("BTU/h")
        (list1 as ArrayList<String>).add("BTU/s")
        (list1 as ArrayList<String>).add("TR(Tone of refrigeration)")
        (list1 as ArrayList<String>).add("BHP(Boiler Horsepower)")
        (list1 as ArrayList<String>).add("dBm")
        (list1 as ArrayList<String>).add("ehp(Electrical Horsepower)")


        (list2 as ArrayList<String>).add("W")
        (list2 as ArrayList<String>).add("mW")
        (list2 as ArrayList<String>).add("kW")
        (list2 as ArrayList<String>).add("MW")
        (list2 as ArrayList<String>).add("cal/h")
        (list2 as ArrayList<String>).add("kcal/s")
        (list2 as ArrayList<String>).add("kcal/h")
        (list2 as ArrayList<String>).add("HP(HorsePower)")
        (list2 as ArrayList<String>).add("PS(Metric Horsepower)")
        (list2 as ArrayList<String>).add("BTU/h")
        (list2 as ArrayList<String>).add("BTU/s")
        (list2 as ArrayList<String>).add("TR(Tone of refrigeration)")
        (list2 as ArrayList<String>).add("BHP(Boiler Horsepower)")
        (list2 as ArrayList<String>).add("dBm")
        (list2 as ArrayList<String>).add("ehp(Electrical Horsepower)")

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
                    var1 = W
                }
                if (position == 1) {
                    var1 = mw
                }
                if (position == 2) {
                    var1 = kW
                }
                if (position == 3) {
                    var1 = megaw
                }
                if (position == 4) {
                    var1 = calh
                }
                if (position == 5) {
                    var1 = kcals
                }
                if (position == 6) {
                    var1 = kcalh
                }
                if (position == 7) {
                    var1 = hp
                }
                if (position == 8) {
                    var1 = ps
                }
                if (position == 9) {
                    var1 = btuh
                }
                if (position == 10) {
                    var1 = btus
                }
                if (position == 11) {
                    var1 = tr
                }
                if (position == 12) {
                    var1 = bhp
                }
                if (position == 13) {
                    var1 = dbm
                }
                if (position == 14) {
                    var1 = ehp
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = W
                }
                if (position == 1) {
                    var2 = mw
                }
                if (position == 2) {
                    var2 = kW
                }
                if (position == 3) {
                    var2 = megaw
                }
                if (position == 4) {
                    var2 = calh
                }
                if (position == 5) {
                    var2 = kcals
                }
                if (position == 6) {
                    var2 = kcalh
                }
                if (position == 7) {
                    var2 = hp
                }
                if (position == 8) {
                    var2 = ps
                }
                if (position == 9) {
                    var2 = btuh
                }
                if (position == 10) {
                    var2 = btus
                }
                if (position == 11) {
                    var2 = tr
                }
                if (position == 12) {
                    var2 = bhp
                }
                if (position == 13) {
                    var2 = dbm
                }
                if (position == 14) {
                    var2 = ehp
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Power, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = W / var1
                output = output * var2
                output = output * no
                if (var2 == W) {
                    scale = 0
                }
                if (var2 == mw) {
                    scale = 1
                }
                if (var2 == kW) {
                    scale = 2
                }
                if (var2 == megaw) {
                    scale = 3
                }
                if (var2 == calh) {
                    scale = 4
                }
                if (var2 == kcals) {
                    scale = 5
                }
                if (var2 == kcalh) {
                    scale = 6
                }
                if (var2 == hp) {
                    scale = 7
                }
                if (var2 == ps) {
                    scale = 8
                }
                if (var2 == btuh) {
                    scale = 9
                }
                if (var2 == btus) {
                    scale = 10
                }
                if (var2 == tr) {
                    scale = 11
                }
                if (var2 == bhp) {
                    scale = 12
                }
                if (var2 == dbm) {
                    scale = 13
                }
                if (var2 == ehp) {
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