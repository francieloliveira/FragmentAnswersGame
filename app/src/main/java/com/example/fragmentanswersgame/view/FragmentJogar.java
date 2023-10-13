package com.example.fragmentanswersgame.view;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fragmentanswersgame.R;
import com.example.fragmentanswersgame.dao.entity.Questoes;
import com.example.fragmentanswersgame.service.QuestaoService;
import java.util.ArrayList;
import java.util.List;

public class FragmentJogar extends Fragment {

    private TextView mTextViewPergunta;
    private TextView mTextViewResposta;
    private List<Questoes> mQuestoes = new ArrayList<>();
    private QuestaoService questaoService = new QuestaoService();

    public FragmentJogar() {
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
        return inflater.inflate(R.layout.fragment_jogar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextViewPergunta = view.findViewById(R.id.textViewPergunta);
        mTextViewResposta = view.findViewById(R.id.textViewResposta);
        Button mButtonExibirRespostas = view.findViewById(R.id.buttonExibirResposta);
        Button mButtonPular = view.findViewById(R.id.buttonPular);
        Button mButtonCadastrarPerguntasRespostas = view.findViewById(R.id.buttonCadastrarPerguntasRespostas);

        try {
            mQuestoes = questaoService.getQuestoes(getActivity());
            mTextViewPergunta.setText(mQuestoes.iterator().next().getPergunta());
            mTextViewResposta.setText(mQuestoes.iterator().next().getResposta());
            mTextViewResposta.setVisibility(View.GONE); // Esconde a Resposta
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        mButtonCadastrarPerguntasRespostas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new CadastrarRespostas()).commit();
            }
        });

        mButtonPular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!mQuestoes.isEmpty()) {
                    Questoes questaoAtual = mQuestoes.remove(0);

                    // Define a nova questão no TextView
                    mTextViewPergunta.setText(questaoAtual.getPergunta());
                    mTextViewResposta.setText(questaoAtual.getResposta());
                    mTextViewResposta.setVisibility(View.GONE); // Esconde a Resposta
                } else {
                    Toast.makeText(getActivity(), "Chegou ao fim das questões!", Toast.LENGTH_SHORT).show();
                    // Recarrega todas as questões disponíveis
                    recarregarQuestoes();
                }
            }
        });

        mButtonExibirRespostas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextViewResposta.setVisibility(View.VISIBLE); // Exibe a Resposta
            }
        });
    }

    private void recarregarQuestoes() {
        try {
            mQuestoes = questaoService.getQuestoes(getActivity());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
