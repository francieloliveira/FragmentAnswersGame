package com.example.fragmentanswersgame.service;


import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.fragmentanswersgame.dao.AppDatabase;
import com.example.fragmentanswersgame.dao.entity.Questoes;

import java.util.ArrayList;
import java.util.List;

public class QuestaoService {

    /**
     * Método para inserir QUestões no BD
     * @param activity
     * @param questoes
     * @throws Exception
     */
    public void inserir(FragmentActivity activity, @NonNull Questoes questoes) throws Exception {
        if (questoes.getPergunta() != null && questoes.getResposta() != null) {
            try{
                AppDatabase.getAppDatabase(activity).questoesDAO().insert(questoes);
            }catch(Exception e){
                throw new IllegalAccessException("Erro inserindo pergunta");
            }
        }else{
            throw new Exception("Algum campo está em branco");
        }
    }

    public List<Questoes> getQuestoes(FragmentActivity activity) throws Exception {
        List<Questoes> questoesList;
        try {
            questoesList = AppDatabase.getAppDatabase(activity).questoesDAO().getAll();
        } catch (Exception e) {
            throw new Exception("Não foi possível buscar as questões");
        }
        return questoesList;
    }
}
