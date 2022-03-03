package com.cursoandroid.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        opcaoSelecionada("Pedra");
    }

    public void selecionarPapel(View view) {
        opcaoSelecionada("Papel");
    }

    public void selecionarTesoura(View view) {
        opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imagemOpcaoApp = findViewById(R.id.imagemOpcaoApp);

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numero = new Random().nextInt(opcoes.length);

        String opcaoApp = opcoes[numero];
        String opcaoUsuario = opcaoSelecionada;

        switch(opcaoApp) {

            case "Pedra":
                imagemOpcaoApp.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                imagemOpcaoApp.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                imagemOpcaoApp.setImageResource(R.drawable.tesoura);
                break;
        }
        calcularResultado(opcaoApp, opcaoUsuario);
    }

    public void calcularResultado(String opcaoApp, String opcaoUsuario) {

        TextView textoResultado = findViewById(R.id.textoResultado);

        if((opcaoApp.equals("Pedra") && opcaoUsuario.equals("Tesoura")) ||
        (opcaoApp.equals("Tesoura") && opcaoUsuario.equals("Papel")) ||
        (opcaoApp.equals("Papel") && opcaoUsuario.equals("Pedra"))) {

            textoResultado.setText("Você perdeu!!");
        }

        else if((opcaoApp.equals("Tesoura") && opcaoUsuario.equals("Pedra")) ||
        (opcaoApp.equals("Papel") && opcaoUsuario.equals("Tesoura")) ||
        (opcaoApp.equals("Pedra") && opcaoUsuario.equals("Papel"))) {

            textoResultado.setText("Você ganhou!!");
        }

        else {
            textoResultado.setText("Nós Empatamos!!");
        }
    }
}