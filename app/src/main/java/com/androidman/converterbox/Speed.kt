package com.androidman.converterbox

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import com.androidman.converterbox.MainActivity.Companion.redirectActivity
import kotlinx.android.synthetic.main.activity_speed.*
import java.util.*


class Speed : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var scale = 0
    var units = arrayOf("m/s", "ft/s", "km/s", "miles/s", "cm/s", "in/s", "yd/s", "m/min", "ft/min", "km/min", "miles/min", "cm/min", "in/min",
           "yd/min", "m/h", "ft/h", "km/h(kmph)", "miles/h(mph)", "cm/h", "in/h", "yd/h", "knot(nutical mi/h)", "knot(UK)", "mach(Speed of Sound)", "min/km", "min/mile")

    var ms = 1.0
    var fts = 3.28084
    var kms = 0.001
    var miles = 0.000621
    var cms = 100.0
    var ins = 39.370078740157
    var yds = 1.0936132983377
    var mmin = 60.0
    var ftmin = 196.85
    var kmmin = 0.06
    var milesmin = 0.0372823
    var cmmin = 6000.0
    var inmin = 2362.2065844146
    var ydmin = 65.616797900262
    var mh = 3600.0
    var fth = 11811.02362205
    var kmph = 3.6
    var mph = 2.237
    var cmh = 360000.0
    var inh = 141732.28346457
    var ydh = 3937.0078740157
    var knot = 1.9438446603753
    var knotuk = 1.9425019425019
    var mach = 0.00292
    var minkm = 16.666667
    var minmile = 26.8224

    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speed)

        val animDrawable = speed_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes32.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)


        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("m/s")
        (list1 as ArrayList<String>).add("ft/s")
        (list1 as ArrayList<String>).add("km/s")
        (list1 as ArrayList<String>).add("miles/s")
        (list1 as ArrayList<String>).add("cm/s")
        (list1 as ArrayList<String>).add("in/s")
        (list1 as ArrayList<String>).add("yd/s")
        (list1 as ArrayList<String>).add("m/min")
        (list1 as ArrayList<String>).add("ft/min")
        (list1 as ArrayList<String>).add("km/min")
        (list1 as ArrayList<String>).add("miles/min")
        (list1 as ArrayList<String>).add("cm/min")
        (list1 as ArrayList<String>).add("in/min")
        (list1 as ArrayList<String>).add("yd/min")
        (list1 as ArrayList<String>).add("m/h")
        (list1 as ArrayList<String>).add("ft/h")
        (list1 as ArrayList<String>).add("km/h(kmph)")
        (list1 as ArrayList<String>).add("miles/h(mph)")
        (list1 as ArrayList<String>).add("cm/h")
        (list1 as ArrayList<String>).add("in/h")
        (list1 as ArrayList<String>).add("yd/h")
        (list1 as ArrayList<String>).add("knot(nutical mi/h)")
        (list1 as ArrayList<String>).add("knot(UK)")
        (list1 as ArrayList<String>).add("mach(speed of sound)")
        (list1 as ArrayList<String>).add("min/km")
        (list1 as ArrayList<String>).add("min/miles")

        (list2 as ArrayList<String>).add("m/s")
        (list2 as ArrayList<String>).add("ft/s")
        (list2 as ArrayList<String>).add("km/s")
        (list2 as ArrayList<String>).add("miles/s")
        (list2 as ArrayList<String>).add("cm/s")
        (list2 as ArrayList<String>).add("in/s")
        (list2 as ArrayList<String>).add("yd/s")
        (list2 as ArrayList<String>).add("m/min")
        (list2 as ArrayList<String>).add("ft/min")
        (list2 as ArrayList<String>).add("km/min")
        (list2 as ArrayList<String>).add("miles/min")
        (list2 as ArrayList<String>).add("cm/min")
        (list2 as ArrayList<String>).add("in/min")
        (list2 as ArrayList<String>).add("yd/min")
        (list2 as ArrayList<String>).add("m/h")
        (list2 as ArrayList<String>).add("ft/h")
        (list2 as ArrayList<String>).add("km/h(kmph)")
        (list2 as ArrayList<String>).add("miles/h(mph)")
        (list2 as ArrayList<String>).add("cm/h")
        (list2 as ArrayList<String>).add("in/h")
        (list2 as ArrayList<String>).add("yd/h")
        (list2 as ArrayList<String>).add("knot(nutical mi/h)")
        (list2 as ArrayList<String>).add("knot(UK)")
        (list2 as ArrayList<String>).add("mach(speed of sound)")
        (list2 as ArrayList<String>).add("min/km")
        (list2 as ArrayList<String>).add("min/miles")

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
                    var1 = ms
                }
                if (position == 1) {
                    var1 = fts
                }
                if (position == 2) {
                    var1 = kms
                }
                if (position == 3) {
                    var1 = miles
                }
                if (position == 4) {
                    var1 = cms
                }
                if (position == 5) {
                    var1 = ins
                }
                if (position == 6) {
                    var1 = yds
                }
                if (position == 7) {
                    var1 = mmin
                }
                if (position == 8){
                    var1 = ftmin
                }
                if (position == 9){
                    var1 = kmmin
                }
                if (position == 10){
                    var1 = milesmin
                }
                if (position == 11){
                    var1 = cmmin
                }
                if (position == 12){
                    var1 = inmin
                }
                if (position == 13){
                    var1 = ydmin
                }
                if (position == 14){
                    var1 = mh
                }
                if (position == 15){
                    var1 = fth
                }
                if (position == 16){
                    var1 = kmph
                }
                if (position == 17){
                    var1 = mph
                }
                if (position == 18) {
                    var1 = cmh
                }
                if (position == 19){
                    var1  = inh
                }
                if (position == 20){
                    var1 = ydh
                }
                if (position == 21){
                    var1 = knot
                }
                if (position == 22){
                    var1 = knotuk
                }
                if (position == 23){
                    var1 = mach
                }
                if (position == 24){
                    var1 = minkm
                }
                if (position == 25){
                    var1 = minmile
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = ms
                }
                if (position == 1) {
                    var2 = fts
                }
                if (position == 2) {
                    var2 = kms
                }
                if (position == 3) {
                    var2 = miles
                }
                if (position == 4) {
                    var2 = cms
                }
                if (position == 5) {
                    var2 = ins
                }
                if (position == 6) {
                    var2 = yds
                }
                if (position == 7) {
                    var2 = mmin
                }
                if (position == 8){
                    var2 = ftmin
                }
                if (position == 9){
                    var2 = kmmin
                }
                if (position == 10){
                    var2 = milesmin
                }
                if (position == 11){
                    var2 = cmmin
                }
                if (position == 12){
                    var2 = inmin
                }
                if (position == 13){
                    var2 = ydmin
                }
                if (position == 14){
                    var2 = mh
                }
                if (position == 15){
                    var2 = fth
                }
                if (position == 16){
                    var2 = kmph
                }
                if (position == 17){
                    var2 = mph
                }
                if (position == 18) {
                    var2 = cmh
                }
                if (position == 19){
                    var2  = inh
                }
                if (position == 20){
                    var2 = ydh
                }
                if (position == 21){
                    var2 = knot
                }
                if (position == 22){
                    var2 = knotuk
                }
                if (position == 23){
                    var2 = mach
                }
                if (position == 24){
                    var2 = minkm
                }
                if (position == 25){
                    var2 = minmile
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Speed, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = ms / var1
                output = output * var2
                output = output * no
                if (var2 == ms) {
                    scale = 0
                }
                if (var2 == fts) {
                    scale = 1
                }
                if (var2 == kms) {
                    scale = 2
                }
                if (var2 == miles) {
                    scale = 3
                }
                if (var2 == cms) {
                    scale = 4
                }
                if (var2 == ins) {
                    scale = 5
                }
                if (var2 == yds){
                    scale = 6
                }
                if (var2 == mmin){
                    scale = 7
                }
                if (var2 == ftmin){
                    scale = 8
                }
                if (var2 == kmmin){
                    scale = 9
                }
                if (var2 == milesmin){
                    scale = 10
                }
                if (var2 == cmmin){
                    scale = 11
                }
                if (var2 == inmin){
                    scale = 12
                }
                if (var2 == ydmin){
                    scale = 13
                }
                if (var2 == mh){
                    scale = 14
                }
                if (var2 == fth){
                    scale = 15
                }
                if (var2 == kmph){
                    scale = 16
                }
                if (var2 == mph){
                    scale = 17
                }
                if (var2 == cmh){
                    scale = 18
                }
                if (var2 == inh){
                    scale = 19
                }
                if (var2 == ydh){
                    scale = 20
                }
                if (var2 == knot){
                    scale = 21
                }
                if (var2 == knotuk){
                    scale = 22
                }
                if (var2 == mach){
                    scale = 23
                }
                if (var2 == minkm){
                    scale = 24
                }
                if (var2 == minmile){
                    scale = 25
                }

                show_result!!.text = output.toString() + " " + units[scale]
            }
        })

        imagebutton!!.setOnClickListener(View.OnClickListener {

            redirectActivity(this, MainActivity2::class.java)
            finish()

        })
    }
}