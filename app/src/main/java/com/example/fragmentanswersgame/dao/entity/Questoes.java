package com.example.fragmentanswersgame.dao.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Questoes {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "pergunta")
    private String pergunta;
    @ColumnInfo(name = "resposta")
    private String resposta;

    public Questoes(String pergunta, String resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getResposta() {
        return resposta;
    }
}
