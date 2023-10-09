package com.example.fragmentanswersgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastrarRespostas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastrarRespostas extends Fragment {

    private EditText mEditTextPergunta;
    private EditText mEditTextResposta;

    public CadastrarRespostas() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastrar_respostas, container, false);
    }
}