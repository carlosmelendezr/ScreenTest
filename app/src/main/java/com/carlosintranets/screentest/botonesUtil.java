package com.carlosintranets.screentest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.List;

/**
 * Created by Carlos M on 07/05/2019.
 */

public class botonesUtil {

    public static void limpiarTablero(Activity act, List<Integer> idBotones) {
        for(Integer botonId:idBotones ) {

            Button boton = (Button) act.findViewById(botonId);
            if ( boton.getText()=="B") {
                boton.setBackgroundColor(Color.BLACK);
                boton.setTextColor(Color.BLACK);

            } else {
                boton.setBackgroundColor(Color.WHITE);
                boton.setTextColor(Color.WHITE);

            }

        }

    }
}
