package com.example.fragmentanswersgame.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.fragmentanswersgame.R;
import com.example.fragmentanswersgame.dao.entity.Questoes;
import com.example.fragmentanswersgame.service.QuestaoService;

public class CadastrarRespostas extends Fragment {

    //Fields
    private EditText mEditTextPergunta;
    private EditText mEditTextResposta;

    //Entity
    private Questoes questoes;

    //Services
    private QuestaoService questaoService = new QuestaoService();

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

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEditTextPergunta = view.findViewById(R.id.editTextPergunta);
        mEditTextResposta = view.findViewById(R.id.editTextResposta);
        Button mButtonCadastrar = view.findViewById(R.id.buttonCadastrar);
        Button mButtonVoltar = view.findViewById(R.id.buttonVoltar);

        mButtonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pergunta = mEditTextPergunta.getText().toString();
                String resposta = mEditTextResposta.getText().toString();

                questoes = new Questoes(pergunta, resposta);

                try {
                    questaoService.inserir(getActivity(),questoes);
                    Toast.makeText(getActivity(),"Questão inserida com Sucesso!",Toast.LENGTH_SHORT).show();
                    mEditTextPergunta.setText("");
                    mEditTextResposta.setText("");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        mButtonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new FragmentJogar()).commit();
            }
        });
    }
}