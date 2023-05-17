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
import kotlinx.android.synthetic.main.activity_force.*
import java.util.*
import kotlin.collections.ArrayList


class Force : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "N", "dyne", "daN", "kN", "kgf", "lbf", "kip", "gram-force"
    )
    var scale = 0
    var n = 1.0
    var dyne = 100000.0
    var dan = 0.1
    var kn = 0.001
    var kgf = 0.101972
    var lbf = 0.22489
    var kip = 0.000225
    var gf = 101.971621298

    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_force)

        val animDrawable = force_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes17.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("N")
        (list1 as ArrayList<String>).add("Dyne")
        (list1 as ArrayList<String>).add("daN")
        (list1 as ArrayList<String>).add("kN")
        (list1 as ArrayList<String>).add("kgf")
        (list1 as ArrayList<String>).add("lbf")
        (list1 as ArrayList<String>).add("kip")
        (list1 as ArrayList<String>).add("gram-force")


        (list2 as ArrayList<String>).add("N")
        (list2 as ArrayList<String>).add("Dyne")
        (list2 as ArrayList<String>).add("daN")
        (list2 as ArrayList<String>).add("kN")
        (list2 as ArrayList<String>).add("kgf")
        (list2 as ArrayList<String>).add("lbf")
        (list2 as ArrayList<String>).add("kip")
        (list2 as ArrayList<String>).add("gram-force")


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
                    var1 = n
                }
                if (position == 1) {
                    var1 = dyne
                }
                if (position == 2) {
                    var1 = dan
                }
                if (position == 3) {
                    var1 = kn
                }
                if (position == 4) {
                    var1 = kgf
                }
                if (position == 5) {
                    var1 = lbf
                }
                if (position == 6) {
                    var1 = kip
                }
                if (position == 7) {
                    var1 = gf
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = n
                }
                if (position == 1) {
                    var2 = dyne
                }
                if (position == 2) {
                    var2 = dan
                }
                if (position == 3) {
                    var2 = kn
                }
                if (position == 4) {
                    var2 = kgf
                }
                if (position == 5) {
                    var2 = lbf
                }
                if (position == 6) {
                    var2 = kip
                }
                if (position == 7) {
                    var2 = gf
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Force, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = n / var1
                output = output * var2
                output = output * no
                if (var2 == n) {
                    scale = 0
                }
                if (var2 == dyne) {
                    scale = 1
                }
                if (var2 == dan) {
                    scale = 2
                }
                if (var2 == kn) {
                    scale = 3
                }
                if (var2 == kgf) {
                    scale = 4
                }
                if (var2 == lbf) {
                    scale = 5
                }
                if (var2 == kip) {
                    scale = 6
                }
                if (var2 == gf) {
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