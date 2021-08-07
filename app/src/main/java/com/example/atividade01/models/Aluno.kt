package com.example.atividade01.models
import android.os.Parcel
import android.os.Parcelable


data class Aluno(
    val aluno_nome:String,
    val nota_01:Float,
    val nota_02:Float,
    val nota_03:Float,
    val media:Float
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(aluno_nome)
        parcel.writeFloat(nota_01)
        parcel.writeFloat(nota_02)
        parcel.writeFloat(nota_03)
        parcel.writeFloat(media)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Aluno> {
        override fun createFromParcel(parcel: Parcel): Aluno {
            return Aluno(parcel)
        }

        override fun newArray(size: Int): Array<Aluno?> {
            return arrayOfNulls(size)
        }
    }
}

class AlunoBuilder {
    var aluno_nome = " "
    var nota_01 = 0.0f
    var nota_02 = 0.0f
    var nota_03 = 0.0f
    var media =  0.0f

    fun build():Aluno = Aluno(aluno_nome,nota_01,nota_02 ,nota_03,(nota_01 + nota_02 + nota_03)/3)

}

fun aluno(block: AlunoBuilder.() -> Unit): Aluno = AlunoBuilder().apply(block).build()

fun fakeAlunos() = mutableListOf<Aluno>(
    aluno {
        aluno_nome = "Manoel vitor"
        nota_01 = 7.0f
        nota_02 = 9.0f
        nota_03 = 10.0f

    },
    aluno {
        aluno_nome = "Olivia Sousa Rodrigues"
        nota_01 = 10.0f
        nota_02 = 9.0f
        nota_03 = 10.0f

    },
    aluno {
        aluno_nome = "Geovana silva de sousa"
        nota_01 = 10.0f
        nota_02 = 8.0f
        nota_03 = 9.0f

    }

)