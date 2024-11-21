package com.example.movietracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var seekTextView: TextView
    lateinit var checkBox: CheckBox
    lateinit var RadioGroup: RadioGroup
    lateinit var title: TextView
    lateinit var desc: TextView
    lateinit var comment: TextView
    lateinit var button: Button
    lateinit var RadioButton : RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val movies = mutableListOf<Movies>(
            Movies("Władca pierścieni", "LOTR", false, true, "Fajny", 10),
            Movies("Hobbit", "Czyli tam i z powrotem", true, false, "Świetny", 9)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.movieRecycler)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter =  MoviesAdapter(movies)
        recyclerView.adapter = adapter

        val radioButton = findViewById<RadioButton>(R.id.radioButton)
        radioButton.isChecked=true
        val seekTextView = findViewById<TextView>(R.id.seekText)
        val seekBar = findViewById<SeekBar>(R.id.seek)
        val checkBox = findViewById<CheckBox>(R.id.check)
        val radioGroup = findViewById<RadioGroup>(R.id.radio)
        val title = findViewById<TextView>(R.id.title)
        val desc = findViewById<TextView>(R.id.opis)
        val comment = findViewById<TextView>(R.id.comment)
        val button = findViewById<Button>(R.id.dodaj)
        var radioValue = false

        radioGroup.setOnCheckedChangeListener{ _, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            if(radioButton.text=="Film"){
                radioValue=true
            }else{
                radioValue=false
            }
        }

        button.setOnClickListener{
            val tytul = title.text.toString()
            val opis = desc.text.toString()
            val recenzja = comment.text.toString()
            val isWatched = checkBox.isChecked
            val seek = seekTextView.text.toString().toInt()
            val newMovie = Movies(tytul, opis, isWatched, radioValue, recenzja, seek)
            movies.add(newMovie)
            adapter.notifyDataSetChanged()

        }



        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                seekTextView.text = p1.toString();
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })


    }
}