package com.example.fragmentanswersgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentJogar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentJogar extends Fragment {

    private Button mButtonCadastrarPerguntasRespostas;
    private Button mButtonExibirRespostas;
    private Button mButtonPular;

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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mButtonExibirRespostas = view.findViewById(R.id.buttonExibirResposta);
        mButtonPular = view.findViewById(R.id.buttonPular);
        mButtonCadastrarPerguntasRespostas = view.findViewById(R.id.buttonCadastrarPerguntasRespostas);

        mButtonCadastrarPerguntasRespostas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new CadastrarRespostas()).commit();
            }
        });

        mButtonPular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mButtonExibirRespostas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
