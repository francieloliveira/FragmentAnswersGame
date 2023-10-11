package com.example.fragmentanswersgame;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastrarRespostas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastrarRespostas extends Fragment {

    private EditText mEditTextPergunta;
    private EditText mEditTextResposta;

    private Button mButtonCadastrar;
    private Button mButtonVoltar;

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

        mButtonCadastrar = view.findViewById(R.id.buttonCadastrar);
        mButtonVoltar = view.findViewById(R.id.buttonVoltar);

        mButtonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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