package com.androidman.converterbox

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import com.androidman.converterbox.MainActivity4.Companion.redirectActivity
import kotlinx.android.synthetic.main.activity_blood_sugar.*
import java.util.*


class BloodSugar : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var scale = 0
    var units = arrayOf("mg/dL (eAG)", "mmol/L(eAG)", "NGSP HbA1c (%)", "IFCC HbA1c (mmol/mol)")

    var mgdl = 1.0
    var mmoll = 0.0555
    var hba1c = 1.626719
    var mmolmol = -5.718936
    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blood_sugar)


        val animDrawable = bloodsugar_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes7.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("mg/dL(eAG)")
        (list1 as ArrayList<String>).add("mmol/L(eAG)")
        (list1 as ArrayList<String>).add("NGSP HbA1c(%)")
        (list1 as ArrayList<String>).add("IFCC HbA1c(mmol/mol)")


        (list2 as ArrayList<String>).add("mg/dL(eAG)")
        (list2 as ArrayList<String>).add("mmol/L(eAG)")
        (list2 as ArrayList<String>).add("NGSP Hb-A1c(%)")
        (list2 as ArrayList<String>).add("IFCC HbA1c(mmol/mol)")


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
                    var1 = mgdl
                }
                if (position == 1) {
                    var1 = mmoll
                }
                if (position == 2) {
                    var1 = hba1c
                }
                if (position == 3) {
                    var1 = mmolmol
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = mgdl
                }
                if (position == 1) {
                    var2 = mmoll
                }
                if (position == 2) {
                    var2 = hba1c
                }
                if (position == 3) {
                    var2 = mmolmol
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@BloodSugar, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {

                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = mgdl / var1
                output = output * var2
                output = output * no

                if (var2 == mgdl) {
                    scale = 0
                }
                if (var2 == mmoll) {
                    scale = 1
                }
                if (var2 == hba1c) {
                    scale = 2
                }
                if (var2 == mmolmol) {
                    scale = 3
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