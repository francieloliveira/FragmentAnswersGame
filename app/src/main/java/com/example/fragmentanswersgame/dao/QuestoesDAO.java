package com.example.fragmentanswersgame.dao;

import androidx.room.*;

import com.example.fragmentanswersgame.dao.entity.Questoes;

import java.util.List;

@Dao
public interface QuestoesDAO {

    @Insert
    void insert(Questoes questoes);

    @Delete
    void delete(Questoes questoes);

    @Update
    void update(Questoes questoes);

    @Query("SELECT * FROM Questoes WHERE pergunta LIKE :pergunta AND " +
            "Resposta LIKE :resposta LIMIT 1")
    Questoes findByPergunta(String pergunta, String resposta);

    @Query("SELECT * FROM Questoes")
    List<Questoes> getAll();

    @Query("SELECT * FROM Questoes WHERE id IN (:ids)")
    List<Questoes> loadAllByIds(int[] ids);
}
