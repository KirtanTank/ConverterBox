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
import kotlinx.android.synthetic.main.activity_radiation.*
import java.util.*


class Radiation : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var scale = 0
    var units = arrayOf("Sv/hr(Gy)", "mSv/hr", "μSv/hr", "nSv/hr", "rem/hr(rad)", "mrem/hr", "μrem/hr", "nrem/hr", "Sv/min",
               "mSv/min", "μSv/min", "nSv/min", "rem/min", "mrem/min", "μrem/min", "nrem/min", "Sv/s", "mSv/s",
                "μSv/s", "nSv/s", "rem/s", "mrem/s", "μrem/s", "nrem/s", "CTDI", "Gy")
    val svhr = 1.0
    var msvhr = 1000.0
    var μsvhr = 1000000.0
    var nsvhr = 1000000000.0
    var remhr = 100.0
    var mremhr = 100000.0
    var μremhr = 100000000.0
    var nremhr = 100000000000.0
    var svmin = 0.016666666666666666
    var msvmin = 16.666666666666668
    var μsvmin = 16666.666666666668
    var nsvmin = 16666666.666666666
    var remmin = 1.6666666666666667
    var mremmin = 1666.6666666666667
    var μremmin = 1666666.6666666667
    var nremmin = 1666666666.6666667
    var svs = 0.0002777777777777778
    var msvs = 0.2777777777777778
    var μsvs = 277.77777777777777
    var nsvs = 277777.77777777775
    var rems = 0.027777777777777776
    var mrems = 27.777777777777775
    var μrems = 27777.777777777777
    var nrems = 27777777.777777776
    var ctdi = 10.0

    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radiation)

        val animDrawable = radiation_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes27.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("Sv/hr(Gy)")
        (list1 as ArrayList<String>).add("mSv/hr")
        (list1 as ArrayList<String>).add("μSv/hr")
        (list1 as ArrayList<String>).add("nSv/hr")
        (list1 as ArrayList<String>).add("rem/hr(rad)")
        (list1 as ArrayList<String>).add("mrem/hr")
        (list1 as ArrayList<String>).add("μrem/hr")
        (list1 as ArrayList<String>).add("nrem/hr")
        (list1 as ArrayList<String>).add("Sv/min")
        (list1 as ArrayList<String>).add("mSv/min")
        (list1 as ArrayList<String>).add("μSv/min")
        (list1 as ArrayList<String>).add("nSv/min")
        (list1 as ArrayList<String>).add("rem/min")
        (list1 as ArrayList<String>).add("mrem/min")
        (list1 as ArrayList<String>).add("μrem/min")
        (list1 as ArrayList<String>).add("nrem/min")
        (list1 as ArrayList<String>).add("Sv/s")
        (list1 as ArrayList<String>).add("mSv/s")
        (list1 as ArrayList<String>).add("μSv/s")
        (list1 as ArrayList<String>).add("nSv/s")
        (list1 as ArrayList<String>).add("rem/s")
        (list1 as ArrayList<String>).add("mrem/s")
        (list1 as ArrayList<String>).add("μrem/s")
        (list1 as ArrayList<String>).add("nrem/s")
        (list1 as ArrayList<String>).add("CTDI")

        (list2 as ArrayList<String>).add("Sv/hr(Gy)")
        (list2 as ArrayList<String>).add("mSv/hr")
        (list2 as ArrayList<String>).add("μSv/hr")
        (list2 as ArrayList<String>).add("nSv/hr")
        (list2 as ArrayList<String>).add("rem/hr(rad)")
        (list2 as ArrayList<String>).add("mrem/hr")
        (list2 as ArrayList<String>).add("μrem/hr")
        (list2 as ArrayList<String>).add("nrem/hr")
        (list2 as ArrayList<String>).add("Sv/min")
        (list2 as ArrayList<String>).add("mSv/min")
        (list2 as ArrayList<String>).add("μSv/min")
        (list2 as ArrayList<String>).add("nSv/min")
        (list2 as ArrayList<String>).add("rem/min")
        (list2 as ArrayList<String>).add("mrem/min")
        (list2 as ArrayList<String>).add("μrem/min")
        (list2 as ArrayList<String>).add("nrem/min")
        (list2 as ArrayList<String>).add("Sv/s")
        (list2 as ArrayList<String>).add("mSv/s")
        (list2 as ArrayList<String>).add("μSv/s")
        (list2 as ArrayList<String>).add("nSv/s")
        (list2 as ArrayList<String>).add("rem/s")
        (list2 as ArrayList<String>).add("mrem/s")
        (list2 as ArrayList<String>).add("μrem/s")
        (list2 as ArrayList<String>).add("nrem/s")
        (list2 as ArrayList<String>).add("CTDI")


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
                    var1 = svhr
                }
                if (position == 1) {
                    var1 = msvhr
                }
                if (position == 2) {
                    var1 = μsvhr
                }
                if (position == 3) {
                    var1 = nsvhr
                }
                if (position == 4) {
                    var1 = remhr
                }
                if (position == 5) {
                    var1 = mremhr
                }
                if (position == 6) {
                    var1 = μremhr
                }
                if (position == 7) {
                    var1 = nremhr
                }
                if (position == 8) {
                    var1 = svmin
                }
                if (position == 9) {
                    var1 = msvmin
                }
                if (position == 10) {
                    var1 = μsvmin
                }
                if (position == 11) {
                    var1 = nsvmin
                }
                if (position == 12) {
                    var1 = remmin
                }
                if (position == 13) {
                    var1 = mremmin
                }
                if (position == 14) {
                    var1 = μremmin
                }
                if (position == 15) {
                    var1 = nremmin
                }
                if (position == 16) {
                    var1 = svs
                }
                if (position == 17) {
                    var1 = msvs
                }
                if (position == 18) {
                    var1 = μsvs
                }
                if (position == 19) {
                    var1 = nsvs
                }
                if (position == 20) {
                    var1 = rems
                }
                if (position == 21) {
                    var1 = mrems
                }
                if (position == 22) {
                    var1 = μrems
                }
                if (position == 23) {
                    var1 = nrems
                }
                if (position == 24) {
                    var1 = ctdi
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = svhr
                }
                if (position == 1) {
                    var2 = msvhr
                }
                if (position == 2) {
                    var2 = μsvhr
                }
                if (position == 3) {
                    var2 = nsvhr
                }
                if (position == 4) {
                    var2 = remhr
                }
                if (position == 5) {
                    var2 = mremhr
                }
                if (position == 6) {
                    var2 = μremhr
                }
                if (position == 7) {
                    var2 = nremhr
                }
                if (position == 8) {
                    var2 = svmin
                }
                if (position == 9) {
                    var2 = msvmin
                }
                if (position == 10) {
                    var2 = μsvmin
                }
                if (position == 11) {
                    var2 = nsvmin
                }
                if (position == 12) {
                    var2 = remmin
                }
                if (position == 13) {
                    var2 = mremmin
                }
                if (position == 14) {
                    var2 = μremmin
                }
                if (position == 15) {
                    var2 = nremmin
                }
                if (position == 16) {
                    var2 = svs
                }
                if (position == 17) {
                    var2 = msvs
                }
                if (position == 18) {
                    var2 = μsvs
                }
                if (position == 19) {
                    var2 = nsvs
                }
                if (position == 20) {
                    var2 = rems
                }
                if (position == 21) {
                    var2 = mrems
                }
                if (position == 22) {
                    var2 = μrems
                }
                if (position == 23) {
                    var2 = nrems
                }
                if (position == 24) {
                    var2 = ctdi
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {

            clickbutton.start()
            if (input_number!!.length() == 0) {

                Toast.makeText(this@Radiation, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = svhr / var1
                output = output * var2
                output = output * no

                if (var2 == svhr) {
                    scale = 0
                }
                if (var2 == msvhr) {
                    scale = 1
                }
                if (var2 == μsvhr) {
                    scale = 2
                }
                if (var2 == nsvhr) {
                    scale = 3
                }
                if (var2 == remhr) {
                    scale = 4
                }
                if (var2 == mremhr) {
                    scale = 5
                }
                if (var2 == μremhr) {
                    scale = 6
                }
                if (var2 == nremhr) {
                    scale = 7
                }
                if (var2 == svmin) {
                    scale = 8
                }
                if (var2 == msvmin){
                    scale = 9
                }
                if (var2 == μsvmin){
                    scale = 10
                }
                if (var2 == nsvmin){
                    scale = 11
                }
                if (var2 == remmin){
                    scale = 12
                }
                if (var2 == mremmin){
                    scale = 13
                }
                if (var2 == μremmin){
                    scale = 14
                }
                if (var2 == nremmin){
                    scale = 15
                }
                if (var2 == svs){
                    scale = 16
                }
                if (var2 == msvs){
                    scale = 17
                }
                if (var2 == μsvs){
                    scale = 18
                }
                if (var2 == nsvs){
                    scale = 19
                }
                if (var2 == rems){
                    scale = 20
                }
                if (var2 == mrems){
                    scale = 21
                }
                if (var2 == μrems){
                    scale = 22
                }
                if (var2 == nrems){
                    scale = 23
                }
                if (var2 == ctdi){
                    scale = 24
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