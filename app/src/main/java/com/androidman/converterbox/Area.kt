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
import kotlinx.android.synthetic.main.activity_area.*
import java.util.*
import kotlin.collections.ArrayList


class Area : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "km²", "mm²", "cm²", "dm²(decimeter)", "dm²(decameter)", "m²", "in²",
            "ft²", "yd²", "mile²", "acre", "hectares", "Gunta", "Cent(dismil)", "Bigha(Kaccha)"
    )
    var scale = 0
    var sqkm = 1.0
    var sqmm = 1000000000000.0
    var sqcenti = 10000000000.0
    var sqdeci = 100000000.0
    var sqdeca = 10000.0
    var sqm = 1000000.0
    var sqinch = 1550000000.0
    var sqfeet = 10760000.0
    var sqyard = 1196000.0
    var sqmile = 0.386102
    var acre = 247.105
    var hectere = 100.0
    var gunta = 9884.21526
    var cent = 24710.5381
    var bigha = 1186.10583
    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area)

        val animDrawable = area_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes4.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("km²")
        (list1 as ArrayList<String>).add("mm²")
        (list1 as ArrayList<String>).add("cm²")
        (list1 as ArrayList<String>).add("dm²(decimeter)")
        (list1 as ArrayList<String>).add("dm²(decameter)")
        (list1 as ArrayList<String>).add("m²")
        (list1 as ArrayList<String>).add("in²")
        (list1 as ArrayList<String>).add("ft²")
        (list1 as ArrayList<String>).add("yd²")
        (list1 as ArrayList<String>).add("mile²")
        (list1 as ArrayList<String>).add("acre")
        (list1 as ArrayList<String>).add("hectare")
        (list1 as ArrayList<String>).add("Gunta")
        (list1 as ArrayList<String>).add("Cent(dismil)")
        (list1 as ArrayList<String>).add("Bigha(Kaccha)")

        (list2 as ArrayList<String>).add("km²")
        (list2 as ArrayList<String>).add("mm²")
        (list2 as ArrayList<String>).add("cm²")
        (list2 as ArrayList<String>).add("dm²(decimeter)")
        (list2 as ArrayList<String>).add("dm²(decameter)")
        (list2 as ArrayList<String>).add("m²")
        (list2 as ArrayList<String>).add("in²")
        (list2 as ArrayList<String>).add("ft²")
        (list2 as ArrayList<String>).add("yd²")
        (list2 as ArrayList<String>).add("mile²")
        (list2 as ArrayList<String>).add("acre")
        (list2 as ArrayList<String>).add("hectare")
        (list2 as ArrayList<String>).add("Gunta")
        (list2 as ArrayList<String>).add("Cent(dismil)")
        (list2 as ArrayList<String>).add("Bigha(Kaccha)")

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
                    var1 = sqkm
                }
                if (position == 1) {
                    var1 = sqmm
                }
                if (position == 2) {
                    var1 = sqcenti
                }
                if (position == 3) {
                    var1 = sqdeci
                }
                if (position == 4) {
                    var1 = sqdeca
                }
                if (position == 5) {
                    var1 = sqm
                }
                if (position == 6) {
                    var1 = sqinch
                }
                if (position == 7) {
                    var1 = sqfeet
                }
                if (position == 8) {
                    var1 = sqyard
                }
                if (position == 9) {
                    var1 = sqmile
                }
                if (position == 10) {
                    var1 = acre
                }
                if (position == 11) {
                    var1 = hectere
                }
                if (position == 12) {
                    var1 = gunta
                }
                if (position == 13) {
                    var1 = cent
                }
                if (position == 14) {
                    var1 = bigha
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = sqkm
                }
                if (position == 1) {
                    var2 = sqmm
                }
                if (position == 2) {
                    var2 = sqcenti
                }
                if (position == 3) {
                    var2 = sqdeci
                }
                if (position == 4) {
                    var2 = sqdeca
                }
                if (position == 5) {
                    var2 = sqm
                }
                if (position == 6) {
                    var2 = sqinch
                }
                if (position == 7) {
                    var2 = sqfeet
                }
                if (position == 8) {
                    var2 = sqyard
                }
                if (position == 9) {
                    var2 = sqmile
                }
                if (position == 10) {
                    var2 = acre
                }
                if (position == 11) {
                    var2 = hectere
                }
                if (position == 12) {
                    var2 = gunta
                }
                if (position == 13) {
                    var2 = cent
                }
                if (position == 14) {
                    var2 = bigha
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Area, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = sqkm / var1
                output = output * var2
                output = output * no
                if (var2 == sqkm) {
                    scale = 0
                }
                if (var2 == sqmm) {
                    scale = 1
                }
                if (var2 == sqcenti) {
                    scale = 2
                }
                if (var2 == sqdeci) {
                    scale = 3
                }
                if (var2 == sqdeca) {
                    scale = 4
                }
                if (var2 == sqm) {
                    scale = 5
                }
                if (var2 == sqinch) {
                    scale = 6
                }
                if (var2 == sqfeet) {
                    scale = 7
                }
                if (var2 == sqyard) {
                    scale = 8
                }
                if (var2 == sqmile) {
                    scale = 9
                }
                if (var2 == acre) {
                    scale = 10
                }
                if (var2 == hectere) {
                    scale = 11
                }
                if (var2 == gunta) {
                    scale = 12
                }
                if (var2 == cent) {
                    scale = 13
                }
                if (var2 == bigha) {
                    scale = 14
                }
                show_result!!.text = output.toString() + " " + units[scale]
            }
        })

        imagebutton!!.setOnClickListener(View.OnClickListener {

            redirectActivity(this, MainActivity::class.java)
            finish()

        })

    }
}