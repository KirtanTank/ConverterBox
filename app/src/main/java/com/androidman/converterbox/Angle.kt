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
import kotlinx.android.synthetic.main.activity_angle.*
import java.util.*


class Angle : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var scale = 0
    var units = arrayOf("degree", "radian", "milliradian", "minutes", "seconds", "gradian",
            "quadrant", "revolution(circle)", "%", "6400 mil", "6000 mil")
    var degree = 1.0
    var radian = 0.017453292519943
    var milliradian = 17.4533
    var minute = 60.0
    var second = 3600.0
    var gradian = 1.11111
    var quadrant = 0.0111111111
    var revolution = 0.00277778
    var per = 1.745506
    var mil1 = 17.777778
    var mil2 = 16.666667
    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_angle)

        val animDrawable = angle_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes3.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("Degree")
        (list1 as ArrayList<String>).add("Radian")
        (list1 as ArrayList<String>).add("Milliradian")
        (list1 as ArrayList<String>).add("Minutes")
        (list1 as ArrayList<String>).add("Seconds")
        (list1 as ArrayList<String>).add("Gradian")
        (list1 as ArrayList<String>).add("Quadrant")
        (list1 as ArrayList<String>).add("Revolution(circle)")
        (list1 as ArrayList<String>).add("%")
        (list1 as ArrayList<String>).add("6400 mil")
        (list1 as ArrayList<String>).add("6000 mil")

        (list2 as ArrayList<String>).add("Degree")
        (list2 as ArrayList<String>).add("Radian")
        (list2 as ArrayList<String>).add("Milliradian")
        (list2 as ArrayList<String>).add("Minute")
        (list2 as ArrayList<String>).add("Second")
        (list2 as ArrayList<String>).add("Gradian")
        (list2 as ArrayList<String>).add("Quadrant")
        (list2 as ArrayList<String>).add("Revolution(circle)")
        (list2 as ArrayList<String>).add("%")
        (list2 as ArrayList<String>).add("6400 mil")
        (list2 as ArrayList<String>).add("6000 mil")

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
                    var1 = degree
                }
                if (position == 1) {
                    var1 = radian
                }
                if (position == 2) {
                    var1 = milliradian
                }
                if (position == 3) {
                    var1 = minute
                }
                if (position == 4) {
                    var1 = second
                }
                if (position == 5) {
                    var1 = gradian
                }
                if (position == 6) {
                    var1 = quadrant
                }
                if (position == 7) {
                    var1 = revolution
                }
                if (position == 8) {
                    var1 = per
                }
                if (position == 9) {
                    var1 = mil1
                }
                if (position == 10) {
                    var1 = mil2
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = degree
                }
                if (position == 1) {
                    var2 = radian
                }
                if (position == 2) {
                    var2 = milliradian
                }
                if (position == 3) {
                    var2 = minute
                }
                if (position == 4) {
                    var2 = second
                }
                if (position == 5) {
                    var2 = gradian
                }
                if (position == 6) {
                    var2 = quadrant
                }
                if (position == 7) {
                    var2 = revolution
                }
                if (position == 8) {
                    var2 = per
                }
                if (position == 9) {
                    var2 = mil1
                }
                if (position == 10) {
                    var2 = mil2
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Angle, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {

                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = degree / var1
                output = output * var2
                output = output * no

                if (var2 == degree) {
                    scale = 0
                }
                if (var2 == radian) {
                    scale = 1
                }
                if (var2 == milliradian) {
                    scale = 2
                }
                if (var2 == minute) {
                    scale = 3
                }
                if (var2 == second) {
                    scale = 4
                }
                if (var2 == gradian) {
                    scale = 5
                }
                if (var2 == quadrant) {
                    scale = 6
                }
                if (var2 == revolution) {
                    scale = 7
                }
                if (var2 == per) {
                    scale = 8
                }
                if (var2 == mil1){
                    scale = 9
                }
                if (var2 == mil2){
                    scale = 10
                }

                show_result!!.text = output.toString() + " " + units[scale]
            }
        })

        imagebutton!!.setOnClickListener(View.OnClickListener {

            redirectActivity(this, MainActivity4::class.java)
            finish()

        })

    }
}