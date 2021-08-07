package com.example.atividade01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.atividade01.models.Aluno
import kotlinx.android.synthetic.main.activity_cadastrar_aluno.*

class Cadastrar_aluno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_aluno)

        cadastra_btn.setOnClickListener(){
            send_aluno_to_create()
        }
        cancel_btn.setOnClickListener(){
            to_list_aluno()
        }


    }
    fun to_list_aluno(){
        val it = Intent(this,ListaAlunos::class.java)
        startActivity(it)
    }

    fun send_aluno_to_create(){
        val it:Intent = Intent(this,ListaAlunos::class.java)
        it.putExtra("info","if")
        it.putExtra("nome",id_editNome.text.toString())
        it.putExtra("nota1",id_nota1.text)
        it.putExtra("nota2",id_nota2.text)
        it.putExtra("nota3",id_nota3.text)


        startActivity(it)

    }



}