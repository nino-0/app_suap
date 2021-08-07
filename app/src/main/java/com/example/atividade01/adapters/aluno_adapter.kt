package com.example.atividade01.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.atividade01.ListaAlunos
import com.example.atividade01.R
import com.example.atividade01.models.Aluno
import kotlinx.android.synthetic.main.aluno_card.view.*

class Aluno_adapter(val alunos:MutableList<Aluno>,val context: Context):RecyclerView.Adapter<Aluno_adapter.AlunoViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AlunoViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.aluno_card,p0,false)
        return AlunoViewHolder(view)
    }

    override fun onBindViewHolder(p0: AlunoViewHolder, p1: Int) {
        p0.bind(alunos[p1])
    }

    override fun getItemCount(): Int = alunos.size

    inner class AlunoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var linha = itemView.id_card
        fun bind(aluno:Aluno){
            with(aluno){
                itemView.aluno_nome.text = aluno.aluno_nome
                itemView.aluno_media.text = "Média: "+aluno.media

                linha.setOnClickListener {
                    if (context is ListaAlunos){
                        context.to_aluno_details(aluno)

                    }

                }

            }


        }

    }




}
