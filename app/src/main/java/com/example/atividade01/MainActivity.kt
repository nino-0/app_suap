package com.example.atividade01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enter_button.setOnClickListener(){
            to_aluno_List()
        }

    }

    fun to_aluno_List(){
        val intent = Intent(this,ListaAlunos::class.java)
        startActivity(intent)
    }
}