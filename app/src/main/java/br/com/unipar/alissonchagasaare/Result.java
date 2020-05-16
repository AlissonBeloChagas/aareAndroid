package br.com.unipar.alissonchagasaare;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        valores();

    }

    public void valores() {
        Bundle x = getIntent().getExtras();
        Double LPA = x.getDouble("LPA");
        Double PL = x.getDouble("PL");
        Double ROE = x.getDouble("ROE");
        Double VPA = x.getDouble("VPA");
        Double PVP = x.getDouble("PVP");

        TextView textElement = (TextView) findViewById(R.id.lpaResult);
        textElement.setText(LPA.toString());

        TextView textElement1 = (TextView) findViewById(R.id.plResult);
        textElement1.setText(PL.toString());

        TextView textElement2 = (TextView) findViewById(R.id.roeResult);
        textElement2.setText(ROE.toString());

        TextView textElement3 = (TextView) findViewById(R.id.vpaResult);
        textElement3.setText(VPA.toString());


        TextView textElement4 = (TextView) findViewById(R.id.pvpResult);
        textElement4.setText(PVP.toString());
    }
}