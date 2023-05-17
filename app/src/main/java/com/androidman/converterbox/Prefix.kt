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
import kotlinx.android.synthetic.main.activity_prefix.*
import java.util.*


class Prefix : AppCompatActivity() {
    var imagebutton: ImageView? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var scale = 0
    var units = arrayOf("1(one)", "y(yocto)", "z(zepto)", "a(atto)", "f(femto)", "p(pico)", "n(nano)", "μ(micro)",
            "m(milli)", "c(centi)", "d(deci)", "da(deca)", "h(hecto)", "k(kilo)", "M(mega)", "G(giga)",
            "T(tera)", "P(peta)", "E(exa)", "Z(zetta)", "Y(yotta)")
    val _1 = 1.0
    var yocto = 1000000000000000000000000.0
    var zepto = 1000000000000000000000.0
    var a = 1000000000000000000.0
    var f = 1000000000000000.0
    var pico = 1000000000000.0
    var n = 1000000000.0
    var μ = 1000000.0
    var milli = 1000.0
    var c = 100.0
    var d = 10.0
    var da = 0.1
    var h = 0.01
    var k = 0.001
    var Mega = 0.000001
    var G = 0.000000001
    var T = 0.000000000001
    var P = 0.000000000000001
    var E = 0.000000000000000001
    var Z = 0.000000000000000000001
    var Y = 0.000000000000000000000001

    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prefix)

        val animDrawable = prefix_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes25.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()

        (list1 as ArrayList<String>).add("1")
        (list1 as ArrayList<String>).add("y(yocto)")
        (list1 as ArrayList<String>).add("z(zepto)")
        (list1 as ArrayList<String>).add("a(atto)")
        (list1 as ArrayList<String>).add("f(femto)")
        (list1 as ArrayList<String>).add("p(pico)")
        (list1 as ArrayList<String>).add("n(nano)")
        (list1 as ArrayList<String>).add("μ(micro)")
        (list1 as ArrayList<String>).add("m(milli)")
        (list1 as ArrayList<String>).add("c(centi)")
        (list1 as ArrayList<String>).add("d(deci)")
        (list1 as ArrayList<String>).add("da(deca)")
        (list1 as ArrayList<String>).add("h(hecto)")
        (list1 as ArrayList<String>).add("k(kilo)")
        (list1 as ArrayList<String>).add("M(mega)")
        (list1 as ArrayList<String>).add("G(giga)")
        (list1 as ArrayList<String>).add("T(tera)")
        (list1 as ArrayList<String>).add("P(peta)")
        (list1 as ArrayList<String>).add("E(exa)")
        (list1 as ArrayList<String>).add("Z(zetta)")
        (list1 as ArrayList<String>).add("Y(yotta)")

        (list2 as ArrayList<String>).add("1")
        (list2 as ArrayList<String>).add("y(yocto)")
        (list2 as ArrayList<String>).add("z(zepto)")
        (list2 as ArrayList<String>).add("a(atto)")
        (list2 as ArrayList<String>).add("f(femto)")
        (list2 as ArrayList<String>).add("p(pico)")
        (list2 as ArrayList<String>).add("n(nano)")
        (list2 as ArrayList<String>).add("μ(micro)")
        (list2 as ArrayList<String>).add("m(milli)")
        (list2 as ArrayList<String>).add("c(centi)")
        (list2 as ArrayList<String>).add("d(deci)")
        (list2 as ArrayList<String>).add("da(deca)")
        (list2 as ArrayList<String>).add("h(hecto)")
        (list2 as ArrayList<String>).add("k(kilo)")
        (list2 as ArrayList<String>).add("M(mega)")
        (list2 as ArrayList<String>).add("G(giga)")
        (list2 as ArrayList<String>).add("T(tera)")
        (list2 as ArrayList<String>).add("P(peta)")
        (list2 as ArrayList<String>).add("E(exa)")
        (list2 as ArrayList<String>).add("Z(zetta)")
        (list2 as ArrayList<String>).add("Y(yotta)")

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
                    var1 = _1
                }
                if (position == 1) {
                    var1 = yocto
                }
                if (position == 2) {
                    var1 = zepto
                }
                if (position == 3) {
                    var1 = a
                }
                if (position == 4) {
                    var1 = f
                }
                if (position == 5) {
                    var1 = pico
                }
                if (position == 6) {
                    var1 = n
                }
                if (position == 7) {
                    var1 = μ
                }
                if (position == 8) {
                    var1 = milli
                }
                if (position == 9) {
                    var1 = c
                }
                if (position == 10) {
                    var1 = d
                }
                if (position == 11) {
                    var1 = da
                }
                if (position == 12) {
                    var1 = h
                }
                if (position == 13) {
                    var1 = k
                }
                if (position == 14) {
                    var1 = Mega
                }
                if (position == 15) {
                    var1 = G
                }
                if (position == 16) {
                    var1 = T
                }
                if (position == 17) {
                    var1 = P
                }
                if (position == 18) {
                    var1 = E
                }
                if (position == 19) {
                    var1 = Z
                }
                if (position == 20) {
                    var1 = Y
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = _1
                }
                if (position == 1) {
                    var2 = yocto
                }
                if (position == 2) {
                    var2 = zepto
                }
                if (position == 3) {
                    var2 = a
                }
                if (position == 4) {
                    var2 = f
                }
                if (position == 5) {
                    var2 = pico
                }
                if (position == 6) {
                    var2 = n
                }
                if (position == 7) {
                    var2 = μ
                }
                if (position == 8) {
                    var2 = milli
                }
                if (position == 9) {
                    var2 = c
                }
                if (position == 10) {
                    var2 = d
                }
                if (position == 11) {
                    var2 = da
                }
                if (position == 12) {
                    var2 = h
                }
                if (position == 13) {
                    var2 = k
                }
                if (position == 14) {
                    var2 = Mega
                }
                if (position == 15) {
                    var2 = G
                }
                if (position == 16) {
                    var2 = T
                }
                if (position == 17) {
                    var2 = P
                }
                if (position == 18) {
                    var2 = E
                }
                if (position == 19) {
                    var2 = Z
                }
                if (position == 20) {
                    var2 = Y
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Prefix, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = _1 / var1
                output = output * var2
                output = output * no

                if (var2 == _1) {
                    scale = 0
                }
                if (var2 == yocto) {
                    scale = 1
                }
                if (var2 == zepto) {
                    scale = 2
                }
                if (var2 == a) {
                    scale = 3
                }
                if (var2 == f) {
                    scale = 4
                }
                if (var2 == pico) {
                    scale = 5
                }
                if (var2 == n) {
                    scale = 6
                }
                if (var2 == μ) {
                    scale = 7
                }
                if (var2 == milli) {
                    scale = 8
                }
                if (var2 == c){
                    scale = 9
                }
                if (var2 == d){
                    scale = 10
                }
                if (var2 == da){
                    scale = 11
                }
                if (var2 == h){
                    scale = 12
                }
                if (var2 == k){
                    scale = 13
                }
                if (var2 == Mega){
                    scale = 14
                }
                if (var2 == G){
                    scale = 15
                }
                if (var2 == T){
                    scale = 16
                }
                if (var2 == P){
                    scale = 17
                }
                if (var2 == E){
                    scale = 18
                }
                if (var2 == Z){
                    scale = 19
                }
                if (var2 == Y){
                    scale = 20
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