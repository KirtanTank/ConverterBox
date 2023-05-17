package com.androidman.converterbox

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import kotlinx.android.synthetic.main.activity_weight.*
import java.util.ArrayList

class Weight : AppCompatActivity() {
    var imagebutton: ImageView? = null
    private var inputnumber: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    private var showresult: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "Kilogram", "Gram", "Miligram", "Microgram", "Pound", "Ounce",
            "Stone", "Tonne", "Quintal", "Ratti", "Grain", "Carat", "Tola"
    )
    var scale = 0
    var Kilogram = 1.0
    var Gram = 1000.0
    var Milligram = 1000000.0
    var Microgram = 1000000000.0
    var Pound = 2.204623
    var Ounce = 35.274
    var Stone = 0.1575
    var Tonne = 0.001
    var Quintal = 0.01
    var Ratti = 5494.50549
    var Grain = 15432.358
    var Carat = 5000.0
    var Tola = 85.73526
    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)

        val animDrawable = weight_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes40.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)

        inputnumber = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        showresult = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("Kilogram")
        (list1 as ArrayList<String>).add("Gram")
        (list1 as ArrayList<String>).add("Milligram")
        (list1 as ArrayList<String>).add("Microgram")
        (list1 as ArrayList<String>).add("Pound")
        (list1 as ArrayList<String>).add("Ounces")
        (list1 as ArrayList<String>).add("Stone")
        (list1 as ArrayList<String>).add("Tonne")
        (list1 as ArrayList<String>).add("Quintal")
        (list1 as ArrayList<String>).add("Ratti")
        (list1 as ArrayList<String>).add("Grain")
        (list1 as ArrayList<String>).add("Carat")
        (list1 as ArrayList<String>).add("Tola")

        (list2 as ArrayList<String>).add("Kilogram")
        (list2 as ArrayList<String>).add("Gram")
        (list2 as ArrayList<String>).add("Milligram")
        (list2 as ArrayList<String>).add("Microgram")
        (list2 as ArrayList<String>).add("Pound")
        (list2 as ArrayList<String>).add("Ounces")
        (list2 as ArrayList<String>).add("Stone")
        (list2 as ArrayList<String>).add("Tonne")
        (list2 as ArrayList<String>).add("Quintal")
        (list2 as ArrayList<String>).add("Ratti")
        (list2 as ArrayList<String>).add("Grain")
        (list2 as ArrayList<String>).add("Carat")
        (list2 as ArrayList<String>).add("Tola")

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, list1 as ArrayList<String>)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, list2 as ArrayList<String>)
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner1!!.adapter = adapter1
        spinner2!!.adapter = adapter2
        spinner1!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner1!!.setSelection(position)
                if (position == 0) {
                    var1 = Kilogram
                }
                if (position == 1) {
                    var1 = Gram
                }
                if (position == 2) {
                    var1 = Milligram
                }
                if (position == 3) {
                    var1 = Microgram
                }
                if (position == 4) {
                    var1 = Pound
                }
                if (position == 5) {
                    var1 = Ounce
                }
                if (position == 6) {
                    var1 = Stone
                }
                if (position == 7) {
                    var1 = Tonne
                }
                if (position == 8) {
                    var1 = Quintal
                }
                if (position == 9) {
                    var1 = Ratti
                }
                if (position == 10) {
                    var1 = Grain
                }
                if (position == 11) {
                    var1 = Carat
                }
                if (position == 12) {
                    var1 = Tola
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = Kilogram
                }
                if (position == 1) {
                    var2 = Gram
                }
                if (position == 2) {
                    var2 = Milligram
                }
                if (position == 3) {
                    var2 = Microgram
                }
                if (position == 4) {
                    var2 = Pound
                }
                if (position == 5) {
                    var2 = Ounce
                }
                if (position == 6) {
                    var2 = Stone
                }
                if (position == 7) {
                    var2 = Tonne
                }
                if (position == 8) {
                    var2 = Quintal
                }
                if (position == 9) {
                    var2 = Ratti
                }
                if (position == 10) {
                    var2 = Grain
                }
                if (position == 11) {
                    var2 = Carat
                }
                if (position == 12) {
                    var2 = Tola
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (inputnumber!!.length() == 0) {
                Toast.makeText(this@Weight, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = inputnumber!!.text.toString()
                val no = value.toDouble()
                output = Kilogram / var1
                output = output * var2
                output = output * no

                if (var2 == Kilogram) {
                    scale = 0
                }
                if (var2 == Gram) {
                    scale = 1
                }
                if (var2 == Milligram) {
                    scale = 2
                }
                if (var2 == Microgram) {
                    scale = 3
                }
                if (var2 == Pound) {
                    scale = 4
                }
                if (var2 == Ounce) {
                    scale = 5
                }
                if (var2 == Stone) {
                    scale = 6
                }
                if (var2 == Tonne) {
                    scale = 7
                }
                if (var2 == Quintal) {
                    scale = 8
                }
                if (var2 == Ratti) {
                    scale = 9
                }
                if (var2 == Grain) {
                    scale = 10
                }
                if (var2 == Carat) {
                    scale = 11
                }
                if (var2 == Tola) {
                    scale = 12
                }
                showresult!!.text = output.toString() + " " + units[scale]
            }
        })

        imagebutton!!.setOnClickListener(View.OnClickListener {

            MainActivity.redirectActivity(this, MainActivity::class.java)
            finish()

        })

    }
}