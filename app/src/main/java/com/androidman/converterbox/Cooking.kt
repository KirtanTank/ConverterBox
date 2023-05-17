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
import kotlinx.android.synthetic.main.activity_cooking.*
import java.util.*


class Cooking : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var scale = 0
    var units = arrayOf("ml(cc)", "teaspoon(US)", "tablespoon(US)", "teaspoon(UK)", "tablespoon(UK)", "cup(US)",
            "cup(UK)", "cup(metric)", "fl oz(US)", "fl oz(UK)", "pint(US)", "pint(UK)", "quart(US)", "quart(UK)")
    var ml = 1.0
    var tspus = 0.202884
    var tabspus = 0.067628
    var tspuk = 0.168936
    var tabspuk = 0.0563121
    var cupus = 0.00416667
    var cupuk = 0.00351951
    var cupmet = 0.004
    var flozus = 0.033814
    var flozuk = 0.035195
    var ptus = 0.002113
    var ptuk = 0.00176
    var qtus = 0.001057
    var qtuk = 0.000879877
    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cooking)

        val animDrawable = cooking_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes11.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("ml(cc)")
        (list1 as ArrayList<String>).add("teaspoon(US)")
        (list1 as ArrayList<String>).add("tablespoon(US)")
        (list1 as ArrayList<String>).add("teaspoon(UK)")
        (list1 as ArrayList<String>).add("tablespoon(UK)")
        (list1 as ArrayList<String>).add("cup(US)")
        (list1 as ArrayList<String>).add("cup(UK)")
        (list1 as ArrayList<String>).add("cup(metric)")
        (list1 as ArrayList<String>).add("fl oz(US)")
        (list1 as ArrayList<String>).add("fl oz(UK)")
        (list1 as ArrayList<String>).add("pint(US)")
        (list1 as ArrayList<String>).add("pint(UK)")
        (list1 as ArrayList<String>).add("quart(US)")
        (list1 as ArrayList<String>).add("quart(UK)")

        (list2 as ArrayList<String>).add("ml(cc)")
        (list2 as ArrayList<String>).add("teaspoon(US)")
        (list2 as ArrayList<String>).add("tablespoon(US)")
        (list2 as ArrayList<String>).add("teaspoon(UK)")
        (list2 as ArrayList<String>).add("tablespoon(UK)")
        (list2 as ArrayList<String>).add("cup(US)")
        (list2 as ArrayList<String>).add("cup(UK)")
        (list2 as ArrayList<String>).add("cup(metric)")
        (list2 as ArrayList<String>).add("fl oz(US)")
        (list2 as ArrayList<String>).add("fl oz(UK)")
        (list2 as ArrayList<String>).add("pint(US)")
        (list2 as ArrayList<String>).add("pint(UK)")
        (list2 as ArrayList<String>).add("quart(US)")
        (list2 as ArrayList<String>).add("quart(UK)")

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
                    var1 = ml
                }
                if (position == 1) {
                    var1 = tspus
                }
                if (position == 2) {
                    var1 = tabspus
                }
                if (position == 3) {
                    var1 = tspuk
                }
                if (position == 4) {
                    var1 = tabspuk
                }
                if (position == 5) {
                    var1 = cupus
                }
                if (position == 6) {
                    var1 = cupuk
                }
                if (position == 7) {
                    var1 = cupmet
                }
                if (position == 8) {
                    var1 = flozus
                }
                if (position == 9) {
                    var1 = flozuk
                }
                if (position == 10) {
                    var1 = ptus
                }
                if (position == 11) {
                    var1 = ptuk
                }
                if (position == 12) {
                    var1 = qtus
                }
                if (position == 13) {
                    var1 = qtuk
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = ml
                }
                if (position == 1) {
                    var2 = tspus
                }
                if (position == 2) {
                    var2 = tabspus
                }
                if (position == 3) {
                    var2 = tspuk
                }
                if (position == 4) {
                    var2 = tabspuk
                }
                if (position == 5) {
                    var2 = cupus
                }
                if (position == 6) {
                    var2 = cupuk
                }
                if (position == 7) {
                    var2 = cupmet
                }
                if (position == 8) {
                    var2 = flozus
                }
                if (position == 9) {
                    var2 = flozuk
                }
                if (position == 10) {
                    var2 = ptus
                }
                if (position == 11) {
                    var2 = ptuk
                }
                if (position == 12) {
                    var2 = qtus
                }
                if (position == 13) {
                    var2 = qtuk
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Cooking, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = ml / var1
                output = output * var2
                output = output * no

                if (var2 == ml) {
                    scale = 0
                }
                if (var2 == tspus) {
                    scale = 1
                }
                if (var2 == tabspus) {
                    scale = 2
                }
                if (var2 == tspuk) {
                    scale = 3
                }
                if (var2 == tabspuk) {
                    scale = 4
                }
                if (var2 == cupus) {
                    scale = 5
                }
                if (var2 == cupuk) {
                    scale = 6
                }
                if (var2 == cupmet) {
                    scale = 7
                }
                if (var2 == flozus) {
                    scale = 8
                }
                if (var2 == flozuk){
                    scale = 9
                }
                if (var2 == ptus){
                    scale = 10
                }
                if (var2 == ptuk){
                    scale = 11
                }
                if (var2 == qtus){
                    scale = 12
                }
                if (var2 == qtuk){
                    scale = 13
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