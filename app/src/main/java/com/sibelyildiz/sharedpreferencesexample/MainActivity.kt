package com.sibelyildiz.sharedpreferencesexample

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val PREFS_FILENAME = "com.sibelyildiz.sharedpreferencesexample"
    val KEY_NAME = "NAME"
    val KEY_AGE = "AGE"
    val KEY_HEIGHT = "HEIGHT"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferences = getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
        val editor = preferences.edit()

        Toast.makeText(
            applicationContext,
            "Name : ${preferences.getString(KEY_NAME, "DEFAULT_VALUE")}\n" +
                    "Age : ${preferences.getInt(KEY_AGE, 0)}\n" +
                    "Height ${preferences.getFloat(KEY_HEIGHT, 0f)}"
            , Toast.LENGTH_SHORT
        ).show()

        btn_save.setOnClickListener {

            editor.putString(KEY_NAME, tv_name.text.toString())
            editor.putInt(KEY_AGE, tv_age.text.toString().toInt())
            editor.putFloat(KEY_HEIGHT, tv_height.text.toString().toFloat())


            editor.apply()

            Toast.makeText(applicationContext, "Kayıt Başarılı", Toast.LENGTH_LONG).show()
        }
    }


}