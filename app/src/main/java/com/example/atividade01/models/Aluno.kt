package com.example.atividade01.models
import kotlinx.android.synthetic.main.activity_main.*

data class Aluno(
    val aluno_nome:String,
    val nota_01:Float,
    val nota_02:Float,
    val nota_03:Float,
    val media:Float
)

class AlunoBuilder {
    var aluno_nome = " "
    var nota_01 = 0.0f
    var nota_02 = 0.0f
    var nota_03 = 0.0f
    var media = 0.0f

    fun build():Aluno = Aluno(aluno_nome,nota_01,nota_02 ,nota_03,media)

}

fun aluno(block: AlunoBuilder.() -> Unit): Aluno = AlunoBuilder().apply(block).build()

fun fakeAlunos() = mutableListOf<Aluno>(
    aluno {
        aluno_nome = "Manoel vitor"
        nota_01 = 10.0f
        nota_02 = 9.0f
        nota_03 = 10.0f
        media = (nota_01 + nota_02 + nota_03)/3
    },
    aluno {
        aluno_nome = "Olivia Sousa Rodrigues"
        nota_01 = 10.0f
        nota_02 = 9.0f
        nota_03 = 10.0f
        media = (nota_01 + nota_02 + nota_03)/3
    },
    aluno {
        aluno_nome = "Geovana silva de sousa"
        nota_01 = 10.0f
        nota_02 = 9.0f
        nota_03 = 10.0f
        media = (nota_01 + nota_02 + nota_03)/3
    }

)