package com.carlosintranets.screentest;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] letras = {"a","b","c","d","e","f","g","h"};
    private String[] celdas = new String[63*63];
    private List<Integer> idBotones = new ArrayList();
    Tablero tab = new Tablero();
    int btid ;
    int inicia ;
    LinearLayout fila;
    Activity esta = this;
    int errores=0;
    int reinas=8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botreiniciar =  (Button) findViewById(R.id.botreiniciar);

        botreiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tab.Clear();
                botonesUtil.limpiarTablero(esta,idBotones);
                errores=0;
                reinas=8;
                TextView textErrores = (TextView) findViewById(R.id.errores);
                textErrores.setText("Errores : "+errores);

                TextView textReinas = (TextView) findViewById(R.id.reinas);
                textReinas.setText("Reinas restantes : "+reinas);


            }
        });

        btid = 0;
        for(int i=0;i<8;i++) {

            if (i%2==0) {
                inicia = 1;
            } else {
                inicia = 0;
            }

            switch (i){
                case 0: fila = (LinearLayout) findViewById(R.id.horizontal1);break;
                case 1: fila = (LinearLayout) findViewById(R.id.horizontal2);break;
                case 2: fila = (LinearLayout) findViewById(R.id.horizontal3);break;
                case 3: fila = (LinearLayout) findViewById(R.id.horizontal4);break;
                case 4: fila = (LinearLayout) findViewById(R.id.horizontal5);break;
                case 5: fila = (LinearLayout) findViewById(R.id.horizontal6);break;
                case 6: fila = (LinearLayout) findViewById(R.id.horizontal7);break;
                case 7: fila = (LinearLayout) findViewById(R.id.horizontal8);break;
            }


            for(int j=0;j<8;j++) {

                celdas[btid]=letras[j] + (8-i );

                Button bt = new Button(this);
                bt.setId(btid);
                idBotones.add(btid);

                bt.setWidth(70);
                bt.setHeight(70);
                if ( inicia==0) {
                    bt.setBackgroundColor(Color.BLACK);
                    bt.setTextColor(Color.BLACK);
                    bt.setText("B");
                    inicia=1;
                } else {
                    bt.setBackgroundColor(Color.WHITE);
                    bt.setTextColor(Color.WHITE);
                    bt.setText("W");
                    inicia=0;
                }

                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String celda = celdas[v.getId()];
                        Button boton = (Button) findViewById(v.getId());

                        if (tab.setCeldaEstado(Tablero.CELDA_REINA,v.getId())) {
                            boton.setBackgroundColor(Color.GREEN);
                            boton.setTextColor(Color.GREEN);

                            reinas --;


                        } else {
                            boton.setBackgroundColor(Color.RED);
                            boton.setTextColor(Color.RED);
                            errores++;

                            if (errores>4) {
                                errores =0;
                                Toast mes = Toast.makeText(esta,
                                        "Muchos errores, re reinicia el juego",
                                        Toast.LENGTH_SHORT);
                                mes.show();
                                tab.Clear();
                                errores=0;
                                reinas=8;
                                botonesUtil.limpiarTablero(esta,idBotones);


                            }

                        }

                        TextView textErrores = (TextView) findViewById(R.id.errores);
                        textErrores.setText("Errores : "+errores);

                        TextView textReinas = (TextView) findViewById(R.id.reinas);
                        textReinas.setText("Reinas restantes : "+reinas);

                    }
                });


                fila.addView(bt);
                btid++;
            }
        }



    }
}
