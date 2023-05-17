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
import kotlinx.android.synthetic.main.activity_pressure.*
import java.util.*
import kotlin.collections.ArrayList


class Pressure : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf(
            "Pa", "hPa(mbar)", "kPa", "MPa", "bar", "psi(lbf/in²)", "psf(lbf/ft²)", "atm(Standard atmosphere)",
            "ksi", "kgf/cm²", "kgf/m²", "mmHg(Torr)", "cmHg", "inchHg", "mmH₂O", "cmH₂O", "inchH₂O", "Torr", "mTorr"
    )
    var scale = 0
    var pa = 1.0
    var hpa = 0.01
    var kpa = 0.001
    var mpa = 0.000001
    var bar = 0.00001
    var psiin = 0.00014538
    var psfft = 0.020885
    var atm = 0.000009869
    var ksi = 0.00000014504
    var kgfcm = 0.0000102
    var kgfm = 0.102
    var mmhg = 0.00750062
    var cmhg = 0.000750062
    var inchhg = 0.000295
    var mmh20 = 0.101972
    var cmh20 = 0.010197
    var inchh20 = 0.004015
    var torr = 0.007500617
    var mtorr = 7.500617

    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pressure)

        val animDrawable = pressure_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes26.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("Pa")
        (list1 as ArrayList<String>).add("hPa(mbar)")
        (list1 as ArrayList<String>).add("kPa")
        (list1 as ArrayList<String>).add("MPa")
        (list1 as ArrayList<String>).add("bar")
        (list1 as ArrayList<String>).add("psi(lbf/in²)")
        (list1 as ArrayList<String>).add("psf(lbf/ft²)")
        (list1 as ArrayList<String>).add("atm(Standard atmosphere)")
        (list1 as ArrayList<String>).add("ksi")
        (list1 as ArrayList<String>).add("kgf/cm²")
        (list1 as ArrayList<String>).add("kgf/m²")
        (list1 as ArrayList<String>).add("mmHg(Torr)")
        (list1 as ArrayList<String>).add("cmHg")
        (list1 as ArrayList<String>).add("inchHg")
        (list1 as ArrayList<String>).add("mmH₂O")
        (list1 as ArrayList<String>).add("cmH₂O")
        (list1 as ArrayList<String>).add("inchH₂O")
        (list1 as ArrayList<String>).add("Torr")
        (list1 as ArrayList<String>).add("mTorr")

        (list2 as ArrayList<String>).add("Pa")
        (list2 as ArrayList<String>).add("hPa(mbar)")
        (list2 as ArrayList<String>).add("kPa")
        (list2 as ArrayList<String>).add("MPa")
        (list2 as ArrayList<String>).add("bar")
        (list2 as ArrayList<String>).add("psi(lbf/in²)")
        (list2 as ArrayList<String>).add("psf(lbf/ft²)")
        (list2 as ArrayList<String>).add("atm(Standard atmosphere)")
        (list2 as ArrayList<String>).add("ksi")
        (list2 as ArrayList<String>).add("kgf/cm²")
        (list2 as ArrayList<String>).add("kgf/m²")
        (list2 as ArrayList<String>).add("mmHg(Torr)")
        (list2 as ArrayList<String>).add("cmHg")
        (list2 as ArrayList<String>).add("inchHg")
        (list2 as ArrayList<String>).add("mmH₂O")
        (list2 as ArrayList<String>).add("cmH₂O")
        (list2 as ArrayList<String>).add("inchH₂O")
        (list2 as ArrayList<String>).add("Torr")
        (list2 as ArrayList<String>).add("mTorr")

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
                    var1 = pa
                }
                if (position == 1) {
                    var1 = hpa
                }
                if (position == 2) {
                    var1 = kpa
                }
                if (position == 3) {
                    var1 = mpa
                }
                if (position == 4) {
                    var1 = bar
                }
                if (position == 5) {
                    var1 = psiin
                }
                if (position == 6) {
                    var1 = psfft
                }
                if (position == 7) {
                    var1 = atm
                }
                if (position == 8) {
                    var1 = ksi
                }
                if (position == 9) {
                    var1 = kgfcm
                }
                if (position == 10) {
                    var1 = kgfm
                }
                if (position == 11) {
                    var1 = mmhg
                }
                if (position == 12) {
                    var1 = cmhg
                }
                if (position == 13) {
                    var1 = inchhg
                }
                if (position == 14) {
                    var1 = mmh20
                }
                if (position == 15) {
                    var1 = cmh20
                }
                if (position == 16) {
                    var1 = inchh20
                }
                if (position == 17) {
                    var1 = torr
                }
                if (position == 18) {
                    var1 = mtorr
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = pa
                }
                if (position == 1) {
                    var2 = hpa
                }
                if (position == 2) {
                    var2 = kpa
                }
                if (position == 3) {
                    var2 = mpa
                }
                if (position == 4) {
                    var2 = bar
                }
                if (position == 5) {
                    var2 = psiin
                }
                if (position == 6) {
                    var2 = psfft
                }
                if (position == 7) {
                    var2 = atm
                }
                if (position == 8) {
                    var2 = ksi
                }
                if (position == 9) {
                    var2 = kgfcm
                }
                if (position == 10) {
                    var2 = kgfm
                }
                if (position == 11) {
                    var2 = mmhg
                }
                if (position == 12) {
                    var2 = cmhg
                }
                if (position == 13) {
                    var2 = inchhg
                }
                if (position == 14) {
                    var2 = mmh20
                }
                if (position == 15) {
                    var2 = cmh20
                }
                if (position == 16) {
                    var2 = inchh20
                }
                if (position == 17) {
                    var2 = torr
                }
                if (position == 18) {
                    var2 = mtorr
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Pressure, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = pa / var1
                output = output * var2
                output = output * no
                if (var2 == pa) {
                    scale = 0
                }
                if (var2 == hpa) {
                    scale = 1
                }
                if (var2 == kpa) {
                    scale = 2
                }
                if (var2 == mpa) {
                    scale = 3
                }
                if (var2 == bar) {
                    scale = 4
                }
                if (var2 == psiin) {
                    scale = 5
                }
                if (var2 == psfft) {
                    scale = 6
                }
                if (var2 == atm) {
                    scale = 7
                }
                if (var2 == ksi) {
                    scale = 8
                }
                if (var2 == kgfcm) {
                    scale = 9
                }
                if (var2 == kgfm) {
                    scale = 10
                }
                if (var2 == mmhg) {
                    scale = 11
                }
                if (var2 == cmhg) {
                    scale = 12
                }
                if (var2 == inchhg) {
                    scale = 13
                }
                if (var2 == mmh20) {
                    scale = 14
                }
                if (var2 == cmh20) {
                    scale = 15
                }
                if (var2 == inchh20) {
                    scale = 16
                }
                if (var2 == torr) {
                    scale = 17
                }
                if (var2 == mtorr) {
                    scale = 18
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