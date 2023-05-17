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
import kotlinx.android.synthetic.main.activity_illuminance.*
import java.util.*


class Illuminance : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var scale = 0
    var units = arrayOf("lux", "lumen/ft²", "foot-candle", "lumen/cm²", "Phot", "μW/cm²", "candle/cm²", "candle/in²", "Millilambert",
                "candle/m²", "candle/ft²", "hv/micron sq-sec(human retina)", "isomerisations/cone-sec")

    var lux = 1.0
    var lumenft = 0.092903
    var fc = 0.09290327509318529
    var lumencm = 0.00009999999999999999
    var phot = 0.0001
    var microwcm = 0.146413
    var candlecm = 0.00003183101550488765
    var candlein = 0.00020536097963133316
    var millilambert = 0.1
    var candlem = 0.3183101550488765
    var candleft = 0.029571968334505774
    var hvmicron = 11.600036923977985
    var isomerisation = 9.32002902988614
    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_illuminance)

        val animDrawable = illuminance_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes21.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("lux")
        (list1 as ArrayList<String>).add("lumen/ft²")
        (list1 as ArrayList<String>).add("foot-candle")
        (list1 as ArrayList<String>).add("lumen/cm²")
        (list1 as ArrayList<String>).add("Phot")
        (list1 as ArrayList<String>).add("μW/cm²")
        (list1 as ArrayList<String>).add("candle/cm²")
        (list1 as ArrayList<String>).add("candle/in²")
        (list1 as ArrayList<String>).add("Millilambert")
        (list1 as ArrayList<String>).add("candle/m²")
        (list1 as ArrayList<String>).add("candle/ft²")
        (list1 as ArrayList<String>).add("hv/micron sq-sec(human retina)")
        (list1 as ArrayList<String>).add("isomerisations/cone-sec")

        (list2 as ArrayList<String>).add("lux")
        (list2 as ArrayList<String>).add("lumen/ft²")
        (list2 as ArrayList<String>).add("foot-candle")
        (list2 as ArrayList<String>).add("lumen/cm²")
        (list2 as ArrayList<String>).add("Phot")
        (list2 as ArrayList<String>).add("μW/cm²")
        (list2 as ArrayList<String>).add("candle/cm²")
        (list2 as ArrayList<String>).add("candle/in²")
        (list2 as ArrayList<String>).add("Millilambert")
        (list2 as ArrayList<String>).add("candle/m²")
        (list2 as ArrayList<String>).add("candle/ft²")
        (list2 as ArrayList<String>).add("hv/micron sq-sec(human retina)")
        (list2 as ArrayList<String>).add("isomerisations/cone-sec")

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
                    var1 = lux
                }
                if (position == 1) {
                    var1 = lumenft
                }
                if (position == 2) {
                    var1 = fc
                }
                if (position == 3) {
                    var1 = lumencm
                }
                if (position == 4) {
                    var1 = phot
                }
                if (position == 5) {
                    var1 = microwcm
                }
                if (position == 6) {
                    var1 = candlecm
                }
                if (position == 7) {
                    var1 = candlein
                }
                if (position == 8){
                    var1 = millilambert
                }
                if (position == 9){
                    var1 = candlem
                }
                if (position == 10){
                    var1 = candleft
                }
                if (position == 11){
                    var1 = hvmicron
                }
                if (position == 12){
                    var1 = isomerisation
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = lux
                }
                if (position == 1) {
                    var2 = lumenft
                }
                if (position == 2) {
                    var2 = fc
                }
                if (position == 3) {
                    var2 = lumencm
                }
                if (position == 4) {
                    var2 = phot
                }
                if (position == 5) {
                    var2 = microwcm
                }
                if (position == 6) {
                    var2 = candlecm
                }
                if (position == 7) {
                    var2 = candlein
                }
                if (position == 8){
                    var2 = millilambert
                }
                if (position == 9){
                    var2 = candlem
                }
                if (position == 10){
                    var2 = candleft
                }
                if (position == 11){
                    var2 = hvmicron
                }
                if (position == 12){
                    var2 = isomerisation
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Illuminance, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = lux / var1
                output = output * var2
                output = output * no
                if (var2 == lux) {
                    scale = 0
                }
                if (var2 == lumenft) {
                    scale = 1
                }
                if (var2 == fc) {
                    scale = 2
                }
                if (var2 == lumencm) {
                    scale = 3
                }
                if (var2 == phot) {
                    scale = 4
                }
                if (var2 == microwcm) {
                    scale = 5
                }
                if (var2 == candlecm){
                    scale = 6
                }
                if (var2 == candlein){
                    scale = 7
                }
                if (var2 == millilambert){
                    scale = 8
                }
                if (var2 == candlem){
                    scale = 9
                }
                if (var2 == candleft){
                    scale = 10
                }
                if (var2 == hvmicron){
                    scale = 11
                }
                if (var2 == isomerisation){
                    scale = 12
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