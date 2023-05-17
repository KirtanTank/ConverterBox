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
import kotlinx.android.synthetic.main.activity_work.*
import java.util.*


class Work : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "J",
            "kJ",
            "cal",
            "gcal",
            "kcal",
            "W﹒h",
            "kW﹒h",
            "kgf﹒m",
            "in﹒lbf",
            "ft﹒lbf",
            "British thermal unit(BTU)",
            "US therm",
            "toe",
            "Electronvolt"

    )
    var scale = 0
    var j = 1.0
    var kj = 1000000000.0
    var cal = 1000000.0
    var gcal = 0.239006
    var kcal = 0.000239
    var wh = 0.000277778
    var kwh = 0.000002778
    var kgfm = 0.101972
    var inlbf = 8.85
    var ftlbf = 0.738
    var btu = 0.000948
    var ustherm = 0.00000000948043
    var toe = 0.000000000024
    var electronvolt = 6242000000000000000.0

    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        val animDrawable = work_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes41.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("J")
        (list1 as ArrayList<String>).add("kJ")
        (list1 as ArrayList<String>).add("cal")
        (list1 as ArrayList<String>).add("gcal")
        (list1 as ArrayList<String>).add("kcal")
        (list1 as ArrayList<String>).add("W﹒h")
        (list1 as ArrayList<String>).add("kW﹒h")
        (list1 as ArrayList<String>).add("kgf﹒m")
        (list1 as ArrayList<String>).add("in﹒lbf")
        (list1 as ArrayList<String>).add("ft﹒lbf")
        (list1 as ArrayList<String>).add("British thermal unit(BTU)")
        (list1 as ArrayList<String>).add("US therm")
        (list1 as ArrayList<String>).add("toe")
        (list1 as ArrayList<String>).add("Electronvolt")

        (list2 as ArrayList<String>).add("J")
        (list2 as ArrayList<String>).add("kJ")
        (list2 as ArrayList<String>).add("cal")
        (list2 as ArrayList<String>).add("gcal")
        (list2 as ArrayList<String>).add("kcal")
        (list2 as ArrayList<String>).add("W﹒h")
        (list2 as ArrayList<String>).add("kW﹒h")
        (list2 as ArrayList<String>).add("kgf﹒m")
        (list2 as ArrayList<String>).add("in﹒lbf")
        (list2 as ArrayList<String>).add("ft﹒lbf")
        (list2 as ArrayList<String>).add("British thermal unit(BTU)")
        (list2 as ArrayList<String>).add("US therm")
        (list2 as ArrayList<String>).add("toe")
        (list2 as ArrayList<String>).add("Electronvolt")

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
                    var1 = j
                }
                if (position == 1) {
                    var1 = kj
                }
                if (position == 2) {
                    var1 = cal
                }
                if (position == 3) {
                    var1 = gcal
                }
                if (position == 4) {
                    var1 = kcal
                }
                if (position == 5) {
                    var1 = wh
                }
                if (position == 6) {
                    var1 = kwh
                }
                if (position == 7) {
                    var1 = kgfm
                }
                if (position == 8) {
                    var1 = inlbf
                }
                if (position == 9) {
                    var1 = ftlbf
                }
                if (position == 10) {
                    var1 = btu
                }
                if (position == 11) {
                    var1 = ustherm
                }
                if (position == 12) {
                    var1 = toe
                }
                if (position == 13) {
                    var1 = electronvolt
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
                    var2 = j
                }
                if (position == 1) {
                    var2 = kj
                }
                if (position == 2) {
                    var2 = cal
                }
                if (position == 3) {
                    var2 = gcal
                }
                if (position == 4) {
                    var2 = kcal
                }
                if (position == 5) {
                    var2 = wh
                }
                if (position == 6) {
                    var2 = kwh
                }
                if (position == 7) {
                    var2 = kgfm
                }
                if (position == 8) {
                    var2 = inlbf
                }
                if (position == 9) {
                    var2 = ftlbf
                }
                if (position == 10) {
                    var2 = btu
                }
                if (position == 11) {
                    var2 = ustherm
                }
                if (position == 12) {
                    var2 = toe
                }
                if (position == 13) {
                    var2 = electronvolt
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Work, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = j / var1
                output = output * var2
                output = output * no
                if (var2 == j) {
                    scale = 0
                }
                if (var2 == kj) {
                    scale = 1
                }
                if (var2 == cal) {
                    scale = 2
                }
                if (var2 == gcal) {
                    scale = 3
                }
                if (var2 == kcal) {
                    scale = 4
                }
                if (var2 == wh) {
                    scale = 5
                }
                if (var2 == kwh) {
                    scale = 6
                }
                if (var2 == kgfm) {
                    scale = 7
                }
                if (var2 == inlbf) {
                    scale = 8
                }
                if (var2 == ftlbf) {
                    scale = 9
                }
                if (var2 == btu) {
                    scale = 10
                }
                if (var2 == ustherm) {
                    scale = 11
                }
                if (var2 == toe) {
                    scale = 12
                }
                if (var2 == electronvolt) {
                    scale = 13
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