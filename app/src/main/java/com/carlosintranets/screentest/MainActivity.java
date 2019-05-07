package com.carlosintranets.screentest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] letras = {"a","b","c","d","e","f","g","h"};
    private String[] celdas = new String[63*63];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout tablero=null;
        int btid=0;
        int inicia ;
        for(int i=0;i<8;i++) {

            if (i%2==0) {
                inicia = 1;
            } else {
                inicia = 0;
            }

            switch (i){
                case 0: tablero = (LinearLayout) findViewById(R.id.horizontal1);break;
                case 1: tablero = (LinearLayout) findViewById(R.id.horizontal2);break;
                case 2: tablero = (LinearLayout) findViewById(R.id.horizontal3);break;
                case 3: tablero = (LinearLayout) findViewById(R.id.horizontal4);break;
                case 4: tablero = (LinearLayout) findViewById(R.id.horizontal5);break;
                case 5: tablero = (LinearLayout) findViewById(R.id.horizontal6);break;
                case 6: tablero = (LinearLayout) findViewById(R.id.horizontal7);break;
                case 7: tablero = (LinearLayout) findViewById(R.id.horizontal8);break;
            }


            for(int j=0;j<8;j++) {

                celdas[btid]=letras[j] + (8-i );

                Button bt = new Button(this);
                bt.setId(btid);
                bt.setText(celdas[btid]);

                bt.setWidth(70);
                bt.setHeight(70);
                if ( inicia==0) {
                    bt.setBackgroundColor(Color.BLACK);
                    inicia=1;
                } else {
                    bt.setBackgroundColor(Color.WHITE);
                    inicia=0;
                }

                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String celda = celdas[v.getId()];
                        Toast msg = Toast.makeText(getApplicationContext(), "Hasta pulsado click en " + celda, Toast.LENGTH_LONG);
                        msg.show();
                    }
                });

                Log.i("Tablero","Agregando en ID "+tablero.getId());
                tablero.addView(bt);
                btid++;
            }
        }

    }
}
