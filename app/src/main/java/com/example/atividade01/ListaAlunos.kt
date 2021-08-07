package com.example.atividade01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.atividade01.adapters.Aluno_adapter
import com.example.atividade01.models.Aluno
import com.example.atividade01.models.AlunoBuilder
import com.example.atividade01.models.fakeAlunos
import kotlinx.android.synthetic.main.activity_aluno_info.*
import kotlinx.android.synthetic.main.activity_lista_alunos.*



class ListaAlunos : AppCompatActivity(){
    private  lateinit var myadapter:Aluno_adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_alunos)
        myadapter = Aluno_adapter(fakeAlunos(),this)
        if(intent.getStringExtra("info")=="cadastrar"){
            addAluno(
                intent.getStringExtra("nome").toString(),
                intent.getFloatExtra("nota1",0.0f),
                intent.getFloatExtra("nota2",0.0f),
                intent.getFloatExtra("nota3",0.0f)
                )
//            id_nome.setText(intent.getStringExtra("nome"))
//            nota1.setText("Nota 1: "+intent.getFloatExtra("nota1",0.0f))
//            nota2.setText("Nota 2: "+intent.getFloatExtra("nota2",0.0f))
//            nota3.setText("Nota 3: "+intent.getFloatExtra("nota3",0.0f))
//            media.setText("Média: "+intent.getFloatExtra("media",0.0f))


        }
        initRecyclerView()
        add_button.setOnClickListener(){
            to_Cadastrar_aluno()

        }

    }

    fun to_Cadastrar_aluno(){
        val intent = Intent(this,Cadastrar_aluno::class.java)
        startActivity(intent)
    }

    fun to_aluno_details(aluno:Aluno){
        val intent = Intent(this, Aluno_Info::class.java)
        intent.putExtra("info","if")
        intent.putExtra("nome", aluno.aluno_nome)
        intent.putExtra("nota1", aluno.nota_01)
        intent.putExtra("nota2", aluno.nota_02)
        intent.putExtra("nota3", aluno.nota_03)
        intent.putExtra("media", aluno.media)
        startActivity(intent)

    }
    private fun setup_Recycler() {

        if (myadapter.alunos.size > 0){
            aluno_recyclerView.visibility = View.VISIBLE
            aluno_recyclerView.adapter = Aluno_adapter(fakeAlunos(),this)
            aluno_recyclerView.layoutManager = LinearLayoutManager(this)

        }else{
            aluno_recyclerView.visibility = View.GONE

        }

    }
    private fun initRecyclerView() {
        aluno_recyclerView.apply {
            adapter = myadapter
            layoutManager = LinearLayoutManager(this@ListaAlunos)
        }
    }
    private fun addAluno(nome:String,n1:Float,n2:Float,n3:Float){
        myadapter.alunos.add(0,
            com.example.atividade01.models.aluno {
                aluno_nome = nome
                nota_01 = n1
                nota_02 = n2
                nota_03 = n3

            }
        )
        myadapter.notifyItemInserted(0)
    }

    }


