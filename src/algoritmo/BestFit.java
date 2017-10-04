/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import gerais.Memoria;
import gerais.Processo;
import java.util.ArrayList;

/**
 *
 * @author SABRINA
 */
public class BestFit {

    private Memoria memoria;
    private Processo[] processos;

    public BestFit(Memoria memoria, Processo[] processos) {
        this.memoria = memoria;
        this.processos = processos;
    }

    public int cabeEspaco(int tam) {
        int espaco = 0;
        int espacoAnterior = Integer.MAX_VALUE;
        int posicaoMenor = -1;
        int posicaoIni = 0;

        for (int i = 0; i < memoria.getTamanho(); i++) {
            if (memoria.getBuraco(i)) {
                if (espaco == 0) {
                    posicaoIni = i;
                }
                espaco++;
            } else {
                if (espaco == tam) {
                    return posicaoIni;
                }
                if (espaco > tam) {
                    if (espacoAnterior > espaco) {
                        espacoAnterior = espaco;
                        posicaoMenor = posicaoIni;
                    }
                }
                espaco = 0;
            }
        }
        if (espaco == tam) {
            return posicaoIni;
        }
        if (espaco > tam) {
            if (espacoAnterior > espaco) {
                posicaoMenor = posicaoIni;
            }
        }
        return posicaoMenor;
    }

    
}
