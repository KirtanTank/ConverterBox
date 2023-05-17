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
import kotlinx.android.synthetic.main.activity_viscosity.*
import java.util.*


class Viscosity : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var scale = 0
    var units = arrayOf("P(g/cm﹒s) or dyn﹒s/cm²", "cP or mPa﹒s", "dP", "mP", "μP", "kg/m﹒s or Pa﹒s(N﹒s/m²) or Pl(Poiseuille)",
            "lb/ft﹒s", "Reyn", "μPa﹒s")

    var p = 1.0
    var cp = 100.0
    var dp = 10.0
    var mp = 1000.0
    var μp = 1000000.0
    var kgms = 0.1
    var lbfts = 0.067197
    var reyn = 0.00001451379
    var μpas = 100000.0

    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viscosity)

        val animDrawable = viscosity_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes37.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()

        (list1 as ArrayList<String>).add("P(g/cm﹒s) or dyn﹒s/cm²")
        (list1 as ArrayList<String>).add("cP or mPa﹒s")
        (list1 as ArrayList<String>).add("dP")
        (list1 as ArrayList<String>).add("mP")
        (list1 as ArrayList<String>).add("μP")
        (list1 as ArrayList<String>).add("kg/m﹒s or Pa﹒s(N﹒s/m²) or Pl(Poiseuille)")
        (list1 as ArrayList<String>).add("lb/ft﹒s")
        (list1 as ArrayList<String>).add("Reyn")
        (list1 as ArrayList<String>).add("μPa﹒s")


        (list2 as ArrayList<String>).add("P(g/cm﹒s) or dyn﹒s/cm²")
        (list2 as ArrayList<String>).add("cP or mPa﹒s")
        (list2 as ArrayList<String>).add("dP")
        (list2 as ArrayList<String>).add("mP")
        (list2 as ArrayList<String>).add("μP")
        (list2 as ArrayList<String>).add("kg/m﹒s or Pa﹒s(N﹒s/m²) or Pl(Poiseuille)")
        (list2 as ArrayList<String>).add("lb/ft﹒s")
        (list2 as ArrayList<String>).add("Reyn")
        (list2 as ArrayList<String>).add("μPa﹒s")

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
                    var1 = p
                }
                if (position == 1) {
                    var1 = cp
                }
                if (position == 2) {
                    var1 = dp
                }
                if (position == 3) {
                    var1 = mp
                }
                if (position == 4) {
                    var1 = μp
                }
                if (position == 5) {
                    var1 = kgms
                }
                if (position == 6) {
                    var1 = lbfts
                }
                if (position == 7) {
                    var1 = reyn
                }
                if (position == 8) {
                    var1 = μpas
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = p
                }
                if (position == 1) {
                    var2 = cp
                }
                if (position == 2) {
                    var2 = dp
                }
                if (position == 3) {
                    var2 = mp
                }
                if (position == 4) {
                    var2 = μp
                }
                if (position == 5) {
                    var2 = kgms
                }
                if (position == 6) {
                    var2 = lbfts
                }
                if (position == 7) {
                    var2 = reyn
                }
                if (position == 8) {
                    var2 = μpas
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Viscosity, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {

                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = p / var1
                output = output * var2
                output = output * no

                if (var2 == p) {
                    scale = 0
                }
                if (var2 == cp) {
                    scale = 1
                }
                if (var2 == dp) {
                    scale = 2
                }
                if (var2 == mp) {
                    scale = 3
                }
                if (var2 == μp) {
                    scale = 4
                }
                if (var2 == kgms) {
                    scale = 5
                }
                if (var2 == lbfts){
                    scale = 6
                }
                if (var2 == reyn){
                    scale = 7
                }
                if (var2 == μpas){
                    scale = 8
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