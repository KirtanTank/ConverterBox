package com.androidman.converterbox

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import com.androidman.converterbox.MainActivity.Companion.redirectActivity
import kotlinx.android.synthetic.main.activity_currency.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL


class Currency : AppCompatActivity() {

    var imagebutton: ImageView? = null

    ///Initialize variable
    private var textmarquee: TextView? = null

    var baseCurrency = "EUR"
    var convertedToCurrency = "USD"
    private var conversionRate = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)

        val animDrawable = currency_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes12.startAnimation(anim)

        imagebutton = findViewById(R.id.backbutton)

        textmarquee = findViewById(R.id.marquee)

        textmarquee?.run { isSelected = true }

        spinnerSetup()
        textChangedStuff()

        imagebutton!!.setOnClickListener(View.OnClickListener {

            redirectActivity(this, MainActivity2::class.java)
            finish()

        })
    }

    private fun textChangedStuff() {

        val et_firstConversion: EditText = findViewById(R.id.et_firstConversion)
        var et_secondConversion: TextView = findViewById(R.id.et_secondConversion)

        et_firstConversion.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
                try {
                    getApiResult()
                } catch (e: Exception) {
                    Toast.makeText(applicationContext, "Type a value", Toast.LENGTH_SHORT).show()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("Main", "Before Text Changed")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("Main", "OnTextChanged")
            }

        })

    }

    private fun getApiResult() {
        var et_firstConversion: EditText = findViewById(R.id.et_firstConversion)
        var et_secondConversion: TextView = findViewById(R.id.et_secondConversion)

        if (et_firstConversion != null && et_firstConversion.text.isNotEmpty() && et_firstConversion.text.isNotBlank()) {

            val API =
                "https://api.ratesapi.io/api/latest?base=$baseCurrency&symbols=$convertedToCurrency"

            if (baseCurrency == convertedToCurrency) {
                Toast.makeText(
                    applicationContext,
                    "Please pick a currency to convert",
                    Toast.LENGTH_SHORT
                ).show()
            } else {

                GlobalScope.launch(Dispatchers.IO) {

                    try {

                        val apiResult = URL(API).readText()
                        val jsonObject = JSONObject(apiResult)
                        conversionRate =
                            jsonObject.getJSONObject("rates").getString(convertedToCurrency)
                                .toFloat()

                        Log.d("Main", "$conversionRate")
                        Log.d("Main", apiResult)

                        withContext(Dispatchers.Main) {
                            val text =
                                ((et_firstConversion.text.toString()
                                    .toFloat()) * conversionRate).toString()
                            et_secondConversion.setText(text)

                        }

                    } catch (e: Exception) {
                        Log.e("Main", "$e")
                    }
                }
            }
        }
    }

    private fun spinnerSetup() {
        val spinner: Spinner = findViewById(R.id.spinner_firstConversion)
        val spinner2: Spinner = findViewById(R.id.spinner_secondConversion)

        ArrayAdapter.createFromResource(
            this,
            R.array.currencies,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner.adapter = adapter

        }

        ArrayAdapter.createFromResource(
            this,
            R.array.currencies2,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner2.adapter = adapter

        }

        spinner.onItemSelectedListener = (object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                baseCurrency = parent?.getItemAtPosition(position).toString()
                getApiResult()
            }

        })

        spinner2.onItemSelectedListener = (object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                convertedToCurrency = parent?.getItemAtPosition(position).toString()
                getApiResult()
            }

        })

    }
}
