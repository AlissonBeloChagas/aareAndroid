package br.com.unipar.alissonchagasaare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edAtivo, edlucro_Liquido, edPatrimonio_Liquido, edN_Acoes_emitidas_na_Bolsa, edPreco_Atual;
    Double LPA, PL, ROE, VPA, PVP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularResult(View view){
        calcular();
        telaResult(view);
    }

    public void calcular() {

        //Recuperar os valores
        edAtivo = findViewById(R.id.edAtivo);
        edlucro_Liquido = findViewById(R.id.edlucro_Liquido);
        edPatrimonio_Liquido = findViewById(R.id.edPatrimonio_Liquido);
        edN_Acoes_emitidas_na_Bolsa = findViewById(R.id.edN_Acoes_emitidas_na_Bolsa);
        edPreco_Atual = findViewById(R.id.edPreco_Atual);



        //Converter valores
        Double lucroLiquido = Double.parseDouble(edlucro_Liquido.getText().toString());
        Double patrimonioLiquido = Double.parseDouble(edPatrimonio_Liquido.getText().toString());
        Long numeroAcoesEmitidasNaBolsa = Long.parseLong(edN_Acoes_emitidas_na_Bolsa.getText().toString());
        Double precoAtual = Double.parseDouble(edPreco_Atual.getText().toString());

        // Calcular valores
        LPA = lucroLiquido / numeroAcoesEmitidasNaBolsa;
        PL = precoAtual / LPA;
        ROE = (lucroLiquido / patrimonioLiquido)*100;
        VPA = patrimonioLiquido / numeroAcoesEmitidasNaBolsa;
        PVP = precoAtual / VPA;
    }

    public void telaResult(View view){
        Intent intent = new Intent(this,Result.class);
        Bundle x = new Bundle();
        x.putDouble("LPA", LPA);
        x.putDouble("PL", PL);
        x.putDouble("ROE", ROE);
        x.putDouble("VPA", VPA);
        x.putDouble("PVP", PVP);
        intent.putExtras(x);
        startActivity(intent);
        finish();
    }

}
