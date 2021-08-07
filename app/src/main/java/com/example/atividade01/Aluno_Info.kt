package com.example.atividade01

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.atividade01.models.Aluno
import kotlinx.android.synthetic.main.activity_aluno_info.*

class Aluno_Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aluno_info)


        if(intent.getStringExtra("info")=="if"){
            id_nome.setText(intent.getStringExtra("nome"))
            nota1.setText("Nota 1: "+intent.getFloatExtra("nota1",0.0f))
            nota2.setText("Nota 2: "+intent.getFloatExtra("nota2",0.0f))
            nota3.setText("Nota 3: "+intent.getFloatExtra("nota3",0.0f))
            media.setText("Média: "+intent.getFloatExtra("media",0.0f))


        }
        bn_volta.setOnClickListener(){
            to_list_aluno()
        }



    }

    fun to_list_aluno(){
        val it = Intent(this,ListaAlunos::class.java)
        startActivity(it)
    }
}